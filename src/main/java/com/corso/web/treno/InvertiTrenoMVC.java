package com.corso.web.treno;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corso.treno.Treno;
import it.corso.treno.builder.ConcreteTrenoBuilder;
import it.corso.treno.exception.UserErrorException;

/**
 * Servlet implementation class InvertiTreno
 */
@WebServlet("/InvertiTrenoMVC.html")
public class InvertiTrenoMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		System.out.println("compagniaTreno" + compagniaTreno);
		
		String composizioneInvertita = "H";
		for (int i = composizioneTreno.length()-1; i>0; i--) {
			composizioneInvertita = composizioneInvertita + composizioneTreno.charAt(i);
		}
				
		ConcreteTrenoBuilder builder = new ConcreteTrenoBuilder();
		builder = FunctionTreno.CalcolaBuilder(compagniaTreno);
		
		try {
			Treno treno = builder.getTreno(siglaTreno, composizioneTreno);
			String erroreMsg = "OK";
			RequestDispatcher rd = request.getRequestDispatcher("/InvertiTrenoMVC.jsp?" 
			        + "nuovaComposizioneTreno=" + composizioneInvertita  
					+ "&erroreMsg=" + erroreMsg);								   
			rd.forward(request, response);
		} catch (UserErrorException e) {
			e.printStackTrace();
			String erroreMsg = "Errore in inversione treno: " + e.getMessage();
			RequestDispatcher rdErr = request.getRequestDispatcher("/InvertiTrenoMVC.jsp?erroreMsg=" + erroreMsg); 
			rdErr.forward(request, response);
		}
	}
}

