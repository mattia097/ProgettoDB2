package it.polimi.progettodb2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String DB_URL = "jdbc:mysql://localhost:3306/db_progettodb2";
		final String DB_USERNAME = "root";
		final String DB_PASSWORD = "toor";
		PrintWriter out;
		String username;
		String password;
		String resultMessage = "";

		username = request.getParameter("field-usr");
		password = request.getParameter("field-psw");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			
			resultMessage = "Autenticato! User(" + username + ") Password(" + password + ")";
		} catch (Exception e) {
			resultMessage = "Connessione Fallita";
			
			e.printStackTrace();
		}

		out = response.getWriter();
		
		out.println(resultMessage);
		out.close();
	}

}
