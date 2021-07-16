package it.polimi.db2.progettodb2.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.progettodb2.entities.OffensiveWord;

@Stateless
public class OffensiveWordService {
	@PersistenceContext(unitName = "DB2ProjectEJB")
	private EntityManager entityManager;

	public OffensiveWordService() {
		
	}
	
	
	public boolean isOffensiveWord(String word) {
		OffensiveWord wordFound;
		
		wordFound = entityManager.find(OffensiveWord.class, word.toLowerCase()); //the lookup for id is not possible
		//TODO: consider the possibility of a composition of words containing one or more offensive ones
		
		
		if (wordFound == null)
			return false;
		
		return true;
	}
	

}
