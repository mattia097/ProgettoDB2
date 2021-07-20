package it.polimi.db2.progettodb2.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import it.polimi.db2.progettodb2.entities.Answer;

import it.polimi.db2.progettodb2.entities.User;
import it.polimi.db2.progettodb2.exceptions.CredentialsException;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService {
	@PersistenceContext(unitName = "DB2ProjectEJB")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public User checkCredentials(String username, String password) throws CredentialsException {
		List<User> users = null;

		try {
			/* entityManager.find(...) ?? */
			users = entityManager.createNamedQuery("User.checkCredentials", User.class).setParameter(1, username)
					.setParameter(2, password).getResultList();
		} catch (PersistenceException e) {
			throw new CredentialsException("Impossibile verificare le credenziali");
		}

		if (users.isEmpty()) {
			/* Nessun utente con le credenziali specificate */
			return null;
		} else if (users.size() == 1) {
			return users.get(0);
		} else {
			/* Situazione anomala */
			throw new CredentialsException("Più di un utente con la stessa username e password");
		}
	}

	public void register(String name, String surname, String username, String email, String password, Date birthDate,
			String sex) {
		User newUser = new User();

		newUser.setName(name);
		newUser.setSurname(surname);
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setBirthDate(birthDate);
		newUser.setSex(sex);

		entityManager.persist(newUser); /* Aggiunto al PersistenceContext */
		
		/* Operazione fatta in automatico alla fine del metodo, non è necessaria... */
		entityManager.flush(); /* Sincronizzazione col DB */
	}
	
	public List<String> getByPoints(List<Answer> dailyAnswers){
		List<User> users = new ArrayList<User>();
		List<AtomicInteger> points = new ArrayList<AtomicInteger>();

		User user;
		int index;
		
		for(Answer a : dailyAnswers) {
			user = a.getUser();
			if (!(users.contains(user))) {
				users.add(a.getUser());
				points.add(new AtomicInteger(a.getPoints()));
			}
			else {
				index = users.indexOf(user);
				points.get(index).set(points.get(index).get() + a.getPoints());
			}
		}
		return ToLeaderboard(users, points);
		//entityManager.createNamedQuery("User.getByPoints", User.class).getResultList()
	}
	
	public List<String> ToLeaderboard(List<User> users, List<AtomicInteger> points){
		List<String> leaderboard = new ArrayList<String>();
		
		
		for(int i = 1; i <= users.size(); i++) {
			leaderboard.add(i + ".  " + users.get(i-1).getUsername() + ":                      " + points.get(i-1).get() + " points");
			
		}
		
		
		return leaderboard;
	}
	
	
//	public User getByEmail(String email) {
//		return entityManager.createNamedQuery("User.getByEmail", User.class).getSingleResult();
//	}
}