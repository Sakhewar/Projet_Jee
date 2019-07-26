package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conditionnement database table.
 * 
 */
@Entity
@NamedQuery(name="Conditionnement.findAll", query="SELECT c FROM Conditionnement c")
public class Conditionnement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idconditionnement;

	private String libelleconditionnement;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="conditionnementBean", fetch=FetchType.EAGER)
	private List<Produit> produits;

	public Conditionnement() {
	}

	public Integer getIdconditionnement() {
		return this.idconditionnement;
	}

	public void setIdconditionnement(Integer idconditionnement) {
		this.idconditionnement = idconditionnement;
	}

	public String getLibelleconditionnement() {
		return this.libelleconditionnement;
	}

	public void setLibelleconditionnement(String libelleconditionnement) {
		this.libelleconditionnement = libelleconditionnement;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setConditionnementBean(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setConditionnementBean(null);

		return produit;
	}

}