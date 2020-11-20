package com.lgim.hackathon.team4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrimeTotals {
    private Integer reported;
    private CrimeOutcomes outcomes;
}
