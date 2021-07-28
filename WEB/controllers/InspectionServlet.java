package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.db2.progettodb2.entities.Answer;
import it.polimi.db2.progettodb2.services.AnswerService;

public class InspectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/AnswerService")
	private AnswerService answerService;
	
	public InspectionServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/Inspection").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date1 = Date.valueOf(request.getParameter("field-date"));
		List<Answer> dailyAnswers = answerService.getAnswersByDate(date1);
		request.setAttribute("answers", dailyAnswers);
		request.setAttribute("date", date1);
		doGet(request, response);
		
	}

}
