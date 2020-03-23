<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Balance</title>
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

<%request.getSession();
int balance=(int)session.getAttribute("balance");
%>
<h1><b><%="Your balance is: "+balance+"/-"%></b></h1><br><br>
Back to Home page: <a href="Home.jsp">Click</a>

</body>
</html>
