package it.corso.treno.fabbrica;

import it.corso.treno.Vagone;

public class ConcreteCargo extends Vagone{

	protected ConcreteCargo(double peso, double pesoMax) {
		super.setPeso(peso);
		super.setPesoMax(pesoMax);
	}
	
	public void aggancia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Cargo [peso=" + super.getPeso() +", peso MAX=" + super.getPesoMax() +"]";
	}
	
}
