package it.polimi.db2.progettodb2.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import it.polimi.db2.progettodb2.entities.Product;
import it.polimi.db2.progettodb2.entities.Question;
import it.polimi.db2.progettodb2.entities.User;
import it.polimi.db2.progettodb2.entities.Answer;

@Stateless
public class AnswerService {
	@PersistenceContext(unitName = "DB2ProjectEJB")
	private EntityManager entityManager;
	
	private List<Answer> dailyAnswers;
	
	public AnswerService() {
		
	}
	
	public List<Answer> getDailyAnswers() {
		System.out.println("enters daily answers");
		Date date1 = new java.sql.Date(System.currentTimeMillis()); //Date.valueOf("2021-07-21")
		dailyAnswers = entityManager.createNamedQuery("getDailyAnswer", Answer.class).setParameter("date",date1).getResultList();
		
		return dailyAnswers;
	}
	
	public List<Answer> getAnswersByDate(Date date1) {
		
		return entityManager.createNamedQuery("getDailyAnswer", Answer.class).setParameter("date",date1).getResultList();
	}
	
	public void insertAnswer(User user, Question question, int points, Boolean answerBool) {
		Answer answer = new Answer();
		
		answer.setUser(user);
		answer.setQuestion(question);
		answer.setPoints(points);
		answer.setAnswer(answerBool);
		
		entityManager.persist(answer);
		entityManager.flush();
	}
}
