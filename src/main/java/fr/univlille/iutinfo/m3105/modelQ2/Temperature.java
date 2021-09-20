package fr.univlille.iutinfo.m3105.modelQ2;

import fr.univlille.iutinfo.m3105.modelQ1.ITemperature;
import fr.univlille.iutinfo.m3105.utils.ConnectableProperty;

public class Temperature extends ConnectableProperty implements ITemperature {
	

	private Echelle echelle;

	public Temperature(Echelle celsius) {
		this.echelle = celsius;
	}

	public Echelle getEchelle() {
		return this.echelle;
	}

	@Override
	public void setTemperature(double d) {
		this.setValue(d);
	}

	@Override
	public Double getTemperature() {
		double res = (double)this.getValue();
		return res;
	}

	@Override
	public void incrementTemperature() {
		double res = getTemperature();
		this.setValue(res++);
	}

	@Override
	public void decrementTemperature() {
		double res = getTemperature();
		this.setValue(res--);
	}

}
