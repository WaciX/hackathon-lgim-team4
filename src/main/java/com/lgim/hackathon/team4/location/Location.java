package com.lgim.hackathon.team4.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    private BigDecimal longitude;
    private BigDecimal latitude;
}
