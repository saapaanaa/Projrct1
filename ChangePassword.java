package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class ChangePassword extends HttpServlet 
{	private int row;
	private int accno;
	private ServletRequest session;

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		
		String npwd=request.getParameter("npwd");
		String opwd=request.getParameter("opwd");

		Model m=new Model();

		HttpSession session=request.getSession();
		accno=(int)session.getAttribute("accno");
		m.setAccno(accno);
		m.setPassword(opwd);

		try 
		{
			row=m.changePassword(npwd);
			if(row==1)
			{
				response.sendRedirect("/BANKAPP/changeSuccess.html");
			}
			else
			{
				response.sendRedirect("/BANKAPP/changefail.html");

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
		
		