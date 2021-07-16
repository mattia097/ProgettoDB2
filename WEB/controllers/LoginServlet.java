package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import it.polimi.db2.progettodb2.entities.User;
import it.polimi.db2.progettodb2.exceptions.CredentialsException;
import it.polimi.db2.progettodb2.exceptions.MissingParametersException;
import it.polimi.db2.progettodb2.services.UserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "it.polimi.db2.progettodb2.services/UserService")
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username;
		String password;
		String resultMessage = "";
		User user = null;

		try {
			username = StringEscapeUtils.escapeJava(request.getParameter("field-usr"));
			password = StringEscapeUtils.escapeJava(request.getParameter("field-psw"));

			if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
				throw new MissingParametersException("Credenziali non inserite correttemente");
			}
		} catch (MissingParametersException e) {
			e.printStackTrace();
			return;
		}

		try {
			user = userService.checkCredentials(username, password);
		} catch (CredentialsException e) {
			e.printStackTrace();
			return;
		}

		if (user == null) {
			/* L'utente non esiste */
		} else {
			/* L'utente esiste */
			request.getSession().setAttribute("user", user);
		}
	}

}