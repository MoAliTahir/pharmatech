package com.projet.pharmatech.filters;

import java.io.IOException;

import javax.faces.application.FacesMessage;
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
//@WebFilter("/faces/admin/*")
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		String url = req.getRequestURI();
		boolean connected = session != null && session.getAttribute("authUser") != null;


		if(connected)
		{
			if(session.getAttribute("userRole").equals("admin"))
				chain.doFilter(request, response);
			else
			{
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Not authorized", "Espace Administrateur");
		        FacesContext.getCurrentInstance().addMessage(null, message);
				resp.sendRedirect(req.getContextPath() + "/faces/acceuil.xhtml");
			}

		}else
			resp.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
