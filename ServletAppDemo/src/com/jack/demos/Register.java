package com.jack.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		String country = request.getParameter("country");
		String[] languages = request.getParameterValues("languages");

		PrintWriter out = response.getWriter();
		out.println("<h3>processing is done for get request</h3>");

		out.println("<div>");
		out.println("<p>user: " + username + "</p>");
		out.println("<p>password: " + password + "</p>");
		out.println("<p>gender: " + gender + "</p>");
		out.println("<p> Hobbies:" + "</p>");
		for(int i = 0; i < hobbies.length; i++) {
			out.println(hobbies[i] + "<br>");
		}
		out.println("<p>country:" + country + "</p>");
		out.println("<p> languages:" + "</p>");
		for(int i = 0; i < languages.length; i++) {
			out.println(languages[i] + "<br>");
		}
		out.println("</div>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		response.setContentType("text/html");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String gender = request.getParameter("gender");
//		String[] hobbies = request.getParameterValues("hobbies");
//		String country = request.getParameter("country");
//		String[] languages = request.getParameterValues("languages");
//		PrintWriter out = response.getWriter();
//		out.println("<h3>processing is done for post request</h3>");
//		out.println("<div>");
//		out.println("<p>user: " + username + "</p>");
//		out.println("<p>password: " + password + "</p>");
//		out.println("<p>gender: " + gender + "</p>");
//		out.println("<p> Hobbies:" + "</p>");
//		for(int i = 0; i < hobbies.length; i++) {
//			out.println(hobbies[i] + "<br>");
//		}
//		out.println("<p>country:" + country + "</p>");
//		out.println("<p> languages:" + "</p>");
//		for(int i = 0; i < languages.length; i++) {
//			out.println(languages[i] + "<br>");
//		}
//		out.println("</div>");
	}

}