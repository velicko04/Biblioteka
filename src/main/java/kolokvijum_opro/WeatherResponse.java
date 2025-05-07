package kolokvijum_opro;

import java.util.List;

public class WeatherResponse {
	public String temperature;
	public String wind;
	public String description;
	public List<Forecast> forecast;
	
	public WeatherResponse(String temperature, String wind, String description, List<Forecast> forecast) {
		super();
		this.temperature = temperature;
		this.wind = wind;
		this.description = description;
		this.forecast = forecast;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Forecast> getForecast() {
		return forecast;
	}

	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}

	public WeatherResponse() {
		super();
	}
	
	
}
