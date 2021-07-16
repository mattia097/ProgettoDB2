package it.polimi.db2.progettodb2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO: table not done yet

@Entity
@Table(name = "offensive_word", schema = "db_progettodb2")
public class OffensiveWord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @Column(name="id")
	private int id;
	
	private String word;
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public OffensiveWord() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
