package it.polimi.db2.progettodb2.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.sql.Date;
import java.util.List;

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
		Date date1 = Date.valueOf("2021-07-21") ; //new java.sql.Date(System.currentTimeMillis())
		dailyAnswers = entityManager.createNamedQuery("getDailyAnswer", Answer.class).setParameter("date",date1).getResultList();
		if (dailyAnswers == null)
				System.out.println("daily null");
		return dailyAnswers;
	}
	

}
