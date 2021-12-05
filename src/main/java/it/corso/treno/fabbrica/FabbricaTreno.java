package it.corso.treno.fabbrica;

public interface FabbricaTreno {

	ConcreteLocomotiva creaLocomotiva();
	
	ConcreteCarrozzaPasseggeri creaCarrozzaPasseggeri();

	ConcreteCarrozzaRistorante creaCarrozzaRistorante();
	
	ConcreteCargo creaCargo();

	String getCompagnia();
	
}
