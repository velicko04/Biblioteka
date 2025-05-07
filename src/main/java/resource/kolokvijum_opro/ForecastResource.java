package resource.kolokvijum_opro;



import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import kolokvijum_opro.Forecast;
import kolokvijum_opro.GoWeatherClient;
import kolokvijum_opro.WeatherResponse;

@Path("/getForecast")
@Produces(MediaType.APPLICATION_JSON)
public class ForecastResource {

    @Inject
    @RestClient
    GoWeatherClient weatherClient;

    @Inject
    EntityManager em;

    @GET
    @Transactional
    public Forecast getForecast(@QueryParam("city") String city) {
        
        Forecast existing = em
            .createQuery("SELECT f FROM Forecast f WHERE f.city = :city", Forecast.class)
            .setParameter("city", city)
            .getResultStream()
            .findFirst()
            .orElse(null);

        if (existing != null) {
            return existing;
        }

        
        WeatherResponse response = weatherClient.getForecast(city);

       
        Forecast forecast = new Forecast();
        forecast.setCity(city);
        forecast.setTemperature(response.getTemperature());
        forecast.setWind(response.getWind());
        forecast.setDescription(response.getDescription());

        em.persist(forecast); 

        return forecast;
    }
}

