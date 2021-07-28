package it.polimi.db2.progettodb2.services;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import it.polimi.db2.progettodb2.entities.Answer;
import it.polimi.db2.progettodb2.entities.Question;
import it.polimi.db2.progettodb2.entities.User;

/**
 * Session Bean implementation class Questionnaire
 */
@Stateful
public class Questionnaire {
	private List<Answer> answers;
	private User user;
	private int age;
	private String gender;
	private String expertise;
	final String dateFormat = "yyyy-MM-dd"; /* SQL-like format */

	@EJB(name = "it.polimi.db2.progettodb2.services/AnswerService")
	private AnswerService answerService;

	@EJB(name = "it.polimi.db2.progettodb2.services/UserService")
	private UserService userService;

	@EJB(name = "it.polimi.db2.progettodb2.services/QuestionnaireTableService")
	private QuestionnaireTableService questionnaireTableService;

	/**
	 * Default constructor.
	 */
	public Questionnaire() {
		this.answers = new ArrayList<Answer>();
		this.user = null;
		this.gender = "";
		this.expertise = "";
	}

	public void deleteAnswersList() {
		this.answers.clear();
	}

	/**
	 * Inserisce una risposta nella lista. La risposta NON viene gestita.
	 */
	public void insertAnswer(User user, Question question, int points, Boolean answerBool) {
		Answer answer = new Answer();

		answer.setUser(user);
		answer.setQuestion(question);
		answer.setPoints(points);
		answer.setAnswer(answerBool);

		answers.add(answer);
	}

	/**
	 * Inserisce i valori della parte statistica del questionario. L'utente NON
	 * viene aggiornato.
	 */
	public void insertStatistics(User user, int age, String gender, String expertise) {
		this.user = user;
		this.age = age;
		this.gender = gender;
		this.expertise = expertise;
	}

	/**
	 * Salva le informazioni relative al form con le domande sul prodotto del
	 * giorno. Salva le informazioni relative al form con le domande statistiche.
	 */
	public void save() {
		Date todayDate = new Date(System.currentTimeMillis());

		questionnaireTableService.insertQuestionnaireTable(todayDate, this.user, true);

		/*
		 * ! ATTENZIONE !
		 * 
		 * Prima di inserire le risposte dev'essere inserito il questionario.
		 */

		for (Answer a : answers) {
			// System.out.println(a);
			answerService.insertAnswer(a.getUser(), a.getQuestion(), a.getPoints(), a.isAnswer());
		}

		userService.updateStatisticalData(user, gender, expertise);
	}

	public void saveIncomplete(User user) {
		Date todayDate = new Date(System.currentTimeMillis());

		questionnaireTableService.insertQuestionnaireTable(todayDate, user, false);
	}
}
