package model;

public class CountryResponse {

		private String countryCode;
		private String name;
		
		
		public CountryResponse() {
			super();
		}


		public CountryResponse(String countryCode, String name) {
			super();
			this.countryCode = countryCode;
			this.name = name;
		}


		public String getCountryCode() {
			return countryCode;
		}


		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		@Override
		public String toString() {
			return "CountryResponse [countryCode=" + countryCode + ", name=" + name + "]";
		}
		
		
		
		
	
}
