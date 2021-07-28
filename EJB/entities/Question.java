package it.polimi.db2.progettodb2.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity
@NamedQuery(name = "Question.getQuestionsByProduct", query = "SELECT q FROM Question q WHERE q.product = :product")
@NamedQuery(name = "Question.getAllQuestions", query = "SELECT q FROM Question q")
@Table(name = "question")
public class Question implements Serializable, Comparable<Question> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id", nullable = false)
	private int questionId;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "question_text", nullable = false)
	private String questionText;

	public Question() {
		super();
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Override
	public String toString() {
		return "QuestionId: " + this.getQuestionId() + "ProductId: " + this.getProduct() + "QuestionText: "
				+ this.getQuestionText();
	}
	
	@Override
	public int compareTo(Question o) {
		return this.getProduct().compareTo(o.getProduct());
		// TODO Auto-generated method stub
	}

}
