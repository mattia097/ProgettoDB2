package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.polimi.db2.progettodb2.entities.User;
import it.polimi.db2.progettodb2.services.Questionnaire;

/**
 * Servlet implementation class CancellQuestionnaireServlet
 */
public class CancellQuestionnaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellQuestionnaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		
		/* Assumiamo che il questionario esista: è stato generato nella servlet marketing */
		Questionnaire questionnaire = (Questionnaire) session.getAttribute("questionnaire");
		questionnaire.saveIncomplete(user);
		
		response.sendRedirect("HomeServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
