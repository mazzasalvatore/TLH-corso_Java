<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TLH funzione JSP</title>
<style>
body {
color: red;
background: #FFFFFF;
margin: auto;
background-color: black;
text-shadow: 2px 2px white;
font-size: 30px;
}
</style>
</head>
		<body>
		
		<%String funzione = request.getParameter("funzione"); %>
  		<%switch (funzione) {
			case "Ordina_TRENO": {%>
				<% String queryHome = "\"http://localhost:8080/TLHWeb/TLHtreno.html\""; %>
			    <a href=<%=queryHome%>>Vai a TRENO</a> 
				<%
		        break;
		    }
			case "Ordina_TRENO_servlet": {%>
				<% String queryHome = "\"http://localhost:8080/TLHWeb/TLHtrenoServlet.html\""; %>
		    	<a href=<%=queryHome%>>Vai a TRENO servlet</a> 
				<%
	        	break;
	    	}
			case "Ordina_TRENO_MVC": {%>
				<% String queryHome = "\"http://localhost:8080/TLHWeb/TLHtrenoMVC.html\""; %>
	    		<a href=<%=queryHome%>>Vai a TRENO MVC</a> 
				<%
        		break;
    		}
			case "Unione_TRENO": {%>
				<% String queryHome = "\"http://localhost:8080/TLHWeb/TLHunioneTreno.html\""; %>
		    	<a href=<%=queryHome%>>Vai a unione TRENO</a> 
				<%
	        	break;
	    }
		    default: { %>
				<% String queryHome = "\"http://localhost:8080/TLHWeb/TLH_Home.html\""; %>
			    <a href=<%=queryHome%>>Torna alla home</a> 
				<%
				break;
		    } 
		} %>
		<br>
		<br>
		<br>
		<a href="http://localhost:8080/TLHWeb/TLH_Home.html">TORNA ALLA HOME</a><br>

		</body>
</html>
