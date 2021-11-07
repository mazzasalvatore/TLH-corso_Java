package it.corso.treno.fabbrica.italo;

import it.corso.treno.fabbrica.ConcreteCargo;
import it.corso.treno.fabbrica.ConcreteCarrozzaPasseggeri;
import it.corso.treno.fabbrica.ConcreteCarrozzaRistorante;
import it.corso.treno.fabbrica.FabbricaTreno;
import it.corso.treno.fabbrica.ConcreteLocomotiva;

public class ItaloFabbricaTreno implements FabbricaTreno{

	public ConcreteLocomotiva creaLocomotiva() {
		return new ItaloLocomotiva();
	}
	
	public ConcreteCarrozzaPasseggeri creaCarrozzaPasseggeri() {
		return new ItaloCarrozzaPasseggeri();
	}
	
	public ConcreteCarrozzaRistorante creaCarrozzaRistorante() {
		return new ItaloCarrozzaRistorante();
	}

	public ConcreteCargo creaCargo() {
		return new ItaloCargo();
	}

	public String getCompagnia() {
		return "ITALO";
	}
	
}