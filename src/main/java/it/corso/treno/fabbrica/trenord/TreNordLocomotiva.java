package it.corso.treno.fabbrica.trenord;

import it.corso.treno.fabbrica.Locomotiva;
import it.corso.treno.fabbrica.ConcreteLocomotiva;

public class TreNordLocomotiva extends ConcreteLocomotiva implements Locomotiva{

	TreNordLocomotiva() {
		super(103000,2000000);
	}
	
	public void avvia() {
		
	}
	@Override
	public void aggancia() {
		// TODO Auto-generated method stub
	}
	
}