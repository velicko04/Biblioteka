package kolokvijum_opro;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@RegisterRestClient
public interface GoWeatherClient {

    @GET
    @Path("/weather/{city}")
    WeatherResponse getForecast(@PathParam("city") String city);
}


   
