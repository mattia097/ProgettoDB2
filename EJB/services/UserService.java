package it.polimi.db2.progettodb2.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

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
}
