package com.lgim.hackathon.team4;

import com.lgim.hackathon.team4.location.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrimeResponse {
    private Location location;
    private Integer range;
    private CrimeTotals totals;
    private List<Details> details;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Details {
        private String type;
        private Integer reported;
    }
}
