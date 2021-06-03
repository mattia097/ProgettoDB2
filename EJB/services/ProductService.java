package it.polimi.db2.progettodb2.services;

import java.util.Date;

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

		newProduct.setAdministratorId(administrator.getId());
		// productId è automatico ??
		newProduct.setProductName(productName);
		newProduct.setDate(date);

		entityManager.persist(newProduct);
	}
}
