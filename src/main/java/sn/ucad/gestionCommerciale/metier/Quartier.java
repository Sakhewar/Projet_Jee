package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the quartier database table.
 * 
 */
@Entity
@NamedQuery(name="Quartier.findAll", query="SELECT q FROM Quartier q")
public class Quartier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idquartier;

	private String nomquartier;

	//bi-directional many-to-one association to Boutique
	@OneToMany(mappedBy="quartier", fetch=FetchType.EAGER)
	private List<Boutique> boutiques;

	//bi-directional many-to-one association to Commune
	@ManyToOne
	@JoinColumn(name="idcommune")
	private Commune commune;

	public Quartier() {
	}

	public Integer getIdquartier() {
		return this.idquartier;
	}

	public void setIdquartier(Integer idquartier) {
		this.idquartier = idquartier;
	}

	public String getNomquartier() {
		return this.nomquartier;
	}

	public void setNomquartier(String nomquartier) {
		this.nomquartier = nomquartier;
	}

	public List<Boutique> getBoutiques() {
		return this.boutiques;
	}

	public void setBoutiques(List<Boutique> boutiques) {
		this.boutiques = boutiques;
	}

	public Boutique addBoutique(Boutique boutique) {
		getBoutiques().add(boutique);
		boutique.setQuartier(this);

		return boutique;
	}

	public Boutique removeBoutique(Boutique boutique) {
		getBoutiques().remove(boutique);
		boutique.setQuartier(null);

		return boutique;
	}

	public Commune getCommune() {
		return this.commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

}