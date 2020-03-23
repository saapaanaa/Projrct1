<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
<style>

body  {
  background-image: url("https://image.shutterstock.com/image-photo/double-exposure-city-night-stack-260nw-1486370042.jpg");
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
<h1>WELCOME TO STATE BANK OF INDIA</h1>
<%!
int accno=0;
%>
<%
session=request.getSession();
accno=(int)session.getAttribute("accno");
%>
Check your Balance: <a href="CheckBalance">Click</a><br><br>
Change your Password: <a href="change.html">Click</a><br><br>
Transfer Amount: <a href="transfer.html">Click</a><br><br>
Get Statement: <a href="GetStatement">Click</a><br><br>
Logout: <a href="Logout">Click</a><br><br>


</body>
</html>
