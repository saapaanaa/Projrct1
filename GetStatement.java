package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class GetStatement extends HttpServlet 
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
		
        ArrayList al= new ArrayList();
        ArrayList al1= new ArrayList();
        ArrayList al2= new ArrayList();
        ArrayList al3= new ArrayList();

		try 
		{
			al=m.getTrans();
			al1=m.getAAccno();
			al2=m.getTime();
			al3=m.getDate();
			
			boolean r1 = al.isEmpty();
			boolean r2 = al1.isEmpty();
			boolean r3 = al2.isEmpty();
			boolean r4 = al3.isEmpty();
			
			if((r1==false) && (r2==false) && (r3==false) && (r4==false))
			{
				session = request.getSession();
				session.setAttribute("TRASACTION",al);
				session.setAttribute("ACCNO",al1);
				session.setAttribute("TIME",al2);
				session.setAttribute("TRASACTION_DATE",al3);
							           
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
