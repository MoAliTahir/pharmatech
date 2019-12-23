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
 * Servlet Filter implementation class admin
 */
@WebFilter("/faces/admin/*")
public class AdminFilter implements Filter{

    /**
     * Default constructor. 
     */
    public AdminFilter() {
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
		
		boolean loggedIn= ses!=null && ses.getAttribute("userRole")!=null;
		boolean resourceRequest = reqt.getRequestURI().startsWith(reqt.getContextPath()+ ResourceHandler.RESOURCE_IDENTIFIER);
		
		
		if(loggedIn)
		{
			if(((String) ses.getAttribute("userRole")).equals("admin") )
				chain.doFilter(request, response);
			else
				resp.sendRedirect(reqt.getContextPath()+ "/faces/acceuil.xhtml");
		}
		else if(resourceRequest)
			chain.doFilter(request, response);
		else
			resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
