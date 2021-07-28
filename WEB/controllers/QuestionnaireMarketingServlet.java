package it.polimi.db2.progettodb2.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.polimi.db2.progettodb2.entities.Question;
import it.polimi.db2.progettodb2.entities.User;
import it.polimi.db2.progettodb2.services.OffensiveWordService;
import it.polimi.db2.progettodb2.services.QuestionService;
import it.polimi.db2.progettodb2.services.Questionnaire;
import it.polimi.db2.progettodb2.services.QuestionnaireTableService;

@EJB(name = "it.polimi.db2.progettodb2.services/Questionnaire", beanInterface = Questionnaire.class)
public class QuestionnaireMarketingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_POINTS = 1;

	@EJB(name = "it.polimi.db2.progettodb2.services/QuestionService")
	private QuestionService questionService;

	@EJB(name = "it.polimi.db2.progettodb2.services/OffensiveWordService")
	private OffensiveWordService offensiveWordService;

	@EJB(name = "it.polimi.db2.progettodb2.services/QuestionnaireTableService")
	private QuestionnaireTableService questionnaireTableService;

	private List<Question> questionsOfProductOfTheDay;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestionnaireMarketingServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 *      Richiede le domande di marketing relative al prodotto del giorno.
	 *      Reindirizza alla pagina che le mostra.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");

		/* Se il questionario del giorno non è stato già compilato allora lo mostra */
		if (!questionnaireTableService.isTodayQuestionnaireAlreadyComplete(user)) {
			Questionnaire questionnaire = (Questionnaire) session.getAttribute("questionnaire");

			/*
			 * Se esiste un questionario precedente, le vecchie risposte vengono cancellate.
			 */
			if (questionnaire != null) {
				questionnaire.deleteAnswersList();
			}

			questionsOfProductOfTheDay = questionService.getQuestionsOfProductOfTheDay();
			request.setAttribute("questions", questionsOfProductOfTheDay);
			request.setAttribute("productName", questionService.getProductOfTheDayName());
			request.getRequestDispatcher("/QuestionnaireMarketing").forward(request, response);
		} else {
			/* altrimenti ritorna alla home */
			response.sendRedirect("HomeServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 *      Gestisce le risposte fatte dall'utente. Chiamato quando l'utente ha
	 *      risposto alle domande.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session;
		String answerText;
		Boolean currentAnswer;
		int points;
		User loggedUser;

		session = request.getSession(true);

		/*
		 * Istanzia un questionario (se non esiste già) per l'utente corrente e lo salva
		 * nella sessione.
		 */
		Questionnaire questionnaire = (Questionnaire) session.getAttribute("questionnaire");
		if (questionnaire == null) {
			try {
				questionnaire = (Questionnaire) new InitialContext()
						.lookup("java:comp/env/it.polimi.db2.progettodb2.services/Questionnaire");
			} catch (NamingException e) {
				e.printStackTrace();
			}

			session.setAttribute("questionnaire", questionnaire);
		}

		loggedUser = (User) session.getAttribute("user");

		for (Question q : questionsOfProductOfTheDay) {
			answerText = request.getParameter("rd_" + q.getQuestionId());

			if (answerText != null) {
				if (answerText.equals("yes")) {
					points = MAX_POINTS;
					currentAnswer = true;
				} else if (answerText.equals("no")) {
					points = MAX_POINTS;
					currentAnswer = false;
				} else {
					/* No answer */
					points = 0;
					currentAnswer = null;
				}
			} else {
				/* No answer */
				points = 0;
				currentAnswer = null;
			}

			questionnaire.insertAnswer(loggedUser, q, points, currentAnswer);
		}

		request.getRequestDispatcher("/StatisticQuestionnaire").forward(request, response);
	}

	// check if an answer contains offensives, assuming the answer is a String
	private boolean containsOffensiveWord(String answer) {
		String[] words = splitSentenceByWords(answer);

		for (String word : words) {
			if (offensiveWordService.isOffensiveWord(word))
				return true;
		}

		return false;
	}

	private String[] splitSentenceByWords(String sentence) {
		if (sentence == null || sentence.equals(""))
			return new String[0];

		String[] words = sentence.split(" ");

		return words;
	}

}