package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.db2.progettodb2.services.QuestionService;

public class CreateQuestion extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/QuestionService")
	private QuestionService questionService;
	
	public CreateQuestion() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("field-product-id"));
		String questionText = request.getParameter("field-question-text");
		questionService.insertQuestion(productId, questionText);
		response.sendRedirect("CreationServlet");		//doGet(request,response);
	}

}
