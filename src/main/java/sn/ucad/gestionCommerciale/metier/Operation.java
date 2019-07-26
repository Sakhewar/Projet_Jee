package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operations database table.
 * 
 */
@Entity
@Table(name="operations")
@NamedQuery(name="Operation.findAll", query="SELECT o FROM Operation o")
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idoperations;

	private String typeoperation;

	//bi-directional many-to-one association to Boutiquier
	@ManyToOne
	@JoinColumn(name="idboutiquier")
	private Boutiquier boutiquier;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="idcompte")
	private Compte compte;

	public Operation() {
	}

	public Integer getIdoperations() {
		return this.idoperations;
	}

	public void setIdoperations(Integer idoperations) {
		this.idoperations = idoperations;
	}

	public String getTypeoperation() {
		return this.typeoperation;
	}

	public void setTypeoperation(String typeoperation) {
		this.typeoperation = typeoperation;
	}

	public Boutiquier getBoutiquier() {
		return this.boutiquier;
	}

	public void setBoutiquier(Boutiquier boutiquier) {
		this.boutiquier = boutiquier;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}