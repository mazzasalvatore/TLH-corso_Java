package it.corso.treno.fabbrica.trenord;

import it.corso.treno.fabbrica.ConcreteCargo;
import it.corso.treno.fabbrica.ConcreteCarrozzaPasseggeri;
import it.corso.treno.fabbrica.ConcreteCarrozzaRistorante;
import it.corso.treno.fabbrica.FabbricaTreno;
import it.corso.treno.fabbrica.ConcreteLocomotiva;

public class TreNordFabbricaTreno implements FabbricaTreno{

	public ConcreteLocomotiva creaLocomotiva() {
		return new TreNordLocomotiva();
	}
	
	public ConcreteCarrozzaPasseggeri creaCarrozzaPasseggeri() {
		return new TreNordCarrozzaPasseggeri();
	}
	
	public ConcreteCarrozzaRistorante creaCarrozzaRistorante() {
		return new TreNordCarrozzaRistorante();
	}

	public ConcreteCargo creaCargo() {
		return new TreNordCargo();
	}
	
}
