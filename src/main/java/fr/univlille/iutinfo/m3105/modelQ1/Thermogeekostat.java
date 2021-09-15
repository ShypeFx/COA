package fr.univlille.iutinfo.m3105.modelQ1;

import fr.univlille.iutinfo.m3105.utils.Subject;

public class Thermogeekostat extends Subject implements ITemperature {
	
	private double val;

	@Override
	public void setTemperature(double d) {
		this.val = d;
		
	}

	@Override
	public Double getTemperature() {
		return this.val;
	}

	@Override
	public void incrementTemperature() {
		val++;
		notifyObservers();
	}

	@Override
	public void decrementTemperature() {
		val--;
		notifyObservers();
	}

}
