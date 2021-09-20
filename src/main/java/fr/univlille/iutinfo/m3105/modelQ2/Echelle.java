package fr.univlille.iutinfo.m3105.modelQ2;

public enum Echelle {
	
	CELSIUS("Celsius","C"), FAHRENHEIT("Fahreinheit","F"), KELVIN("Kelvin","K"), RANKINE("Rankine","R"), NEWTON("Newton","N");
	
	private String name;
	private String car;
	
	private Echelle(String n, String c) {
		this.name = n;
		this.car = c;
	}
	
	
	public String getName() {
		return this.name;
	}

	public String getAbbrev() {
		return this.car;
	}

	public double fromKelvin(double d) {
		
		
		switch(this.car) {
			case "C":
				return d - 273.15;
			case "F":
				return (d - 273.15)*9/5 + 32;
			case "R":
				return d*1.8 ;
			case "N":
				return (d -273.15)*0.33;
			case "K" :
				return d;
			default : return 0;
				
		}
		
		
	}
	
	public double toKelvin(double d) {
	
		
		switch(this.car) {
			case "C":
				return d + 273.15;
			case "F":
				return (d - 32)/1.8 + 273.15;
			case "R":
				return d*5/9 ;
			case "N":
				return(d/0.33) + 273.15;
			case "K" :
				return d;
				
			default : return 0;
		}
		
	}

}
