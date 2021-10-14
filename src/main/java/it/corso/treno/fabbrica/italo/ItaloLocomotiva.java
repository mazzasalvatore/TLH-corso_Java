package it.corso.treno.fabbrica.italo;

import it.corso.treno.fabbrica.Locomotiva;
import it.corso.treno.fabbrica.ConcreteLocomotiva;

public class ItaloLocomotiva extends ConcreteLocomotiva implements Locomotiva{

	ItaloLocomotiva() {
		super(101000, 1000000);
	}
	
	public void avvia() {
		
	}
	@Override
	public void aggancia() {
		// TODO Auto-generated method stub
		
	}


}
