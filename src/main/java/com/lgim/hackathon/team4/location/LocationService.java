package com.lgim.hackathon.team4.location;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LocationService {
    @Inject
    @RestClient
    PostCodeService postCodeService;

    public Location getLocation(String postCodeString) throws PostCodeNotFoundException {

        // TODO fetch from DB ?
        var postCode = postCodeService.getByPostCode(postCodeString);
        if (!postCode.getStatus().equals("200")) {
            throw new PostCodeNotFoundException(postCodeString);
        }

        return Location.builder()
                .latitude(postCode.getResult().getLatitude())
                .longitude(postCode.getResult().getLongitude())
                .build();
    }

    // Copied from https://stackoverflow.com/questions/639695/how-to-convert-latitude-or-longitude-to-meters
    public double getMaxRangeMeters(double lat1, double lon1, double lat2, double lon2) {  // generally used geo measurement function
        var R = 6378.137; // Radius of earth in KM
        var dLat = lat2 * Math.PI / 180 - lat1 * Math.PI / 180;
        var dLon = lon2 * Math.PI / 180 - lon1 * Math.PI / 180;
        var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        var d = R * c;
        return d * 1000; // meters
    }
}
