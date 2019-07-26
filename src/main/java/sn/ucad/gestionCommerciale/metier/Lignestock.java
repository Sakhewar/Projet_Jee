package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lignestock database table.
 * 
 */
@Entity
@NamedQuery(name="Lignestock.findAll", query="SELECT l FROM Lignestock l")
public class Lignestock implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LignestockPK id;

	private double prixachat;

	private Integer quantite;

	private double soustotal;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="idproduit" ,  insertable=false , updatable=false)
	private Produit produit;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="idstock" ,  insertable=false , updatable=false)
	private Stock stock;

	public Lignestock() {
	}

	public LignestockPK getId() {
		return this.id;
	}

	public void setId(LignestockPK id) {
		this.id = id;
	}

	public double getPrixachat() {
		return this.prixachat;
	}

	public void setPrixachat(double prixachat) {
		this.prixachat = prixachat;
	}

	public Integer getQuantite() {
		return this.quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public double getSoustotal() {
		return this.soustotal;
	}

	public void setSoustotal(double soustotal) {
		this.soustotal = soustotal;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}