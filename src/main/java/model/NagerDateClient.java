package model;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@RegisterRestClient(configKey = "nager-api")
public interface NagerDateClient {
	

	
	
		
		@GET
		@Path("/AvailableCountries")
		
		List<CountryResponse> getAvailableCountries();
		
		
		@GET
		@Path("NextPublicHolidays/{countryCode}")
		
		List<HolidayResponse> getNextPublicHolidays(@PathParam("countryCode") String countryCode);
		

	}


