package it.polimi.db2.progettodb2.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrator alter table
 * administrator add column password varchar(64) not null;
 */
@Entity
@Table(name = "administrator")
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String password;

	public Administrator() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
