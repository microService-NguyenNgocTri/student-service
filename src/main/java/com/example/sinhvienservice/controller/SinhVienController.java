package com.example.sinhvienservice.controller;

import com.example.sinhvienservice.VO.ResponseTemplateVO;
import com.example.sinhvienservice.entity.SinhVien;
import com.example.sinhvienservice.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sinhvien")

public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    @PostMapping("/")
    public SinhVien saveSinhVien(@RequestBody SinhVien sinhVien){
        return sinhVienService.saveSinhVien(sinhVien);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getSinhVienWithKhoa(@PathVariable("id") Long sinhVienId){
        return sinhVienService.getSinhVienWithKhoa(sinhVienId);
    }
}
