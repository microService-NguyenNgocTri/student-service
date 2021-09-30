package com.example.sinhvienservice.VO;

import com.example.sinhvienservice.entity.SinhVien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private SinhVien sinhVien;
    private Khoa khoa;
}
