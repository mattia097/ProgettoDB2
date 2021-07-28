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
import it.polimi.db2.progettodb2.services.QuestionnaireTableService;
import it.polimi.db2.progettodb2.services.UserService;


public class LeaderboardServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/QuestionnaireTableService")
	private QuestionnaireTableService questionnaireTableService;
	
	public LeaderboardServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date date1 = new java.sql.Date(System.currentTimeMillis()); 
		request.setAttribute("questionnaires", questionnaireTableService.getQuestionnaireByDate(date1)); //TODO: da correggere
		request.getRequestDispatcher("/Leaderboard").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	

}
