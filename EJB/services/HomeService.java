package it.polimi.db2.progettodb2.services;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import it.polimi.db2.progettodb2.entities.Administrator;
import it.polimi.db2.progettodb2.entities.Product;

import java.sql.Date;

import javax.ejb.LocalBean;

/**TODO: 
 * -check in the slides if a stateful local bean makes sense.
 * -access to the Potd (table PRODUCT)
 * -access to its reviews (table REVIEWS)
 * -access to its questionnaire 
**/
@Stateful
@LocalBean
public class HomeService {
	@PersistenceContext(unitName = "DB2ProjectEJB")
	private EntityManager entityManager;
	private Product productOfTheDay;
	
	
	public HomeService() {
		
	}
	
	
//	public Product getProductOfTheDay() {
//		
//		Date date1 = Date.valueOf("2021-07-21") ; //new java.sql.Date(System.currentTimeMillis())
//
//		productOfTheDay = entityManager.createNamedQuery("getDaily", Product.class).setParameter("date",date1).getSingleResult();
//		
//		return productOfTheDay;
//	}
	
	
	

}
