package it.polimi.db2.progettodb2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

@NamedQuery(name = "getDaily", query = "SELECT p FROM Product p WHERE p.date = :date")
@NamedQuery(name = "getAllProducts", query = "SELECT p FROM Product p ORDER BY p.date ASC")

@Table(name = "Product")
public class Product implements Serializable, Comparable<Product> {
	private static final long serialVersionUID = 1L;

	/* unidirezionale, l'amministratore non ha riferimenti ai prodotti */
	/*
	 * no cascade: - l'amministratore è già inserito, non c'è il rischio che venga
	 * inserito senza un prodotto;
	 */
	@ManyToOne
	@JoinColumn(name = "administrator_id", nullable = false)
	private Administrator administrator;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false)
	private int productId;

	@Column(name = "product_name", nullable = false, unique = true)
	private String productName;

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "image", nullable = false)
	private String image;

	
	public Product() {
		super();
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String imageUrl) {
		this.image = imageUrl;
	}


	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Product [administrator=" + administrator + ", productId=" + productId + ", productName=" + productName
				+ ", date=" + date + ", image=" + image + "]";
	}

	@Override
	public int compareTo(Product o) {
		if(this.getProductId() > o.getProductId())
			return 1;
		else if (this.getProductId() < o.getProductId())
			return -1;
		// TODO Auto-generated method stub
		else
			return 0;
	}

	

}
