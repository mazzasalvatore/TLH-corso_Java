package it.corso.treno.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringReaderStream implements StringReader {

	public Collection<String> elabora (String nomeFile) {
		
		Collection<String> righe = new ArrayList<String>();
		
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(nomeFile))) {

			righe = stream
//						.filter(riga -> riga.startsWith("H")) 
						.map(String::toUpperCase)
						.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return righe;
	}
	
}


