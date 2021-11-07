package it.corso.treno.fabbrica.fs;

import it.corso.treno.fabbrica.ConcreteCargo;
import it.corso.treno.fabbrica.ConcreteCarrozzaPasseggeri;
import it.corso.treno.fabbrica.ConcreteCarrozzaRistorante;
import it.corso.treno.fabbrica.FabbricaTreno;
import it.corso.treno.fabbrica.ConcreteLocomotiva;

public class FSFabbricaTreno implements FabbricaTreno{

	public ConcreteLocomotiva creaLocomotiva() {
		return new FSLocomotiva();
	}
	
	public ConcreteCarrozzaPasseggeri creaCarrozzaPasseggeri() {
		return new FSCarrozzaPasseggeri();
	}
	
	public ConcreteCarrozzaRistorante creaCarrozzaRistorante() {
		return new FSCarrozzaRistorante();
	}
	
	public ConcreteCargo creaCargo() {
		return new FSCargo();
	}

	public String getCompagnia() {
		return "FS";
	}
}
