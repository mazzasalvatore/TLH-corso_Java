<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.corso.web.treno.UnioneTrenoServlet" %>
<%@ page import="it.corso.treno.Vagone" %>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="ISO-8859-1">
<title>Unione Treno</title>
</head>
<body>

<% String sigla1 = request.getParameter("sigla1");  %>
<% String sigla2 = request.getParameter("sigla2");  %>
<% String sigla  = request.getParameter("sigla");  %>
<% String compagnia = request.getParameter("compagnia");  %>
<% String composizione1 = request.getParameter("composizione1");  %>
<% String composizione2 = request.getParameter("composizione2");  %>
<% String composizione  = request.getParameter("composizione");  %>

<p> TRENI:</p>

<%for (int i=0; i < composizione1.length(); i++) { %>
	<img src="<%=compagnia%>/<%=composizione1.charAt(i)%>.png" style="width:100px;height:100px;">
<% }%>

<br>
+
<br>
<%for (int i=0; i < composizione2.length(); i++) { %>
	<img src="<%=compagnia%>/<%=composizione2.charAt(i)%>.png" style="width:100px;height:100px;">
<% }%>

<br>
=
<br>
<%for (int i=0; i < composizione.length(); i++) { %>
	<img src="<%=compagnia%>/<%=composizione.charAt(i)%>.png" style="width:100px;height:100px;">
<% }%>
<p>dati del <%=UnioneTrenoServlet.trenoUnione.toString()%></p>
<%String listaVagoni = "";
for (Vagone vagone: UnioneTrenoServlet.trenoUnione.getVagoni()) {
	listaVagoni = listaVagoni + "\n" + vagone.toString(); 
}%>
<table>
	<caption>TABELLA TRENO</caption>
	<tr>
		<th><%=sigla%></th>
		<th><%=compagnia%></th>
		<th>lista vagoni</th>
	</tr>
	<tr>
		<td><%=sigla%></td>
		<td><%=compagnia%></td>
		<td><%=listaVagoni%></td>
	</tr>
</table>
			
<% String query = "\"http://localhost:8080/TLHWeb/InvertiTreno.jsp?compagniaTreno=" + compagnia 
            	+ "&siglaTreno=" + sigla + "&composizioneTreno=" + composizione + "\""; %>
<a href=<%=query%>>INVERSIONE TRENO</a><br>
<% String queryTreno = "\"http://localhost:8080/TLHWeb/TLHunioneTreno.html\""; %>
<a href=<%=queryTreno%>>TORNA A UNIONE TRENO</a><br> 
<% String queryHome = "\"http://localhost:8080/TLHWeb/TLH_Home.html\""; %>
<a href=<%=queryHome%>>TORNA ALLA HOME</a><br> 


</body>
</html>

