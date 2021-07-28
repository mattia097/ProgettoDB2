package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.db2.progettodb2.entities.Answer;
import it.polimi.db2.progettodb2.entities.QuestionnaireTable;
import it.polimi.db2.progettodb2.services.AnswerService;
import it.polimi.db2.progettodb2.services.QuestionnaireTableService;

public class InspectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/AnswerService")
	private AnswerService answerService;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/QuestionnaireTableService")
	private QuestionnaireTableService questionnaireTableService;
	
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
		List<Answer> answers = answerService.getAnswersByDate(date1);
		List<QuestionnaireTable> questionnaires = questionnaireTableService.getQuestionnaireByDate(date1); 
		questionnaires = getCanceledQuestionnaires(questionnaires);
		//answers = removeCanceledAnswers(answers, questionnaires);
		request.setAttribute("answers", answers);
		request.setAttribute("date", date1);
		request.setAttribute("questionnaires", questionnaires);
		doGet(request, response);
		
	}
	
	
	private List<QuestionnaireTable> getCanceledQuestionnaires(List<QuestionnaireTable> questionnaires){
		List<QuestionnaireTable> canceled = new ArrayList <QuestionnaireTable>();
		for (QuestionnaireTable q : questionnaires) {
			if (!q.isFilled()){
				canceled.add(q);
			}
		}
		
		return canceled;
	}
	
	
	
	private List<Answer> removeCanceledAnswers(List<Answer> answers, List<QuestionnaireTable> canceled) {
		
		List<Answer> canceledAnswers = new ArrayList<Answer>();
		
		
		for(QuestionnaireTable q: canceled) {
			for (Answer a : answers) {
				if(a.getQuestion().getProduct().getDate().getDay() == q.getQuestionnaireDate().getDay()  &&  
						a.getQuestion().getProduct().getDate().getMonth() == q.getQuestionnaireDate().getMonth()  &&  
						a.getQuestion().getProduct().getDate().getYear() == q.getQuestionnaireDate().getYear()) {
					canceledAnswers.add(a);
				}
			}
		}
		answers.removeAll(canceledAnswers);
		return answers;
		
	}

}
