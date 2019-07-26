package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ravitaillement database table.
 * 
 */
@Entity
@NamedQuery(name="Ravitaillement.findAll", query="SELECT r FROM Ravitaillement r")
public class Ravitaillement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idravitaillement;

	private Timestamp daterav;

	private String etatrav;

	private double prixtotalrav;

	private Integer totalproduitrav;

	//bi-directional many-to-one association to Detailrav
	@OneToMany(mappedBy="ravitaillement", fetch=FetchType.EAGER)
	private List<Detailrav> detailravs;

	//bi-directional many-to-one association to Facturerav
	@OneToMany(mappedBy="ravitaillement", fetch=FetchType.EAGER)
	private List<Facturerav> factureravs;

	//bi-directional many-to-one association to Boutique
	@ManyToOne
	@JoinColumn(name="idboutique")
	private Boutique boutique;

	//bi-directional many-to-one association to Commercant
	@ManyToOne
	@JoinColumn(name="idcommercant")
	private Commercant commercant;

	public Ravitaillement() {
	}

	public Integer getIdravitaillement() {
		return this.idravitaillement;
	}

	public void setIdravitaillement(Integer idravitaillement) {
		this.idravitaillement = idravitaillement;
	}

	public Timestamp getDaterav() {
		return this.daterav;
	}

	public void setDaterav(Timestamp daterav) {
		this.daterav = daterav;
	}

	public String getEtatrav() {
		return this.etatrav;
	}

	public void setEtatrav(String etatrav) {
		this.etatrav = etatrav;
	}

	public double getPrixtotalrav() {
		return this.prixtotalrav;
	}

	public void setPrixtotalrav(double prixtotalrav) {
		this.prixtotalrav = prixtotalrav;
	}

	public Integer getTotalproduitrav() {
		return this.totalproduitrav;
	}

	public void setTotalproduitrav(Integer totalproduitrav) {
		this.totalproduitrav = totalproduitrav;
	}

	public List<Detailrav> getDetailravs() {
		return this.detailravs;
	}

	public void setDetailravs(List<Detailrav> detailravs) {
		this.detailravs = detailravs;
	}

	public Detailrav addDetailrav(Detailrav detailrav) {
		getDetailravs().add(detailrav);
		detailrav.setRavitaillement(this);

		return detailrav;
	}

	public Detailrav removeDetailrav(Detailrav detailrav) {
		getDetailravs().remove(detailrav);
		detailrav.setRavitaillement(null);

		return detailrav;
	}

	public List<Facturerav> getFactureravs() {
		return this.factureravs;
	}

	public void setFactureravs(List<Facturerav> factureravs) {
		this.factureravs = factureravs;
	}

	public Facturerav addFacturerav(Facturerav facturerav) {
		getFactureravs().add(facturerav);
		facturerav.setRavitaillement(this);

		return facturerav;
	}

	public Facturerav removeFacturerav(Facturerav facturerav) {
		getFactureravs().remove(facturerav);
		facturerav.setRavitaillement(null);

		return facturerav;
	}

	public Boutique getBoutique() {
		return this.boutique;
	}

	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}

	public Commercant getCommercant() {
		return this.commercant;
	}

	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}

}