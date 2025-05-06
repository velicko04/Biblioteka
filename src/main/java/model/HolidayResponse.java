package model;

import java.time.LocalDate;
import java.util.Arrays;

public class HolidayResponse {
	
		  	private LocalDate date;
		    private String localName;
		    private String name;
		    private String countryCode;
		    private boolean fixed;
		    private boolean global;
		    private String[] counties;
		    private int launchYear;
		    private String type;
		    
		    
			public HolidayResponse() {
				super();
			}


			public HolidayResponse(LocalDate date, String localName, String name, String countryCode, boolean fixed,
					boolean global, String[] counties, int launchYear, String type) {
				super();
				this.date = date;
				this.localName = localName;
				this.name = name;
				this.countryCode = countryCode;
				this.fixed = fixed;
				this.global = global;
				this.counties = counties;
				this.launchYear = launchYear;
				this.type = type;
			}


			public LocalDate getDate() {
				return date;
			}


			public void setDate(LocalDate date) {
				this.date = date;
			}


			public String getLocalName() {
				return localName;
			}


			public void setLocalName(String localName) {
				this.localName = localName;
			}


			public String getName() {
				return name;
			}


			public void setName(String name) {
				this.name = name;
			}


			public String getCountryCode() {
				return countryCode;
			}


			public void setCountryCode(String countryCode) {
				this.countryCode = countryCode;
			}


			public boolean isFixed() {
				return fixed;
			}


			public void setFixed(boolean fixed) {
				this.fixed = fixed;
			}


			public boolean isGlobal() {
				return global;
			}


			public void setGlobal(boolean global) {
				this.global = global;
			}


			public String[] getCounties() {
				return counties;
			}


			public void setCounties(String[] counties) {
				this.counties = counties;
			}


			public int getLaunchYear() {
				return launchYear;
			}


			public void setLaunchYear(int launchYear) {
				this.launchYear = launchYear;
			}


			public String getType() {
				return type;
			}


			public void setType(String type) {
				this.type = type;
			}


			@Override
			public String toString() {
				return "PublicHolidayResponse [date=" + date + ", localName=" + localName + ", name=" + name
						+ ", countryCode=" + countryCode + ", fixed=" + fixed + ", global=" + global + ", counties="
						+ Arrays.toString(counties) + ", launchYear=" + launchYear + ", type=" + type + "]";
			}
		    
			
			
		    
		    

	}


