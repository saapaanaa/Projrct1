package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class TransferAmount extends HttpServlet 
{
	private int accno;
	int row;

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		Model m=new Model();
		HttpSession session=request.getSession();//seesion=request.getSession();
		accno=(int)session.getAttribute("accno");//m.setAccno((int)session.getAttibute("accno");
		m.setAccno(accno);
		
		int amount=Integer.parseInt(request.getParameter("amount"));
		int rvcno=Integer.parseInt(request.getParameter("rvcno"));

	
	try 
	{
		row=m.transfer1(amount,rvcno);
		if(row==1)
		{
			response.sendRedirect("/BANKAPP/transfersuccess.html");
		}
		else
		{
			response.sendRedirect("/BANKAPP/transferFail.html");

		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
}

}
