package com.lgim.hackathon.team4.crime;

import com.lgim.hackathon.team4.CrimeOutcomes;
import com.lgim.hackathon.team4.CrimeResponse;
import com.lgim.hackathon.team4.CrimeTotals;
import com.lgim.hackathon.team4.location.Location;
import com.lgim.hackathon.team4.location.LocationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CrimeTotalStatsService {

    public CrimeTotals getTotals(List<CrimeDetail> crimeDetails) {

        var crimeOutcomes = crimeDetails.stream()
                .map(crimeDetail -> {
                    if (crimeDetail.getOutcomeCategory().isBlank()) {
                        return CrimeOutcomes.builder().noOutcome(1).build();
                    }
                    else if (crimeDetail.getOutcomeCategory().equalsIgnoreCase("Under investigation")) {
                        return CrimeOutcomes.builder().inProgress(1).build();
                    }
                    else if (crimeDetail.getOutcomeCategory().equalsIgnoreCase("Unable to prosecute suspect")) {
                        return CrimeOutcomes.builder().notProsecuted(1).build();
                    }
                    else if (crimeDetail.getOutcomeCategory().equalsIgnoreCase("Investigation complete")) {
                        if (crimeDetail.getContext().equalsIgnoreCase("no suspect identified")) {
                            return CrimeOutcomes.builder().notProsecuted(1).build();
                        }
                        return CrimeOutcomes.builder().prosecuted(1).build();
                    }
                    return CrimeOutcomes.builder().build();
                })
                .reduce(CrimeOutcomes.builder().build(), (crimeOutcomes1, crimeOutcomes2) -> CrimeOutcomes.builder()
                        .noOutcome(crimeOutcomes1.getNoOutcome() + crimeOutcomes2.getNoOutcome())
                        .inProgress(crimeOutcomes1.getInProgress() + crimeOutcomes2.getInProgress())
                        .notProsecuted(crimeOutcomes1.getNotProsecuted() + crimeOutcomes2.getNotProsecuted())
                        .prosecuted(crimeOutcomes1.getProsecuted() + crimeOutcomes2.getProsecuted())
                        .build());

        return CrimeTotals.builder()
                .reported(crimeDetails.size())
                .outcomes(crimeOutcomes)
                .build();
    }
}
