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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//LoginBean session = (LoginBean) req.getSession().getAttribute("loginBean");
		
		HttpSession session = req.getSession(false);
		String url = req.getRequestURI();
		System.out.println(session);
		System.out.println(req.getContextPath());
		if(url.indexOf("/login.xhtml")>=0 
				|| (session != null && session.getAttribute("authUser")!=null) 
				|| url.contains("javax.faces.resource"))
		{
 			chain.doFilter(request, response);
			
		}else
		{
			resp.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
		}
			/*if(url.indexOf("/logout.jsp")>=0)
			{
				req.getSession().removeAttribute("loginBean");
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath() + "/faces/login.jsp");
			}else
				resp.sendRedirect(req.getContextPath() + "/faces/login.jsp");
		}*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
