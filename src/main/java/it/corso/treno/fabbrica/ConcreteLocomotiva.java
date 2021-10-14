package it.corso.treno.fabbrica;

import it.corso.treno.Motrice;
import it.corso.treno.Vagone;

public class ConcreteLocomotiva extends Vagone implements Motrice{

	private double pesoTrainabile;
	
	protected ConcreteLocomotiva(double peso, double pesoTrainabile) {
		this.pesoTrainabile = pesoTrainabile;
		super.setPeso(peso);
		super.setPesoMax(peso);
	}
	
	public void avvia() {
		
	}
	public void aggancia() {
		// TODO Auto-generated method stub
		
	}
	public double getPesoTrainabile() {
		return pesoTrainabile;
	}
		
	public String toString() {
		return "Locomotiva [peso=" + super.getPeso() +", peso trainabile=" + pesoTrainabile +"]";
	}
	
}
