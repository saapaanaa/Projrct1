package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class CheckBalance extends HttpServlet 
{
	 private int accno;
	 boolean temp;

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		Model m=new Model();
		//m.setAccno((int)session.getAttribute("accno"));
		HttpSession session=request.getSession();
		accno=(int)session.getAttribute("accno");
		m.setAccno(accno);

		try 
		{
			 temp=m.checkBalance();
			if(temp==true)
			{
				session = request.getSession();
				session.setAttribute("balance", m.getBalance());
				response.sendRedirect("/BANKAPP/balance.jsp");
			}
			else
			{
				response.sendRedirect("/BANKAPP/balancefail.html");

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
