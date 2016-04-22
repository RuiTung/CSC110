public class CO2Data {

	// define a string type with private variable
	private String country;
	
	// define double type with private variables
	private double totalCO2;
	private double roadCO2;
	private double CO2PerPerson;

	// define an int type private variable
	private int carsPerPerson;

	// initialize the variables defined above	
	public CO2Data() {
		country = "";
		totalCO2 = 0;
		roadCO2 = 0;
		CO2PerPerson = 0;
		carsPerPerson = 0;
	}
	
	// create a string type method called getCountry
	// this method return country name
	public String getCountry() {
		return country;
	}
	
	// create a method called setCountry
	// this method will get value from CO2EmissionReport.java
	// then assign these value to country according this.
	public void setCountry(String country) {
		this.country = country;
	}
	
	// create a method called getTotalCO2
	// this method return value of totalCO2
	public double getTotalCO2() {
		return totalCO2;
	}
	
	// create a method called setTotalCO2
	// this method will get value from CO2EmissionReport.java
	// then assign these value to totalCO2 according this.
	public void setTotalCO2(double totalCO2) {
		this.totalCO2 = totalCO2;
	}

	// create a method called getRoadCO2
	// this method return value of roadCO2
	public double getRoadCO2() {
		return roadCO2;
	}
	
	// create a method called setRoadCO2
	// this method will get value from CO2EmissionReport.java
	// then assign these value to roadCO2 according this.
	public void setRoadCO2(double roadCO2) {
		this.roadCO2 = roadCO2;
	}
	
	// create a method called getCO2PerPerson
	// this method returns value of CO2PerPerson
	public double getCO2PerPerson() {
		return CO2PerPerson;
	}
	
	// create a method called setCO2PerPerson
	// this method will get value from CO2EmissionReport.java
	// then assign these value to CO2PerPerson according this.
	public void setCO2PerPerson(double cO2PerPerson) {
		this.CO2PerPerson = cO2PerPerson;
	}
	
	// create a method called getCarsPerPerson
	// this method return values of carsPerPerson
	public int getCarsPerPerson() {
		return carsPerPerson;
	}
	
	// create a method called setCarsPerPerson
	// this method will get value from CO2EmissionReport.java
	// then assign these value to carsPerPerson according this.
	public void setCarsPerPerson(int carsPerPerson) {
		this.carsPerPerson = carsPerPerson;
	}
}
