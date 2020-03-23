package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class Login extends HttpServlet 
{
	private HttpSession session;

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		Model m=new Model();
		m.setUserid(request.getParameter("user"));
		m.setPassword(request.getParameter("pwd"));
		
		try 
		{
			boolean temp=m.login();
			if(temp==true)
			{
				session=request.getSession(true);
				session.setAttribute("accno", m.getAccno());
				response.sendRedirect("/BANKAPP/Home.jsp");
			}
			else
			{
				response.sendRedirect("/BANKAPP/loginfail.html");

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	
	}
}
