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
 * Servlet Filter implementation class AuthFilter
 */
//@WebFilter("/*")
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//LoginBean session = (LoginBean) req.getSession().getAttribute("loginBean");
		
		HttpSession session = req.getSession(false);
		String url = req.getRequestURI();
		boolean connected = session != null && session.getAttribute("authUser") != null;
		
		if(connected && url.indexOf("/login.xhtml")>=0)
		{
			if(connected && session.getAttribute("userRole").equals("admin") && url.indexOf("/admin") < 0)
			{
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Not authorized", "Espace uniquement Pharmaciens");
		        FacesContext.getCurrentInstance().addMessage(null, message);
				resp.sendRedirect(req.getContextPath() + "/faces/admin/acceuil.xhtml");
			}else
				chain.doFilter(request, response);
			
		}else if(!connected)
		{
			resp.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
		}else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
