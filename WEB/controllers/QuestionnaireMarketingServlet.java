package it.polimi.db2.progettodb2.controllers;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.db2.progettodb2.services.OffensiveWordService;

public class QuestionnaireMarketingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name = "it.polimi.db2.progettodb2.services/OffensiveWordService")
	private OffensiveWordService offensiveWordService;

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

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      
	 *      Gestisce le risposte fatte dall'utente.
	 *      Chiamato quando l'utente ha risposto alle domande.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//doGet(request, response);
	}
	
	//check if an answer contains offensives, assuming the answer is a String
	private boolean containsOffensiveWord(String answer) {
		String[] words = splitSentenceByWords(answer);
		
		for(String word : words) {
			if(offensiveWordService.isOffensiveWord(word))
				return true;
		}
		
		return false;
	}
	
	private String[] splitSentenceByWords (String sentence) {
		if (sentence == null || sentence.equals(""))
			return new String[0];
		
		String[] words = sentence.split(" ");
		 
		return words;
	}

}