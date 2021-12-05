package it.corso.treno.fabbrica.fr;

import it.corso.treno.fabbrica.ConcreteCargo;
import it.corso.treno.fabbrica.ConcreteCarrozzaPasseggeri;
import it.corso.treno.fabbrica.ConcreteCarrozzaRistorante;
import it.corso.treno.fabbrica.FabbricaTreno;
import it.corso.treno.fabbrica.ConcreteLocomotiva;

public class FRFabbricaTreno implements FabbricaTreno{

	public ConcreteLocomotiva creaLocomotiva() {
		return new FRLocomotiva();
	}
	
	public ConcreteCarrozzaPasseggeri creaCarrozzaPasseggeri() {
		return new FRCarrozzaPasseggeri();
	}
	
	public ConcreteCarrozzaRistorante creaCarrozzaRistorante() {
		return new FRCarrozzaRistorante();
	}

	public ConcreteCargo creaCargo() {
		return new FRCargo(); 
	}
	
}
