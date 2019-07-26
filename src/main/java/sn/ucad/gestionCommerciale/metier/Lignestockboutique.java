package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lignestockboutique database table.
 * 
 */
@Entity
@NamedQuery(name="Lignestockboutique.findAll", query="SELECT l FROM Lignestockboutique l")
public class Lignestockboutique implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LignestockboutiquePK id;

	private double prixachtaproduit;

	private Integer quantite;

	private double soustotal;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="idproduit" ,  insertable=false , updatable=false)
	private Produit produit;

	//bi-directional many-to-one association to Stockboutique
	@ManyToOne
	@JoinColumn(name="idstockboutique" ,  insertable=false , updatable=false )
	private Stockboutique stockboutique;

	public Lignestockboutique() {
	}

	public LignestockboutiquePK getId() {
		return this.id;
	}

	public void setId(LignestockboutiquePK id) {
		this.id = id;
	}

	public double getPrixachtaproduit() {
		return this.prixachtaproduit;
	}

	public void setPrixachtaproduit(double prixachtaproduit) {
		this.prixachtaproduit = prixachtaproduit;
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

	public Stockboutique getStockboutique() {
		return this.stockboutique;
	}

	public void setStockboutique(Stockboutique stockboutique) {
		this.stockboutique = stockboutique;
	}

}