<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INVERTI TRENO TLH MVC</title>
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
		<%String compagniaTreno = request.getParameter("compagniaTreno");%>
		<%String siglaTreno = request.getParameter("siglaTreno");%>
		<%String composizioneTreno = request.getParameter("composizioneTreno");%>
		<%String nuovaComposizioneTreno = request.getParameter("nuovaComposizioneTreno");%>
		<%String erroreMsg = request.getParameter("erroreMsg");%>
		<p style="color:red;">Ecco il tuo treno: <%=compagniaTreno%> <%=siglaTreno%> <%=nuovaComposizioneTreno%></p> 
		<%for (int i=0; i < nuovaComposizioneTreno.length(); i++) {%>
			<img src="<%=compagniaTreno%>/<%=nuovaComposizioneTreno.charAt(i)%>.png" style="width:150px;height:100px;">
		<%}%>			
		<br>
		<%if (!(erroreMsg.contentEquals("OK"))) {%>
			<p style="color:red;">!!!Attenzione!!!</p><br>
			<a><%=erroreMsg%></a><br>
		<%} %>
		<% String queryTreno = "\"http://localhost:8080/TLHWeb/TLHtreno.html\""; %>
		<a href=<%=queryTreno%>>TORNA A TRENO</a><br> 
		<% String queryHome = "\"http://localhost:8080/TLHWeb/TLH_Home.html\""; %>
		<a href=<%=queryHome%>>TORNA ALLA HOME</a><br> 
		</body>
</html>
