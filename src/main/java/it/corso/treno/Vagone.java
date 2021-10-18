package it.corso.treno;

import it.corso.treno.fabbrica.Carrozza;

public abstract class Vagone implements Carrozza {
//Monica Prova Vagone
	private double peso;
	private double pesoMax;
	
	void aggancia(Vagone vagone) {
		
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}
	
	
}
