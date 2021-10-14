package it.corso.treno.fabbrica.italo;

import it.corso.treno.fabbrica.CarrozzaPasseggeri;
import it.corso.treno.fabbrica.ConcreteCarrozzaPasseggeri;

public class ItaloCarrozzaPasseggeri extends ConcreteCarrozzaPasseggeri implements CarrozzaPasseggeri{

	private String passwordWifi = "987654321";
	
	ItaloCarrozzaPasseggeri() {
		super(77,42000,50000);

	}

	public String getPasswordWifi() {
		return passwordWifi;
	}

	public void setPasswordWifi(String passwordWifi) {
		this.passwordWifi = passwordWifi;
	}

	
}
