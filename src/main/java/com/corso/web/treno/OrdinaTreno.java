package com.corso.web.treno;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corso.treno.Treno;
import it.corso.treno.Vagone;
import it.corso.treno.builder.ConcreteTrenoBuilder;
import it.corso.treno.exception.UserErrorException;

/**
 * Servlet implementation class OrdinaTreno
 */
@WebServlet("/OrdinaTreno.html")
public class OrdinaTreno1 extends HttpServlet {
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
		System.out.println("compagniaTreno" + compagniaTreno);
		
		ConcreteTrenoBuilder builder = new ConcreteTrenoBuilder();
		builder = FunctionTreno.CalcolaBuilder(compagniaTreno);

		PrintWriter w = response.getWriter(); 
		w.append("<!DOCTYPE html>");
		w.append("<html><head><meta charset=\"UTF-8\"><title>TRENO TLH HTML</title>");
		w.append("<style>");
		w.append("body {");
		w.append("color: black;");
		w.append("background: #FFFFFF;");
		w.append("margin: auto;");
		w.append("background-color: white;");
		w.append("text-shadow: 1px 1px red;");
		w.append("font-size: 30px;}");
		w.append("table, th, td { border: 1px solid white; border-collapse: collapse; }");
		w.append("th, td {background-color: #96D4D4;}");
		w.append("</style></head>");
		w.append("<body>");
		
		try {
			Treno treno = builder.getTreno(siglaTreno, composizioneTreno);
			w.append("<p style=\"color:black;\">Ecco il tuo treno: " + compagniaTreno + " " + siglaTreno + " " + composizioneTreno + "</p>"); 
			for (int i=0; i < composizioneTreno.length(); i++) {
				w.append("<img src=\""+ compagniaTreno + "/" + composizioneTreno.charAt(i) + ".png\" style=\"width:150px;height:100px;\" >");
			}			
			String listaVagoni = "";
			for (Vagone vagone: treno.getVagoni()) {
				listaVagoni = listaVagoni + "\n" + vagone.toString(); 
			}
			w.append("<table><caption>TABELLA TRENO</caption>");
			w.append("<tr><th>codice</th><th>compagnia</th><th>lista vagoni</th></tr>");
			w.append("<tr><td>" + siglaTreno + "</td>");
			w.append("<td>" + compagniaTreno + "</td>");
			w.append("<td>" + listaVagoni + "</td></tr></table>");
			String query = "\"http://localhost:8080/TLHWeb/InvertiTreno.html?compagniaTreno=" + compagniaTreno 
					+ "&siglaTreno=" + siglaTreno + "&composizioneTreno=" + composizioneTreno + "\"";
			w.append("<a href=" + query + ">INVERSIONE TRENO</a>"); 
			} catch (UserErrorException e) {
			e.printStackTrace();
			w.append("<p>" + e.getMessage() + "</p>");
		}
		
		w.append("</body></html>");

	}
}

