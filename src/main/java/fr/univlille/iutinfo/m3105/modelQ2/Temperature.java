package fr.univlille.iutinfo.m3105.modelQ2;

import fr.univlille.iutinfo.m3105.modelQ1.ITemperature;
import fr.univlille.iutinfo.m3105.utils.ConnectableProperty;

public class Temperature extends ConnectableProperty implements ITemperature {
	
	private double temperature;
	private Echelle echelle;

	public Temperature(Echelle celsius) {
		this.temperature = temperature;
		this.echelle = celsius;
	}
	public Temperature(Echelle celsius, double temp) {
		this.temperature = temp;
		this.echelle = celsius;
	}

	public Echelle getEchelle() {
		return this.echelle;
	}

	@Override
	public void setTemperature(double d) {
		this.temperature = d;
		
	}

	@Override
	public Double getTemperature() {
		return temperature;
	}

	@Override
	public void incrementTemperature() {
		temperature++;
		
	}

	@Override
	public void decrementTemperature() {
		temperature--;
		
	}

}
