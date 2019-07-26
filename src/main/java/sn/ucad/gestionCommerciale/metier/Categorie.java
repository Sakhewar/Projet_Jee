package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcategorie;

	private String libellecategorie;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="categorieBean", fetch=FetchType.EAGER)
	private List<Produit> produits;

	public Categorie() {
	}

	public Integer getIdcategorie() {
		return this.idcategorie;
	}

	public void setIdcategorie(Integer idcategorie) {
		this.idcategorie = idcategorie;
	}

	public String getLibellecategorie() {
		return this.libellecategorie;
	}

	public void setLibellecategorie(String libellecategorie) {
		this.libellecategorie = libellecategorie;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setCategorieBean(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setCategorieBean(null);

		return produit;
	}

}