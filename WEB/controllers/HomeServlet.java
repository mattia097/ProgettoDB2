package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.db2.progettodb2.entities.Product;
import it.polimi.db2.progettodb2.services.ProductService;
import it.polimi.db2.progettodb2.services.ReviewService;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "it.polimi.db2.progettodb2.services/ProductService")
	private ProductService productService;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/ReviewService")
	private ReviewService reviewService;

	public HomeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product = productService.getProductOfTheDay();
		
		request.setAttribute("productOfTheDay", product);
		
		request.setAttribute("reviews", reviewService.getDailyReviews(product));
		
		
		request.getRequestDispatcher("/Home").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
