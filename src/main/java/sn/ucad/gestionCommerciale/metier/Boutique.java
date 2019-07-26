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
	@GeneratedValue(strategy=GenerationType.AUTO)
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

	//bi-directional many-to-one association to Quartier
	@ManyToOne
	@JoinColumn(name="idquartier")
	private Quartier quartier;

	//bi-directional many-to-one association to Ravitaillement
	@OneToMany(mappedBy="boutique", fetch=FetchType.EAGER)
	private List<Ravitaillement> ravitaillements;

	//bi-directional many-to-one association to Stockboutique
	@OneToMany(mappedBy="boutique", fetch=FetchType.EAGER)
	private List<Stockboutique> stockboutiques;

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

	public Quartier getQuartier() {
		return this.quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public List<Ravitaillement> getRavitaillements() {
		return this.ravitaillements;
	}

	public void setRavitaillements(List<Ravitaillement> ravitaillements) {
		this.ravitaillements = ravitaillements;
	}

	public Ravitaillement addRavitaillement(Ravitaillement ravitaillement) {
		getRavitaillements().add(ravitaillement);
		ravitaillement.setBoutique(this);

		return ravitaillement;
	}

	public Ravitaillement removeRavitaillement(Ravitaillement ravitaillement) {
		getRavitaillements().remove(ravitaillement);
		ravitaillement.setBoutique(null);

		return ravitaillement;
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

}