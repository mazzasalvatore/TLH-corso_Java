package it.corso.treno;

import java.util.Collection;

public class Treno {

	private String codice;
	private Collection<Vagone> vagoni;
	private String compagnia;

	public String getCodice() {
		return codice;
	}

	@Override
	public String toString() {
		String listaVagoni = "";
		for (Vagone vagone: this.vagoni) {
			listaVagoni = listaVagoni + "\n" + vagone.toString(); 
		}
		return "Treno [codice=" + codice + ", compagnia=" + compagnia +  "\nlista vagoni:" + listaVagoni + "] \n";
	}
	
	public double pesoTreno() {
		double pesoTreno = 0;
		for (Vagone vagone: this.vagoni) {
			pesoTreno = pesoTreno + vagone.getPesoMax(); 
		}
		return pesoTreno;
	}

	public Collection<Vagone> getVagoni() {
		return vagoni;
	}

	public void setVagoni(Collection<Vagone> vagoni) {
		this.vagoni = vagoni;
	}

	public String getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	
}
