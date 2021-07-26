package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.polimi.db2.progettodb2.entities.User;
import it.polimi.db2.progettodb2.services.QuestionService;
import it.polimi.db2.progettodb2.services.Questionnaire;


//TODO: Scrivere l'esito del questionario sul database

@EJB(name = "it.polimi.db2.progettodb2.services/Questionnaire", beanInterface = Questionnaire.class)
public class GreetingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public GreetingsServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Greetings");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		User user;
		Questionnaire questionnaire;
		int age;
		String gender;
		String expertise;
		
		// TODO: per ora stiamo assumendo che il questionario sia stato generato, 
		// TODO: altrimenti viene lanciata un' eccezione.
		session = request.getSession(true);
		user = (User) session.getAttribute("user");
		questionnaire = (Questionnaire) session.getAttribute("questionnaire");
		
		/* Raccolta e salvataggio dei valori del questionario statistico */
		age = Integer.parseInt(request.getParameter("field-age"));
		gender = request.getParameter("gender");
		expertise = request.getParameter("expertise");
		
		questionnaire.insertStatistics(user, age, gender, expertise);		
		
		/* Alla fine di tutti gli inserimenti, salva il questionario... */
		questionnaire.save();
		
		/* ...e reindirizza alla pagina con i ringraziamenti */
		doGet(request, response);
	}
	
}
