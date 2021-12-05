package it.corso.treno.builder;

import it.corso.treno.fabbrica.ConcreteCargo;
import it.corso.treno.fabbrica.ConcreteCarrozzaPasseggeri;
import it.corso.treno.fabbrica.ConcreteCarrozzaRistorante;
import it.corso.treno.fabbrica.FabbricaTreno;
import it.corso.treno.fabbrica.ConcreteLocomotiva;

public class ConcreteTrenoBuilder extends TrenoBuilder{

	FabbricaTreno factory;
	
	ConcreteLocomotiva getLocomotiva()  {
		return factory.creaLocomotiva() ;
	}
	
	ConcreteCarrozzaPasseggeri getCarrozzaPasseggeri() {
		return factory.creaCarrozzaPasseggeri();
	}

	ConcreteCarrozzaRistorante getCarrozzaRistorante() {
		return factory.creaCarrozzaRistorante();
		
	}
	ConcreteCargo getCargo() {
		return factory.creaCargo();
		
	}

	public void setFactory(FabbricaTreno factory) {
		this.factory = factory;
	}
	
}
