package com.lgim.hackathon.team4.crime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Named("mock")
public class CrimeRepositoryMock implements CrimeRepository {

    public List<CrimeDetail> findByFromDate(LocalDate localDate) {
        return Arrays.asList(
                build(8, 1, "Burglary", "Under investigation"),
                build(8, 1, "Anti-social behaviour", ""),
                build(8, 1, "Shoplifting", "Unable to prosecute suspect"),
                build(8, 1, "Violence and sexual offences", "Investigation complete", "no suspect identified"),
                build(8, 1, "Violence and sexual offences", "Investigation complete", "suspect identified")
        );
    }

    private CrimeDetail build(Integer month, Integer latitudeAndLongitude, String crimeType, String outcome, String context) {
        return CrimeDetail.builder()
                .crimeId(UUID.randomUUID().toString())
                .date(LocalDate.of(2020, month, 1))
                .latitude(BigDecimal.valueOf(latitudeAndLongitude))
                .longitude(BigDecimal.valueOf(latitudeAndLongitude))
                .crimeType(crimeType)
                .outcomeCategory(outcome)
                .context(context)
                .build();
    }

    private CrimeDetail build(Integer month, Integer latitudeAndLongitude, String crimeType, String outcome) {
        return build(month, latitudeAndLongitude, crimeType, outcome, "");
    }
}
