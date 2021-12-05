package it.corso.treno;

import it.corso.treno.builder.ConcreteTrenoBuilder;
import it.corso.treno.exception.UserErrorException;
import it.corso.treno.fabbrica.fr.FRFabbricaTreno;

public class Treno2Test {

	public static void main(String[] args)  {

	ConcreteTrenoBuilder builder = new ConcreteTrenoBuilder();
	
	FRFabbricaTreno factory = new FRFabbricaTreno();

	builder.setFactory(factory);
	
	try {
		Treno t = builder.getTreno("1234", "HPPPPPRPP");
		System.out.println("treno costruito: " + t);
	} catch (UserErrorException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
