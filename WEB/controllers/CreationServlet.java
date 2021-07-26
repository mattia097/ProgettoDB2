package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.db2.progettodb2.entities.Product;
import it.polimi.db2.progettodb2.entities.Question;
import it.polimi.db2.progettodb2.services.ProductService;
import it.polimi.db2.progettodb2.services.QuestionService;



public class CreationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/ProductService")
	private ProductService productService;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/QuestionService")
	private QuestionService questionService;
	
	
	public CreationServlet() {
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> products = productService.getAllProducts();
		Collections.sort(products);
		request.setAttribute("products", products);
		
		List<Question> questions = questionService.getAllQuestions();
		Collections.sort(questions);
		request.setAttribute("questions", questions);
		
		request.getRequestDispatcher("/Creation").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
}
