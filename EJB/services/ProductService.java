package it.polimi.db2.progettodb2.services;

import java.sql.Date;
import java.util.List;

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

	public void insertProduct(int administratorId, String productName, Date date, String productImage)
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
		newProduct.setImage(productImage);
		entityManager.persist(newProduct);
		entityManager.flush();
	}
	
	
	public Product getProductOfTheDay() {
		
		Date date1 = new java.sql.Date(System.currentTimeMillis());//Date.valueOf("2021-07-21") ; 

		productOfTheDay = entityManager.createNamedQuery("getDaily", Product.class).setParameter("date",date1).getSingleResult();
		
		return productOfTheDay;
	}
	
	public List<Product> getAllProducts() {
		return entityManager.createNamedQuery("getAllProducts", Product.class).getResultList();
	}
	
	public void modifyProductDate(int productId, Date date) throws ElementNotFoundException{
		Product product = entityManager.find(Product.class, productId);
		if (product == null) {
			throw new ElementNotFoundException("L'elemento richiesto non esiste (prodotto)");
		}
		
		product.setDate(date);
		entityManager.persist(product);
		entityManager.flush();
	}
	
	
}
