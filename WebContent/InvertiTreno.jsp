<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.corso.web.treno.FunctionTreno" %>
<%@ page import="it.corso.treno.Treno" %>
<%@ page import="it.corso.treno.Vagone" %>
<%@ page import="it.corso.treno.builder.ConcreteTrenoBuilder" %>
<%@ page import="it.corso.treno.exception.UserErrorException" %>
<%@ page import="it.corso.treno.fabbrica.fr.FRFabbricaTreno" %>
<%@ page import="it.corso.treno.fabbrica.fs.FSFabbricaTreno" %>
<%@ page import="it.corso.treno.fabbrica.italo.ItaloFabbricaTreno" %>
<%@ page import="it.corso.treno.fabbrica.trenord.TreNordFabbricaTreno" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INVERTI TRENO TLH JSP</title>
<style>
body {
color: black;
background: #FFFFFF;
margin: auto;
background-color: white;
text-shadow: 1px 1px blue;
font-size: 30px;
}
table, th, td { border: 1px solid white; border-collapse: collapse; 
}
th, td {background-color: #96D4D4;
}
</style>
</head>
		<body>
		<%String compagniaTreno = request.getParameter("compagniaTreno");
		String siglaTreno = request.getParameter("siglaTreno");
		String composizioneTreno = request.getParameter("composizioneTreno");
		System.out.println("compagniaTreno" + compagniaTreno);
		
		ConcreteTrenoBuilder builder = new ConcreteTrenoBuilder();
		
		String composizioneInvertita = "H";
		for (int i = composizioneTreno.length()-1; i>0; i--) {
			composizioneInvertita = composizioneInvertita + composizioneTreno.charAt(i);
		}
		composizioneTreno = composizioneInvertita;
		
		builder = FunctionTreno.CalcolaBuilder(compagniaTreno);
		%>
		
		<%try {
			Treno treno = builder.getTreno(siglaTreno, composizioneTreno);%>
			<p style="color:red;">Ecco il tuo treno: <%=compagniaTreno%> <%=siglaTreno%> <%=composizioneTreno%></p> 
			<%for (int i=0; i < composizioneTreno.length(); i++) {%>
				<img src="<%=compagniaTreno%>/<%=composizioneTreno.charAt(i)%>.png" style="width:150px;height:100px;">
			<%}%>			
			<p>dati del <%=treno.toString()%></p>
			<%String listaVagoni = "";
			for (Vagone vagone: treno.getVagoni()) {
				listaVagoni = listaVagoni + "\n" + vagone.toString(); 
			}%>
			<table>
				<caption>TABELLA TRENO</caption>
					<tr>
						<th>sigla</th>
						<th>compagnia</th>
						<th>lista vagoni</th>
					</tr>
					<tr>
						<td><%=siglaTreno%></td>
						<td><%=compagniaTreno%></td>
						<td><%=listaVagoni%></td>
					</tr>
			</table>
			<% String queryTreno = "\"http://localhost:8080/TLHWeb/TLHtreno.html\""; %>
			<a href=<%=queryTreno%>>TORNA A TRENO</a><br> 
			<% String queryHome = "\"http://localhost:8080/TLHWeb/TLH_Home.html\""; %>
			<a href=<%=queryHome%>>TORNA ALLA HOME</a><br> 
		<%} catch (UserErrorException e) {
				e.printStackTrace();%>
				<p><%=e.getMessage()%></p>
		<%}%>
		</body>
</html>
