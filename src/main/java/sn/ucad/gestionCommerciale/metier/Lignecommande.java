package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lignecommande database table.
 * 
 */
@Entity
@NamedQuery(name="Lignecommande.findAll", query="SELECT l FROM Lignecommande l")
public class Lignecommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LignecommandePK id;

	private Integer quantite;

	private double soustotal;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="idcommande" ,  insertable=false , updatable=false)
	private Commande commande;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="idproduit" ,  insertable=false , updatable=false)
	private Produit produit;

	public Lignecommande() {
	}

	public LignecommandePK getId() {
		return this.id;
	}

	public void setId(LignecommandePK id) {
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

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}