package it.polimi.db2.progettodb2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	/* unidirezionale, l'amministratore non ha riferimenti ai prodotti */
	/* no cascade: 
	 * - l'amministratore è già inserito, non c'è il rischio che venga inserito senza un prodotto;
	 * */
	@ManyToOne
	@JoinColumn(name = "id")
	@Column(name = "administrator_id", nullable = false)
	private int administratorId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false)
	private int productId;

	@Column(name = "product_name", nullable = false, unique = true)
	private String productName;

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	private Date date;

	public Product() {
		super();
	}

	public int getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
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

}
