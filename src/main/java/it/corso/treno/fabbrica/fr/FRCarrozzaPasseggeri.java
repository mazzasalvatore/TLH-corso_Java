package it.corso.treno.fabbrica.fr;

import it.corso.treno.fabbrica.CarrozzaPasseggeri;
import it.corso.treno.fabbrica.ConcreteCarrozzaPasseggeri;

public class FRCarrozzaPasseggeri extends ConcreteCarrozzaPasseggeri implements CarrozzaPasseggeri{

	private String passwordWifi = "123456789";
	
	FRCarrozzaPasseggeri() {
		super(75,42000,50000);

	}

	public String getPasswordWifi() {
		return passwordWifi;
	}

	public void setPasswordWifi(String passwordWifi) {
		this.passwordWifi = passwordWifi;
	}

	
}
