package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.db2.progettodb2.exceptions.DateException;
import it.polimi.db2.progettodb2.exceptions.MissingParametersException;
import it.polimi.db2.progettodb2.services.UserService;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "it.polimi.db2.progettodb2.services/UserService")
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String dateFormat = "yyyy-MM-dd"; /* SQL-like format */
		String name = null;
		String surname = null;
		String username = null;
		String email = null;
		String password = null;
		Date birthDate = null;
		String sex = null;

		try {
			name = request.getParameter("field-name");
			surname = request.getParameter("field-surname");
			username = request.getParameter("field-usr");
			email = request.getParameter("field-email");
			password = request.getParameter("field-psw");
			sex = request.getParameter("field-sex");

			/* (Rispetta i campi annullabili nel DB) */
			if (name == null || surname == null || username == null || email == null || password == null) {
				throw new MissingParametersException("Parametri mancanti in fase di registrazione");
			}

			/* (Rispetta i campi annullabili nel DB) */
			if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
				throw new MissingParametersException("Parametri mancanti in fase di registrazione");
			}

			/* La data è gestita separatamente, con una propria eccezione */
			try {
				birthDate = new SimpleDateFormat(dateFormat).parse(request.getParameter("field-birth-date"));
			} catch (ParseException e) {
				throw new DateException("Formato data non valido in fase di registrazione");
			}
		} catch (MissingParametersException eParam) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, eParam.getMessage());

			return;
		} catch (DateException eDate) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, eDate.getMessage());

			return;
		}

		userService.register(name, surname, username, email, password, birthDate, sex);
		
		response.getWriter().append("L'utente potrebbe essere stato inserito correttamente...");
		
		doGet(request, response);
	}

}
