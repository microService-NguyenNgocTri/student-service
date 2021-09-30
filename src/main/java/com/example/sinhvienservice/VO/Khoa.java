package com.example.sinhvienservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Khoa {
    private long Id;
    private String deparmentName;
    private String deparmentAddress;
    private String deparmentCode;
}
