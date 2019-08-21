package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the format database table.
 * 
 */
@Entity
@NamedQuery(name="Format.findAll", query="SELECT f FROM Format f")
public class Format implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idformat;

	private String libelleformat;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="formatBean", fetch=FetchType.EAGER)
	private List<Produit> produits;

	public Format() {
	}

	public Integer getIdformat() {
		return this.idformat;
	}

	public void setIdformat(Integer idformat) {
		this.idformat = idformat;
	}

	public String getLibelleformat() {
		return this.libelleformat;
	}

	public void setLibelleformat(String libelleformat) {
		this.libelleformat = libelleformat;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setFormatBean(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setFormatBean(null);

		return produit;
	}

}