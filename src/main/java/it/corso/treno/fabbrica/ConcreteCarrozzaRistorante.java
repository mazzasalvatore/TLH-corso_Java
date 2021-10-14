package it.corso.treno.fabbrica;

import it.corso.treno.Vagone;

public class ConcreteCarrozzaRistorante extends Vagone{

	private int numeroPosti;
	
	protected ConcreteCarrozzaRistorante(int numeroPosti, double peso, double pesoMax) {
		super.setPeso(peso);
		super.setPesoMax(pesoMax);
		this.numeroPosti = numeroPosti;
	}
	
	public void aggancia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "CarrozzaRistorante [numero posti=" + numeroPosti +
//				", posti liberi=" + postiLiberi() + 
				", peso=" + super.getPeso() +", peso MAX=" + super.getPesoMax() +"]";
	}

}