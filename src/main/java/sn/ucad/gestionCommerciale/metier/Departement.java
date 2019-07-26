package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departement database table.
 * 
 */
@Entity
@NamedQuery(name="Departement.findAll", query="SELECT d FROM Departement d")
public class Departement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer iddepartement;

	private String nomdepartement;

	//bi-directional many-to-one association to Commune
	@OneToMany(mappedBy="departement", fetch=FetchType.EAGER)
	private List<Commune> communes;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="idregion")
	private Region region;

	public Departement() {
	}

	public Integer getIddepartement() {
		return this.iddepartement;
	}

	public void setIddepartement(Integer iddepartement) {
		this.iddepartement = iddepartement;
	}

	public String getNomdepartement() {
		return this.nomdepartement;
	}

	public void setNomdepartement(String nomdepartement) {
		this.nomdepartement = nomdepartement;
	}

	public List<Commune> getCommunes() {
		return this.communes;
	}

	public void setCommunes(List<Commune> communes) {
		this.communes = communes;
	}

	public Commune addCommune(Commune commune) {
		getCommunes().add(commune);
		commune.setDepartement(this);

		return commune;
	}

	public Commune removeCommune(Commune commune) {
		getCommunes().remove(commune);
		commune.setDepartement(null);

		return commune;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}