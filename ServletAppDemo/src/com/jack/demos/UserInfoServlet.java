package com.jack.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");		
		out.println("<h2>Reading some stuff with 'getParameters(String name)' ...</h2>");
		out.println("<div>");
		out.println("<p>" + firstName + "</p>");
		out.println("<p>" + lastName + "</p>");
		out.println("</div>");
		
		out.println("<h2>Reading some stuff with 'Enumeration getParameterNames()' ...</h2>");
		Enumeration<String> paramNames = request.getParameterNames();
		out.println("<div>");
		while(paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			out.println("<p>" + paramName + " : " + paramValue + "</p>");
		}
		out.println("</div>");
		
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> paramNamesSet = paramMap.keySet();
		out.println("<h2>Reading some stuff with 'Map getParameterMap()' ...</h2>");
		out.println("<div>");		
		for(String paramName : paramNamesSet) {
			String[] paramValues = paramMap.get(paramName);
			out.println("<p>" + paramName + " : ");
			for(int i = 0; i < paramValues.length; i++) {
				out.println(paramValues[i]);
			}
			out.println("</p>");
		}		
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
