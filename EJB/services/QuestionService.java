package it.polimi.db2.progettodb2.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.progettodb2.entities.Product;
import it.polimi.db2.progettodb2.entities.Question;

/**
 * Session Bean implementation class QuestionService
 */
@Stateless
public class QuestionService {
	@PersistenceContext(unitName = "DB2ProjectEJB")
	private EntityManager entityManager;

	/*
	 * Permetterà di poter utilizzare il metodo per ricavare il prodotto del giorno.
	 */
	@EJB(name = "it.polimi.db2.progettodb2.services/ProductService")
	private ProductService productService;

	/**
	 * Default constructor.
	 */
	public QuestionService() {
		// TODO Auto-generated constructor stub
	}

	public List<Question> getQuestionsOfProductOfTheDay() {
		/* now "productOfTheDay" is NOT managed */
		Product productOfTheDay = productService.getProductOfTheDay();

		List<Question> questions = entityManager.createNamedQuery("Question.getQuestionsByProduct", Question.class)
				.setParameter("product", productOfTheDay).getResultList();

		return questions;
	}
}
