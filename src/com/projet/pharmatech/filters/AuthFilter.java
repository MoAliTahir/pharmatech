package com.projet.pharmatech.filters;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest reqt = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession ses = reqt.getSession(false);

		String reqURI = reqt.getRequestURI();
		boolean loggedIn= ses!=null && ses.getAttribute("authUser")!=null;
		boolean loginRequest= reqt.getRequestURI().contentEquals(reqt.getContextPath() + "/faces/login.xhtml");
		boolean resourceRequest = reqt.getRequestURI().startsWith(reqt.getContextPath()+ ResourceHandler.RESOURCE_IDENTIFIER);
		
		
		
		System.out.println(reqURI);
		if(loginRequest || loggedIn || reqURI.contains("javax.faces.resource"))
		{
			chain.doFilter(request, response);
			
		}else
		{
			resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
		}
		
		
	/*if(loggedIn && loginRequest)
	{
		if(((String) ses.getAttribute("userRole")).equals("admin"))
			resp.sendRedirect(reqt.getContextPath() + "/faces/admin/acceuil.xhtml");
		else
			resp.sendRedirect(reqt.getContextPath() + "/faces/acceuil.xhtml");
	}else if(loggedIn)
	{
		if(((String) ses.getAttribute("userRole")).equals("admin") && reqURI.indexOf("/admin") < 0)
			resp.sendRedirect(reqt.getContextPath() + "/admin/acceuil.xhtml");
		else if(!((String) ses.getAttribute("userRole")).equals("admin") && reqURI.indexOf("/admin") >= 0)
			resp.sendRedirect(reqt.getContextPath() + "/acceuil.xhtml");
		else
			chain.doFilter(request, response);
		
	}
	else if(loggedIn || resourceRequest || loginRequest)
		chain.doFilter(request, response);
	else
		resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");*/
}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
