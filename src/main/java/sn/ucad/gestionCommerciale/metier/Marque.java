package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marque database table.
 * 
 */
@Entity
@NamedQuery(name="Marque.findAll", query="SELECT m FROM Marque m")
public class Marque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idmarque;

	private String libellemarque;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="marqueBean", fetch=FetchType.EAGER)
	private List<Produit> produits;

	public Marque() {
	}

	public Integer getIdmarque() {
		return this.idmarque;
	}

	public void setIdmarque(Integer idmarque) {
		this.idmarque = idmarque;
	}

	public String getLibellemarque() {
		return this.libellemarque;
	}

	public void setLibellemarque(String libellemarque) {
		this.libellemarque = libellemarque;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setMarqueBean(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setMarqueBean(null);

		return produit;
	}

}