package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.db2.progettodb2.exceptions.ElementNotFoundException;
import it.polimi.db2.progettodb2.services.ProductService;

public class ModifyProductDate extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@EJB(name = "it.polimi.db2.progettodb2.services/ProductService")
	private ProductService productService;
	
	public ModifyProductDate() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ProductId = Integer.parseInt(request.getParameter("field-product-id"));
		Date productDate = Date.valueOf(request.getParameter("field-date"));
		
		
		try {
			productService.modifyProductDate(ProductId, productDate);;
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("CreationServlet");
	}
	
}
