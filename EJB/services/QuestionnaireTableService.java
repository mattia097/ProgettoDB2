package it.polimi.db2.progettodb2.services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    	//questionnaireTable.setPoints(points);
    	
    	entityManager.persist(questionnaireTable);
    	entityManager.flush();
    }
}
