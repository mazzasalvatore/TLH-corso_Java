package it.corso.treno.fabbrica;

import it.corso.treno.Vagone;

public class ConcreteCarrozzaPasseggeri extends Vagone{

	private int numeroPosti;
	private int numeroPostiPrenotati = 0;
	
	protected ConcreteCarrozzaPasseggeri(int numeroPosti, double peso, double pesoMax) {
		this.numeroPosti = numeroPosti;
		super.setPeso(peso);
		super.setPesoMax(pesoMax);
	}
	
	public void aggancia() {
		// TODO Auto-generated method stub
		
	}

	public void prenota() {
		numeroPostiPrenotati++;
		
	}
	public int postiLiberi() {
		return numeroPosti - numeroPostiPrenotati;
		
	}
	
	public int getNumeroPosti() {
		return numeroPosti;
	}
	
	@Override
	public String toString() {
		return "CarrozzaPasseggeri [numero posti=" + numeroPosti + ", posti liberi=" + postiLiberi() +", peso=" + super.getPeso() +", peso MAX=" + super.getPesoMax() +"]";
	}

	
}