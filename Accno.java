package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class Accno extends HttpServlet 
{
	 private int accno;
	 ArrayList al;
	 /*ArrayList al1;
	 ArrayList al2;
	 ArrayList al3;
	 ArrayList al4;*/



	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		Model m=new Model();
		HttpSession session=request.getSession();
		accno=(int)session.getAttribute("accno");
		m.setAccno(accno);
        ArrayList<String> al= new ArrayList<String>();

		try 
		{

			al=m.getAAccno();
			
			if(al.isEmpty()==false)
			{
				session = request.getSession();
				session.setAttribute("TRASACTION",al);
				for(String temp: al)
				{

				}
			           
				response.sendRedirect("/BANKAPP/statement.jsp");

			}

			else
			{
				response.sendRedirect("/BANKAPP/noTransactions.html");

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
