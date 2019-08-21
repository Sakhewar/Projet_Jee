package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idclient;

	private String adresselivraisondefaut;

	private String numero;

	//bi-directional many-to-one association to Commercant
	@ManyToOne
	@JoinColumn(name="idcommercant")
	private Commercant commercant;

	//bi-directional one-to-one association to Utilisateur
	@OneToOne
	@JoinColumn(name="idclient")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="client", fetch=FetchType.EAGER)
	private List<Commande> commandes;

	//bi-directional many-to-one association to Compte
	@OneToMany(mappedBy="client", fetch=FetchType.EAGER)
	private List<Compte> comptes;

	public Client() {
	}

	public Integer getIdclient() {
		return this.idclient;
	}

	public void setIdclient(Integer idclient) {
		this.idclient = idclient;
	}

	public String getAdresselivraisondefaut() {
		return this.adresselivraisondefaut;
	}

	public void setAdresselivraisondefaut(String adresselivraisondefaut) {
		this.adresselivraisondefaut = adresselivraisondefaut;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setClient(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setClient(null);

		return commande;
	}

	public List<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Compte addCompte(Compte compte) {
		getComptes().add(compte);
		compte.setClient(this);

		return compte;
	}

	public Compte removeCompte(Compte compte) {
		getComptes().remove(compte);
		compte.setClient(null);

		return compte;
	}

}