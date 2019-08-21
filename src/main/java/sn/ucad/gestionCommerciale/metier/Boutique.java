package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the boutique database table.
 * 
 */
@Entity
@NamedQuery(name="Boutique.findAll", query="SELECT b FROM Boutique b")
public class Boutique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idboutique;

	private String adresse;

	//bi-directional many-to-one association to Boutiquier
	@ManyToOne
	@JoinColumn(name="idboutiquier")
	private Boutiquier boutiquier;

	//bi-directional many-to-one association to Commercant
	@ManyToOne
	@JoinColumn(name="idcommercant")
	private Commercant commercant;

	//bi-directional many-to-one association to Stockboutique
	@OneToMany(mappedBy="boutique", fetch=FetchType.EAGER)
	private List<Stockboutique> stockboutiques;

	//bi-directional many-to-one association to Localisation
	@ManyToOne
	@JoinColumn(name="idlocalisation")
	private Localisation localisation;

	public Boutique() {
	}

	public Integer getIdboutique() {
		return this.idboutique;
	}

	public void setIdboutique(Integer idboutique) {
		this.idboutique = idboutique;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Boutiquier getBoutiquier() {
		return this.boutiquier;
	}

	public void setBoutiquier(Boutiquier boutiquier) {
		this.boutiquier = boutiquier;
	}

	public Commercant getCommercant() {
		return this.commercant;
	}

	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}

	public List<Stockboutique> getStockboutiques() {
		return this.stockboutiques;
	}

	public void setStockboutiques(List<Stockboutique> stockboutiques) {
		this.stockboutiques = stockboutiques;
	}

	public Stockboutique addStockboutique(Stockboutique stockboutique) {
		getStockboutiques().add(stockboutique);
		stockboutique.setBoutique(this);

		return stockboutique;
	}

	public Stockboutique removeStockboutique(Stockboutique stockboutique) {
		getStockboutiques().remove(stockboutique);
		stockboutique.setBoutique(null);

		return stockboutique;
	}

	public Localisation getLocalisation() {
		return this.localisation;
	}

	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

}