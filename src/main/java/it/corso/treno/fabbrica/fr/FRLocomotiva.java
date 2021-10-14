package it.corso.treno.fabbrica.fr;

import it.corso.treno.fabbrica.Locomotiva;
import it.corso.treno.fabbrica.ConcreteLocomotiva;

public class FRLocomotiva extends ConcreteLocomotiva implements Locomotiva{

	FRLocomotiva() {
		super(101000,1000000);
	}
	
	public void avvia() {
		
	}
	@Override
	public void aggancia() {
		// TODO Auto-generated method stub
	}
	
}