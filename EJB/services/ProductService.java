package it.polimi.db2.progettodb2.services;

import java.sql.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.progettodb2.entities.Administrator;
import it.polimi.db2.progettodb2.entities.Product;
import it.polimi.db2.progettodb2.exceptions.ElementNotFoundException;

/**
 * Session Bean implementation class ProductService
 */
@Stateless
public class ProductService {
	@PersistenceContext(unitName = "DB2ProjectEJB")
	private EntityManager entityManager;
	private Product productOfTheDay;

	/**
	 * Default constructor.
	 */
	public ProductService() {
	}

	public void insertProduct(int administratorId, int productId, String productName, Date date)
			throws ElementNotFoundException {
		Product newProduct = new Product();

		/*
		 * Cerca l'amministratore con l'id specificato. Se non esiste vuol dire che il
		 * valore passato non è valido o è stato manomesso.
		 */
		Administrator administrator = entityManager.find(Administrator.class, administratorId);

		if (administrator == null) {
			throw new ElementNotFoundException("L'elemento richiesto non esiste (amministratore)");
		}

		newProduct.setAdministrator(administrator);
		// productId è automatico ??
		newProduct.setProductName(productName);
		newProduct.setDate(date);

		entityManager.persist(newProduct);
	}
	
	
	public Product getProductOfTheDay() {
		
		Date date1 = Date.valueOf("2021-07-21") ; //new java.sql.Date(System.currentTimeMillis())

		productOfTheDay = entityManager.createNamedQuery("getDaily", Product.class).setParameter("date",date1).getSingleResult();
		
		return productOfTheDay;
	}
	
	
}
