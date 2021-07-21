package it.polimi.db2.progettodb2.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.progettodb2.entities.Product;
import it.polimi.db2.progettodb2.entities.Review;

@Stateless
public class ReviewService {
	@PersistenceContext(unitName = "DB2ProjectEJB")
	private EntityManager entityManager;
	private List<Review> reviews;
	
	public ReviewService() {
		
	}
	
	public List<Review> getDailyReviews(Product product){
		reviews =  entityManager.createNamedQuery("getProductReviews", Review.class).setParameter("product",product).getResultList();
		return reviews;
	}
	

}
