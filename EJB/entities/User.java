package it.polimi.db2.progettodb2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.checkCredentials", query = "SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
//@NamedQuery(name = "User.getByPoints", query ="SELECT u FROM User u ORDER BY u.points DESC" )
//@NamedQuery(name = "User.getByEmail", query ="SELECT u FROM User u WHERE u.email = :email" )
public class User implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Id
	@Column(nullable = false)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date birthDate;

	private String sex;

	private String expertise;
	
	@Column(name = "is_public", nullable = false)
	private boolean isPublic;

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", birthDate=" + birthDate + ", sex=" + sex + ", isPublic=" + isPublic
				+ "]";
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
//	public List<String> ToLeaderboard(List<User> users){
//		List<String> leaderboard = new ArrayList<String>();
//		int counter;
//		
//		for(User u: users) {
//			leaderboard.add(u.username + " " + u.points + "points");
//		}
//		
//		
//		return leaderboard;
//	}

}