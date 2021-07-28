package it.polimi.db2.progettodb2.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.progettodb2.entities.Product;
import it.polimi.db2.progettodb2.entities.QuestionnaireTable;
import it.polimi.db2.progettodb2.entities.User;

/**
 * Session Bean implementation class QuestionnaireTableService
 */
@Stateless
public class QuestionnaireTableService {

	@PersistenceContext(unitName = "DB2ProjectEJB")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public QuestionnaireTableService() {
		// TODO Auto-generated constructor stub
	}

	public void insertQuestionnaireTable(Date questionnaireDate, User user, boolean filled) {
		QuestionnaireTable questionnaireTable = new QuestionnaireTable();

		questionnaireTable.setQuestionnaireDate(questionnaireDate);
		questionnaireTable.setUser(user);
		questionnaireTable.setFilled(filled);
		// questionnaireTable.setPoints(points);

		entityManager.persist(questionnaireTable);
		entityManager.flush();
	}

	public List<QuestionnaireTable> getQuestionnaireByDate(Date date) {

		return entityManager.createNamedQuery("getQuestionnaireByDate", QuestionnaireTable.class)
				.setParameter("date", date).getResultList();
	}

	public boolean isTodayQuestionnaireAlreadyComplete(User user) {
		java.sql.Date todayDate = new java.sql.Date(System.currentTimeMillis());

		List<QuestionnaireTable> questionnaireTableList = entityManager
				.createNamedQuery("getQuestionnaireOfTheDayOfUser", QuestionnaireTable.class).setParameter("user", user)
				.setParameter("date", todayDate).getResultList();

		if (questionnaireTableList == null || questionnaireTableList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public void deleteQuestionnaireByProduct(int productId) {
		Product product = entityManager.find(Product.class, productId);
		
		List<QuestionnaireTable> qtToDelete = entityManager.createNamedQuery("getQuestionnaireByDate", QuestionnaireTable.class).setParameter("date", product.getDate()).getResultList();
	
		for (QuestionnaireTable q : qtToDelete) {
			entityManager.remove(q);
		}
		
		entityManager.flush();
	}
}
