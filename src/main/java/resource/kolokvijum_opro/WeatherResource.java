package resource.kolokvijum_opro;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import kolokvijum_opro.GoWeatherClient;
import kolokvijum_opro.WeatherResponse;

@Path("/vrijeme")
public class WeatherResource {
	 @Inject
	    @RestClient
	    GoWeatherClient weatherService;

	    @GET
	    @Path("/{city}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public WeatherResponse getForecast(@PathParam("city") String city) {
	        return weatherService.getForecast(city);
	    }
	
}
