package com.projet.pharmatech.filters;

import java.io.IOException;
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		String url = req.getRequestURI();
		if(url.indexOf("/admin")>=0 && session != null)
		{
			//Si l'admin est connecté
			if(session.getAttribute("isAdmin") != null && session.getAttribute("isAdmin").equals(true))
				chain.doFilter(request, response);
			else
				//si la session est expirée et l'utilisateur reessaye de recharger les pages
				resp.sendRedirect(req.getContextPath() + "/faces/acceuil.jsp");
		}	
		else
			resp.sendRedirect(req.getContextPath() + "/faces/acceuil.jsp");
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
