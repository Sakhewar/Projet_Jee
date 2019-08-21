package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localisation database table.
 * 
 */
@Entity
@NamedQuery(name="Localisation.findAll", query="SELECT l FROM Localisation l")
public class Localisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlocalisation;

	private String commune;

	private String departement;

	private String quartier;

	private String region;

	//bi-directional many-to-one association to Boutique
	@OneToMany(mappedBy="localisation", fetch=FetchType.EAGER)
	private List<Boutique> boutiques;

	public Localisation() {
	}

	public Integer getIdlocalisation() {
		return this.idlocalisation;
	}

	public void setIdlocalisation(Integer idlocalisation) {
		this.idlocalisation = idlocalisation;
	}

	public String getCommune() {
		return this.commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getQuartier() {
		return this.quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Boutique> getBoutiques() {
		return this.boutiques;
	}

	public void setBoutiques(List<Boutique> boutiques) {
		this.boutiques = boutiques;
	}

	public Boutique addBoutique(Boutique boutique) {
		getBoutiques().add(boutique);
		boutique.setLocalisation(this);

		return boutique;
	}

	public Boutique removeBoutique(Boutique boutique) {
		getBoutiques().remove(boutique);
		boutique.setLocalisation(null);

		return boutique;
	}

}