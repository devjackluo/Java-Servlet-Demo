package com.jack.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
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
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//chain.doFilter(request, response);
		
		System.out.println("doFilter method is called in " + this.getClass().getName());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String ipAddress = request.getRemoteAddr();
		
		if(username.equals("psuser") && password.equals("psguest")) {
			System.out.println("User logged in  " + ipAddress + " at " + new Date().toString());
			chain.doFilter(request, response);
		}else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h3>Sorry, you are not allowed here.</h3>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init method is called in " + this.getClass().getName());
	}

}
