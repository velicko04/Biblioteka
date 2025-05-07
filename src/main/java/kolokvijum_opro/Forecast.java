package kolokvijum_opro;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Forecast{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	public String city;
    public String temperature;
    public String wind;
    public String description;
    
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public Forecast(Long id, String city, String temperature, String wind, String description) {
		super();
		this.id = id;
		this.city = city;
		this.temperature = temperature;
		this.wind = wind;
		this.description = description;
	}
	public Forecast() {
		super();
	}

}
