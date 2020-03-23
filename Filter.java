package Controller;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter implements javax.servlet.Filter 
{
	public Filter() 
    {
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		String npwd=((HttpServletRequest)(request)).getParameter("npwd");
		String cpwd=((HttpServletRequest)(request)).getParameter("cpwd");

		if(npwd.equals(cpwd))
		{
			chain.doFilter(request, response);

		}
		else
		{
			((HttpServletResponse)(response)).sendRedirect("/BANKAPP/change.html");
		}
	}

	
}
