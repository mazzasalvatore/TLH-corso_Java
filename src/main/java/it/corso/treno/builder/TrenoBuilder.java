package it.corso.treno.builder;

import java.util.ArrayList;
import java.util.Collection;

import it.corso.treno.*;
import it.corso.treno.exception.*;
import it.corso.treno.fabbrica.ConcreteCargo;
import it.corso.treno.fabbrica.Carrozza;
import it.corso.treno.fabbrica.ConcreteCarrozzaPasseggeri;
import it.corso.treno.fabbrica.ConcreteCarrozzaRistorante;
import it.corso.treno.fabbrica.ConcreteLocomotiva;

public abstract class TrenoBuilder {

	private Treno treno = new Treno();
	
	public Treno getTreno(String codice, String elenco) throws UserErrorException {
		verificaStringaTreno(codice, elenco);
		Object primoElementoTreno = creaElementoTreno(elenco.substring(0,1));
		Collection<Carrozza> carrozze = carrozze(codice, elenco);
		ArrayList<Vagone> vagoni = new ArrayList<Vagone>();
		// con la cast si verifica che il primo vagone sia una motrice
		vagoni.add((Vagone) (Motrice) primoElementoTreno);
		double pesoTreno = 0;
		for (Carrozza carrozza: carrozze) {
			vagoni.add((Vagone) carrozza);
			pesoTreno = pesoTreno + carrozza.getPesoMax(); 
		}
		if (pesoTreno > ((Motrice) primoElementoTreno).getPesoTrainabile()) {
	    	String messaggio = "!!!Treno " + codice + ": peso treno " + pesoTreno + " supera peso trainabile da motrice " + ((Motrice) primoElementoTreno).getPesoTrainabile() + "!!!";
			UserErrorException UserErrorException = new UserErrorException(messaggio);
			throw UserErrorException;
		}
		
		treno.setCodice(codice);
		treno.setVagoni(vagoni);
		treno.setCompagnia(getCompagnia());		

		return treno;
		
	}
	
	private void verificaStringaTreno(String codice, String elenco) throws UserErrorException {
		String tipoTreno = "";
		Boolean ristoranteGiaPresente = false;
		Boolean primoElemento = true;
		String elementoCodice = "";
		
		for (short posizioneInTesto=0 ; posizioneInTesto< elenco.length(); posizioneInTesto++) {
			elementoCodice = elenco.substring(posizioneInTesto, posizioneInTesto + 1);
			if (primoElemento && !(elementoCodice.equals("H"))) {
		    	String messaggio = "!!!Treno " + codice + ": primo elemento deve essere una locomotiva!!!";
				UserErrorException UserErrorException = new UserErrorException(messaggio);
				throw UserErrorException;	   
			}
			switch (elementoCodice) {
			case "H" :{
				if (!primoElemento) {
			    	String messaggio = "!!!Treno " + codice + ": più di una locomotiva!!!";
					UserErrorException UserErrorException = new UserErrorException(messaggio);
					throw UserErrorException;	 
				}
				break;
			}
			case "P" :{
				if (tipoTreno=="") {
					tipoTreno = "P";
				}
				if (tipoTreno=="C") {
					String messaggio = "!!!Treno " + codice + ": carrozza passeggeri in treno cargo!!!";
					UserErrorException UserErrorException = new UserErrorException(messaggio);
					throw UserErrorException;	 
				}
				break;
			}
			case "R" :{
				if (tipoTreno=="") {
					tipoTreno = "P";
				}
				if (tipoTreno=="C") {
					String messaggio = "!!!Treno " + codice + ": carrozza ristorante in treno cargo!!!";
					UserErrorException UserErrorException = new UserErrorException(messaggio);
					throw UserErrorException;	 
				}
				if (!ristoranteGiaPresente) {
					ristoranteGiaPresente = true;
				}
				else {
					if (ristoranteGiaPresente) {
						String messaggio = "!!!Treno " + codice + ": carrozza ristorante già presente!!!";
						UserErrorException UserErrorException = new UserErrorException(messaggio);
						throw UserErrorException;	 
					}
				}
				break;
			}
			case "C" :{
				if (tipoTreno=="") {
					tipoTreno = "C";
				}
				if (tipoTreno=="P") {
					String messaggio = "!!!Treno " + codice + ": cargo in treno passeggeri!!!";
					UserErrorException UserErrorException = new UserErrorException(messaggio);
					throw UserErrorException;	 
				}
				break;
			}
			default: {
				String messaggio = "!!!Treno " + codice + ": codice vagone " + elementoCodice + " non ammesso!!!";
				UserErrorException UserErrorException = new UserErrorException(messaggio);
				throw UserErrorException;	 
			}
			}
			primoElemento = false;
		}
		
	}
	
	private Object creaElementoTreno (String elementoCodice) {

		switch (elementoCodice) {
			case "H" :{
				return getLocomotiva();
			}
			case "P" :{
				return getCarrozzaPasseggeri();
			}
			case "R" :{
				return getCarrozzaRistorante();
			}
			case "C" :{
				return getCargo();
			}
			default: {
				return null;	 
			}
		}
	 }
	
	private Collection<Carrozza> carrozze(String codice, String elenco) {
		Collection<Carrozza> carrozze = new ArrayList<Carrozza>();
		for (short posizioneInTesto=1 ; posizioneInTesto< elenco.length(); posizioneInTesto++) {
			Object enneElementoTreno = creaElementoTreno(elenco.substring(posizioneInTesto,posizioneInTesto+1));
			carrozze.add((Carrozza) enneElementoTreno);
/*			System.out.println("tipo treno<" + tipoTreno + "> per codice<" + codice + ">"
				+ " elemento<" + elenco.substring(posizioneInTesto,posizioneInTesto+1) + ">"); 
*/ 
		}
		return carrozze;
	}
	
	abstract ConcreteLocomotiva getLocomotiva();
	
	abstract ConcreteCarrozzaPasseggeri getCarrozzaPasseggeri();

	abstract ConcreteCarrozzaRistorante getCarrozzaRistorante();
	
	abstract ConcreteCargo getCargo();
	
	abstract String getCompagnia();
	
}
