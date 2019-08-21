package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idutilisateur;

	private String adresse;

	private String email;

	private String login;

	private String mdp;

	private String nom;

	private String prenom;

	private String profil;

	private Integer telephone;

	//bi-directional one-to-one association to Administrateur
	@OneToOne(mappedBy="utilisateur")
	private Administrateur administrateur;

	//bi-directional one-to-one association to Boutiquier
	@OneToOne(mappedBy="utilisateur")
	private Boutiquier boutiquier;

	//bi-directional one-to-one association to Client
	@OneToOne(mappedBy="utilisateur")
	private Client client;

	//bi-directional one-to-one association to Commercant
	@OneToOne(mappedBy="utilisateur")
	private Commercant commercant;

	public Utilisateur() {
	}

	public Integer getIdutilisateur() {
		return this.idutilisateur;
	}

	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getProfil() {
		return this.profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public Integer getTelephone() {
		return this.telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public Administrateur getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public Boutiquier getBoutiquier() {
		return this.boutiquier;
	}

	public void setBoutiquier(Boutiquier boutiquier) {
		this.boutiquier = boutiquier;
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

}