package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.db2.progettodb2.entities.Product;
import it.polimi.db2.progettodb2.services.ProductService;
import it.polimi.db2.progettodb2.services.QuestionService;
import it.polimi.db2.progettodb2.services.QuestionnaireTableService;

/**
 * Servlet implementation class DeletionServlet
 */
public class DeletionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(name = "it.polimi.db2.progettodb2.services/ProductService")
	private ProductService productService;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/QuestionnaireTableService")
	private QuestionnaireTableService questionnaireTableService;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/QuestionService")
	private QuestionService questionService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = productService.getAllProducts();
		Collections.sort(products);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/Deletion").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("product-id"));
		
		questionnaireTableService.deleteQuestionnaireByProduct(productId);
		questionService.deleteQuestionsByProduct(productId);		
		
		doGet(request, response);
	}

}
