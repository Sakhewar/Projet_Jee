package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the boutiquier database table.
 * 
 */
@Entity
@NamedQuery(name="Boutiquier.findAll", query="SELECT b FROM Boutiquier b")
public class Boutiquier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idboutiquier;

	private Integer idlocalisation;

	private String numero;

	//bi-directional many-to-one association to Boutique
	@OneToMany(mappedBy="boutiquier", fetch=FetchType.EAGER)
	private List<Boutique> boutiques;

	//bi-directional many-to-one association to Commercant
	@ManyToOne
	@JoinColumn(name="idcommercant")
	private Commercant commercant;

	//bi-directional one-to-one association to Utilisateur
	@OneToOne
	@JoinColumn(name="idboutiquier")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Operation
	@OneToMany(mappedBy="boutiquier", fetch=FetchType.EAGER)
	private List<Operation> operations;

	public Boutiquier() {
	}

	public Integer getIdboutiquier() {
		return this.idboutiquier;
	}

	public void setIdboutiquier(Integer idboutiquier) {
		this.idboutiquier = idboutiquier;
	}

	public Integer getIdlocalisation() {
		return this.idlocalisation;
	}

	public void setIdlocalisation(Integer idlocalisation) {
		this.idlocalisation = idlocalisation;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Boutique> getBoutiques() {
		return this.boutiques;
	}

	public void setBoutiques(List<Boutique> boutiques) {
		this.boutiques = boutiques;
	}

	public Boutique addBoutique(Boutique boutique) {
		getBoutiques().add(boutique);
		boutique.setBoutiquier(this);

		return boutique;
	}

	public Boutique removeBoutique(Boutique boutique) {
		getBoutiques().remove(boutique);
		boutique.setBoutiquier(null);

		return boutique;
	}

	public Commercant getCommercant() {
		return this.commercant;
	}

	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Operation addOperation(Operation operation) {
		getOperations().add(operation);
		operation.setBoutiquier(this);

		return operation;
	}

	public Operation removeOperation(Operation operation) {
		getOperations().remove(operation);
		operation.setBoutiquier(null);

		return operation;
	}

}