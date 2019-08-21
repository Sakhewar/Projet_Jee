package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcompte;

	private double decouverte;

	private String numerocompte;

	private double solde;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client;

	//bi-directional many-to-one association to Commercant
	@ManyToOne
	@JoinColumn(name="idcommercant")
	private Commercant commercant;

	//bi-directional many-to-one association to Operation
	@OneToMany(mappedBy="compte", fetch=FetchType.EAGER)
	private List<Operation> operations;

	public Compte() {
	}

	public Integer getIdcompte() {
		return this.idcompte;
	}

	public void setIdcompte(Integer idcompte) {
		this.idcompte = idcompte;
	}

	public double getDecouverte() {
		return this.decouverte;
	}

	public void setDecouverte(double decouverte) {
		this.decouverte = decouverte;
	}

	public String getNumerocompte() {
		return this.numerocompte;
	}

	public void setNumerocompte(String numerocompte) {
		this.numerocompte = numerocompte;
	}

	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Commercant getCommercant() {
		return this.commercant;
	}

	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}

	public List<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Operation addOperation(Operation operation) {
		getOperations().add(operation);
		operation.setCompte(this);

		return operation;
	}

	public Operation removeOperation(Operation operation) {
		getOperations().remove(operation);
		operation.setCompte(null);

		return operation;
	}

}