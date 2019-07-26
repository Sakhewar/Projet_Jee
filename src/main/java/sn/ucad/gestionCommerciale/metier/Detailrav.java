package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detailrav database table.
 * 
 */
@Entity
@NamedQuery(name="Detailrav.findAll", query="SELECT d FROM Detailrav d")
public class Detailrav implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetailravPK id;

	private Integer quantite;

	private double soustotal;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="idproduit" ,  insertable=false , updatable=false)
	private Produit produit;

	//bi-directional many-to-one association to Ravitaillement
	@ManyToOne
	@JoinColumn(name="idravitaillement" ,  insertable=false , updatable=false)
	private Ravitaillement ravitaillement;

	public Detailrav() {
	}

	public DetailravPK getId() {
		return this.id;
	}

	public void setId(DetailravPK id) {
		this.id = id;
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

	public Ravitaillement getRavitaillement() {
		return this.ravitaillement;
	}

	public void setRavitaillement(Ravitaillement ravitaillement) {
		this.ravitaillement = ravitaillement;
	}

}