<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<title>Statement</title>
<style>
body  {
  background-image: url("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fmoneybuilder%2Ffiles%2F2014%2F04%2F0507_rip-off-credit-card-fees_400x280.jpg");
  height: 100%;

  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  margin: 100px;
  text-align: center;
  align: center;
}
    a { color: #222430; } 
</style>
</head>
<body>
<%!
ArrayList al;
ArrayList al1;
ArrayList al2;
ArrayList al3;
%>

<%
al=(ArrayList)session.getAttribute("ACCNO");
al1=(ArrayList)session.getAttribute("TRASACTION");
al2=(ArrayList)session.getAttribute("TRASACTION_DATE");
al3=(ArrayList)session.getAttribute("TIME");
%>
<table border="1">
<tr>
		<td><b>ACCNO</b></td>
		<td><b>TRASACTION</b></td>
		<td><b>TRASACTION_DATE</b></td>
		<td><b>TIME</b></td>
</tr>
<%
for(int i=0;i<al.size();i++)
{
%>
<tr>
		<td><b><%=al.get(i) %></b></td>
		<td><b><%=al1.get(i) %></b></td>
		<td><b><%=al2.get(i) %></b></td>
		<td><b><%=al3.get(i) %></b></td>
</tr> 
 <%} %>
</table>
Back to Home page: <a href="Home.jsp">Click</a>
</body>
</html>