package it.polimi.db2.progettodb2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: QuestionnaireTable
 *
 */
@Entity
@NamedQuery(name = "getQuestionnaireByDate", query = "SELECT q FROM QuestionnaireTable q WHERE q.questionnaireDate = :date")
@Table(name = "questionnaire")
public class QuestionnaireTable implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_questionnaire", nullable = false)
	private int idQuestionnaire;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "questionnaire_date", nullable = false)
	private Date questionnaireDate;
	
	@ManyToOne
	@JoinColumn(name = "email_user", nullable = false)
	private User user;
	
	@Column(name = "filled", nullable = false)
	private boolean filled;
	
	@Column(name = "points", nullable = false)
	private int points;

	public QuestionnaireTable() {
		super();
	}

	public int getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(int idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public Date getQuestionnaireDate() {
		return questionnaireDate;
	}

	public void setQuestionnaireDate(Date questionnaireDate) {
		this.questionnaireDate = questionnaireDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
   
}
