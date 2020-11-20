package com.lgim.hackathon.team4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrimeOutcomes {
    @Builder.Default
    private final Integer noOutcome = 0;
    @Builder.Default
    private final Integer inProgress = 0;
    @Builder.Default
    private final Integer notProsecuted = 0;
    @Builder.Default
    private final Integer prosecuted = 0;
}
