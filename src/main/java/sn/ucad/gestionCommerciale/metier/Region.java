package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the region database table.
 * 
 */
@Entity
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idregion;

	private String nomregion;

	//bi-directional many-to-one association to Departement
	@OneToMany(mappedBy="region", fetch=FetchType.EAGER)
	private List<Departement> departements;

	public Region() {
	}

	public Integer getIdregion() {
		return this.idregion;
	}

	public void setIdregion(Integer idregion) {
		this.idregion = idregion;
	}

	public String getNomregion() {
		return this.nomregion;
	}

	public void setNomregion(String nomregion) {
		this.nomregion = nomregion;
	}

	public List<Departement> getDepartements() {
		return this.departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public Departement addDepartement(Departement departement) {
		getDepartements().add(departement);
		departement.setRegion(this);

		return departement;
	}

	public Departement removeDepartement(Departement departement) {
		getDepartements().remove(departement);
		departement.setRegion(null);

		return departement;
	}

}