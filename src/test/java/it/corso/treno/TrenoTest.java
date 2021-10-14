package it.corso.treno;

import java.util.Collection;

import it.corso.treno.file.StringReader;
import it.corso.treno.file.StringReaderStream;
import it.corso.treno.exception.*;


public class TrenoTest {

	public static void main(String[] args) {
		StringReader sr = new StringReaderStream() ;
		FileTrenoReader fileTrenoReader = new FileTrenoReader(sr);
		String nomeFile = "C:\\\\Users\\\\utente\\\\Sorti\\\\treni.txt";
		//String nomeFile = "Untitled 1.txt";
		//Collection<Treno> elencoTreni = fileTrenoReader.elabora(nomeFile);
		Collection<Treno> elencoTreni = null;
		try {
			elencoTreni = fileTrenoReader.elabora(nomeFile);
		}	
		// cattura errore
		catch (UserErrorException UserErrorException){
			System.out.println("£££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££");
			System.out.println(UserErrorException.toString());
			System.out.println("£££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££");
		}
		
		System.out.println("elenco treni:\n " + elencoTreni.toString() + " fine elenco");

	}

}
