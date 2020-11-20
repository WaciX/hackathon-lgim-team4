package com.lgim.hackathon.team4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrimeDetails {
    private String type;
    @Builder.Default
    private Integer reported = 0;
}
