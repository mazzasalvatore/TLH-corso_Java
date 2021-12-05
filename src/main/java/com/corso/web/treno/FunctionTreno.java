package com.corso.web.treno;

import it.corso.treno.builder.ConcreteTrenoBuilder;
import it.corso.treno.fabbrica.fr.FRFabbricaTreno;
import it.corso.treno.fabbrica.fs.FSFabbricaTreno;
import it.corso.treno.fabbrica.italo.ItaloFabbricaTreno;
import it.corso.treno.fabbrica.trenord.TreNordFabbricaTreno;

public class FunctionTreno {

	public static ConcreteTrenoBuilder CalcolaBuilder(String compagniaTreno) {
		ConcreteTrenoBuilder builder = new ConcreteTrenoBuilder();

		switch (compagniaTreno) {
			case "FRECCIA-ROSSA": {
				FRFabbricaTreno factory = new FRFabbricaTreno();
				builder.setFactory(factory);
		        break;
		    }
		    case "ITALO": {
		    	ItaloFabbricaTreno factory = new ItaloFabbricaTreno();
		    	builder.setFactory(factory);
		    	break;
		    }
		    case "TRE-NORD": {
		    	TreNordFabbricaTreno factory = new TreNordFabbricaTreno();
		    	builder.setFactory(factory);
		    break;
		    }
		    case "FS": {
		    	FSFabbricaTreno factory = new FSFabbricaTreno();
		    	builder.setFactory(factory);
		    break;
		    }
		    default: {
		    	FSFabbricaTreno factory = new FSFabbricaTreno();
		    	builder.setFactory(factory);
		    break;
		    }
		}
		return builder;
	}
}
