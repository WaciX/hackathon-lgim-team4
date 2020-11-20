package com.lgim.hackathon.team4.location;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/postcodes")
@RegisterRestClient
public interface PostCodeService {
    @GET
    @Path("/{postcode}")
    @Produces("application/json")
    PostCode getByPostCode(@PathParam("postcode") String postcode);
}
