package com.example.sinhvienservice.service;

import com.example.sinhvienservice.VO.ResponseTemplateVO;
import com.example.sinhvienservice.entity.SinhVien;

public interface SinhVienService {
    SinhVien saveSinhVien(SinhVien sinhVien);
    ResponseTemplateVO getSinhVienWithKhoa(Long sinhVienId);
}
