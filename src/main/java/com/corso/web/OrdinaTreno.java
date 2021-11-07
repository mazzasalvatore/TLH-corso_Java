package com.corso.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corso.treno.Treno;
import it.corso.treno.builder.ConcreteTrenoBuilder;
import it.corso.treno.exception.UserErrorException;
import it.corso.treno.fabbrica.fr.FRFabbricaTreno;
import it.corso.treno.fabbrica.fs.FSFabbricaTreno;
import it.corso.treno.fabbrica.italo.ItaloFabbricaTreno;
import it.corso.treno.fabbrica.trenord.TreNordFabbricaTreno;

/**
 * Servlet implementation class OrdinaTreno
 */
@WebServlet("/OrdinaTreno.html")
public class OrdinaTreno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("hai fatto una GET");
        try {
			elabora(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserErrorException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hai fatto una GET");
        try {
			elabora(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserErrorException e) {
			e.printStackTrace();
		}
	}

	private void elabora(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, UserErrorException {	
		String compagniaTreno = request.getParameter("compagniaTreno");
		String siglaTreno = request.getParameter("siglaTreno");
		String composizioneTreno = request.getParameter("composizioneTreno");
		//response.getWriter().write("compagniaTreno: " + request.getAttribute("compagniaTreno"));
		System.out.println("compagniaTreno" + compagniaTreno);
		
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
		
		PrintWriter w = response.getWriter(); 
				
		try {
			Treno treno = builder.getTreno(siglaTreno, composizioneTreno);
			w.append("<h1>Buonasera Allievi TLH </h1>"); 
			w.append("<p>Ecco il tuo treno: " + compagniaTreno + " " + siglaTreno + " " + composizioneTreno + "</p>"); 
			for (int i=0; i < composizioneTreno.length(); i++) {
				w.append("<img src=\""+ compagniaTreno + composizioneTreno.charAt(i) + ".png\" style=\"width:150px;height:100px;\" >");
			}			
			w.append("<p>dati del " + treno.toString() + "</p>");
//			w.append("<h1>Attenzione il treno non ha una locomotiva in testa</h1>"); 
		} catch (UserErrorException e) {
			e.printStackTrace();
		}
	
	}
}

