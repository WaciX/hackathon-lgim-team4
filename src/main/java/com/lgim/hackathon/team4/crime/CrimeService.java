package com.lgim.hackathon.team4.crime;

import com.lgim.hackathon.team4.location.Location;
import com.lgim.hackathon.team4.location.LocationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CrimeService {
    @Inject
    @Named("mock")
    CrimeRepository crimeRepository;

    @Inject
    LocationService locationService;

    public List<CrimeDetail> findByLocation(Location location, Integer range, Integer monthsCount) {

        var localDate = LocalDate.now().minusMonths(monthsCount);

        var crimeDetails = crimeRepository.findByFromDate(localDate);

        return crimeDetails.stream()
                .filter(crimeDetail -> {
                    var crimeDetailRangeMeters = locationService.getMaxRangeMeters(location.getLatitude().doubleValue(), location.getLongitude().doubleValue(),
                            crimeDetail.getLatitude().doubleValue(), crimeDetail.getLongitude().doubleValue());
                    return crimeDetailRangeMeters < range;
                })
                .collect(Collectors.toList());
    }
}
