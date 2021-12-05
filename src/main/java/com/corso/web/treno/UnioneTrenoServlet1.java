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

@WebServlet("/unioneTreno.html")
public class UnioneTrenoServlet1 extends HttpServlet {

	public static Treno trenoUnione;
	
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
		String compagnia1 = request.getParameter("compagnia");
		String sigla = request.getParameter("sigla"); 
		String composizione1 = request.getParameter("composizione1");
		String composizione2 = request.getParameter("composizione2");
		
		// .. verifica della composizione1? secondo me no! il treno è già in viaggio 
		// .. verifica della composizione2? secondo me no! il treno è già in viaggio 
		
	    String composizione = composizione1; 
	    String composizione2SenzaLocomotiva = composizione2.substring(1, composizione2.length());  
	   
	    composizione = composizione.concat(composizione2SenzaLocomotiva);
	   
		ConcreteTrenoBuilder builder = new ConcreteTrenoBuilder();
		builder = FunctionTreno.CalcolaBuilder(compagnia1);
		
		try {
			trenoUnione = builder.getTreno(sigla, composizione);
			RequestDispatcher rd = request.getRequestDispatcher("/UnioneTreno.jsp?composizione=" + composizione);								   
			rd.forward(request, response);
			} catch (UserErrorException e) {
			e.printStackTrace();
			String erroreMsg = "Errore in unione treno: " + e.getMessage();
			RequestDispatcher rdErr = request.getRequestDispatcher("/ErroreUnioneTreno.jsp?erroreMsg=" + erroreMsg); 
			rdErr.forward(request, response);
		}
	}
}
