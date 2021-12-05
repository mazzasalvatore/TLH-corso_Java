package it.corso.treno;

import java.util.ArrayList;
import java.util.Collection;

import it.corso.treno.builder.ConcreteTrenoBuilder;
import it.corso.treno.builder.TrenoBuilder;
import it.corso.treno.exception.UserErrorException;
import it.corso.treno.fabbrica.fr.FRFabbricaTreno;
import it.corso.treno.fabbrica.fs.FSFabbricaTreno;
import it.corso.treno.fabbrica.italo.ItaloFabbricaTreno;
import it.corso.treno.fabbrica.trenord.TreNordFabbricaTreno;
import it.corso.treno.file.StringReader;

public class FileTrenoReader {

	StringReader sr;
	
	public FileTrenoReader(StringReader sr) {
		super();
		this.sr = sr;
	}
	
	public Collection<Treno> elabora (String nomeFile) throws UserErrorException {
		
		Collection<String> righe;
		righe = sr.elabora(nomeFile);
		
		Collection<Treno> elencoTreni = new ArrayList<Treno>();
		
		for (String riga: righe) {
			if (riga.equals("STOP")) {
				System.out.println("trovato STOP in file");
				break;
			}
			Treno treno;
			ConcreteTrenoBuilder builder = new ConcreteTrenoBuilder();
			CompagniaTreno compagnia = TrenoBuilder.determinaCompagniaTreno(riga.substring(0,4));
			switch (compagnia) {
				case TRENO_GENERICO: {
					FSFabbricaTreno factory = new FSFabbricaTreno();
					builder.setFactory(factory);
					treno = builder.getTreno(riga.substring(0,4),riga.substring(4,riga.length()), compagnia);
					break;
				}
				case FRECCIA_ROSSA: {
					FRFabbricaTreno factory = new FRFabbricaTreno();
					builder.setFactory(factory);
					treno = builder.getTreno(riga.substring(0,4),riga.substring(4,riga.length()), compagnia);
					break;
				}
				case ITALO: {
					ItaloFabbricaTreno factory = new ItaloFabbricaTreno();
					builder.setFactory(factory);
					treno = builder.getTreno(riga.substring(0,4),riga.substring(4,riga.length()), compagnia);
					break;
				}
				case TRE_NORD: {
					TreNordFabbricaTreno factory = new TreNordFabbricaTreno();
					builder.setFactory(factory);
					treno = builder.getTreno(riga.substring(0,4),riga.substring(4,riga.length()), compagnia);
					break;
				}
				default: {
					FSFabbricaTreno factory = new FSFabbricaTreno();
					builder.setFactory(factory);
					treno = builder.getTreno(riga.substring(0,4),riga.substring(4,riga.length()), compagnia);
					break;
				}
			}
			
			elencoTreni.add(treno);
		}

		return elencoTreni;
	}
	
}

