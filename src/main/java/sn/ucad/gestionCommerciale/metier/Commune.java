package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the commune database table.
 * 
 */
@Entity
@NamedQuery(name="Commune.findAll", query="SELECT c FROM Commune c")
public class Commune implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idcommune;

	private String nomcommune;

	//bi-directional many-to-one association to Departement
	@ManyToOne
	@JoinColumn(name="iddepartement")
	private Departement departement;

	//bi-directional many-to-one association to Quartier
	@OneToMany(mappedBy="commune", fetch=FetchType.EAGER)
	private List<Quartier> quartiers;

	public Commune() {
	}

	public Integer getIdcommune() {
		return this.idcommune;
	}

	public void setIdcommune(Integer idcommune) {
		this.idcommune = idcommune;
	}

	public String getNomcommune() {
		return this.nomcommune;
	}

	public void setNomcommune(String nomcommune) {
		this.nomcommune = nomcommune;
	}

	public Departement getDepartement() {
		return this.departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Quartier> getQuartiers() {
		return this.quartiers;
	}

	public void setQuartiers(List<Quartier> quartiers) {
		this.quartiers = quartiers;
	}

	public Quartier addQuartier(Quartier quartier) {
		getQuartiers().add(quartier);
		quartier.setCommune(this);

		return quartier;
	}

	public Quartier removeQuartier(Quartier quartier) {
		getQuartiers().remove(quartier);
		quartier.setCommune(null);

		return quartier;
	}

}