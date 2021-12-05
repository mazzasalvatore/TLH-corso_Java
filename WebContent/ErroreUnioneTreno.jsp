<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Errore unione treno</title>
<style>
body {
color: black;
background: #FFFFFF;
margin: auto;
background-color: white;
text-shadow: 1px 1px blue;
font-size: 30px;
}
</style>
</head>
<body>

<% String compagnia = request.getParameter("compagnia");  %>
<% String sigla = request.getParameter("sigla");  %>
<% String composizione1 = request.getParameter("composizione1");  %>
<% String composizione2 = request.getParameter("composizione2");  %>
<% String erroreMsg  = request.getParameter("erroreMsg");  %>

<p>!!!Attenzione!!!</p>
<br>
<a><%=erroreMsg%></a>
<br>

</body>
</html>
