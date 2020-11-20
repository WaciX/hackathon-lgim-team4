package com.lgim.hackathon.team4;

import com.lgim.hackathon.team4.crime.CrimeService;
import com.lgim.hackathon.team4.crime.CrimeTotalStatsService;
import com.lgim.hackathon.team4.location.LocationService;
import com.lgim.hackathon.team4.location.PostCodeNotFoundException;
import io.quarkus.funqy.Funq;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Optional;

public class CrimeFunction {
    @Inject
    LocationService locationService;

    @Inject
    CrimeService crimeService;

    @Inject
    CrimeTotalStatsService crimeTotalStatsService;

    @Funq
    public CrimeResponse crime(CrimeRequest crimeRequest) throws PostCodeNotFoundException {
        var location = locationService.getLocation(crimeRequest.getPostcode());

        var range = Optional.ofNullable(crimeRequest.getRange()).orElse(1000);
        var monthsCount = Optional.ofNullable(crimeRequest.getMonths()).orElse(12);

        var locationMatchCrimeData = crimeService.findByLocation(location, range, monthsCount);

        var totals = crimeTotalStatsService.getTotals(locationMatchCrimeData);

        return CrimeResponse.builder()
                .location(location)
                .range(range)
                .totals(totals)
                .details(Arrays.asList())
                .build();
    }
}
