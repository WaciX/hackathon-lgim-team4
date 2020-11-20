package com.lgim.hackathon.team4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrimeRequest {
    private String postcode;
    private Integer range;
    private Integer months;
}
