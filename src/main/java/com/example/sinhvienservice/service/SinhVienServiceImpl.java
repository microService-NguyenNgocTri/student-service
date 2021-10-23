package com.example.sinhvienservice.service;

import com.example.sinhvienservice.VO.Khoa;
import com.example.sinhvienservice.VO.ResponseTemplateVO;
import com.example.sinhvienservice.entity.SinhVien;
import com.example.sinhvienservice.repository.SinhVienRepository;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SinhVienServiceImpl implements SinhVienService{

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public SinhVien saveSinhVien(SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }


//    @RateLimiter(name = "basic")
    @RateLimiter(name = "multipleRateLimiters_rps_limiter", fallbackMethod = "localCacheGetSinhVien")
    @Override
    public ResponseTemplateVO getSinhVienWithKhoa(Long sinhVienId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        SinhVien sinhVien = sinhVienRepository.findById(sinhVienId).get();
        vo.setSinhVien(sinhVien);
        Khoa khoa = restTemplate.getForObject("http://localhost:9001/khoa/" + sinhVien.getKhoaId(), Khoa.class);
        vo.setKhoa(khoa);
        return vo;
    }

    private ResponseTemplateVO localCacheGetSinhVien(Long sinhVienId, RequestNotPermitted requestNotPermitted){
        return new ResponseTemplateVO(new SinhVien(), new Khoa());
    }
}
