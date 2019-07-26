package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the commercant database table.
 * 
 */
@Entity
@NamedQuery(name="Commercant.findAll", query="SELECT c FROM Commercant c")
public class Commercant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idcommercant;

	//bi-directional many-to-one association to Boutique
	@OneToMany(mappedBy="commercant", fetch=FetchType.EAGER)
	private List<Boutique> boutiques;

	//bi-directional many-to-one association to Boutiquier
	@OneToMany(mappedBy="commercant", fetch=FetchType.EAGER)
	private List<Boutiquier> boutiquiers;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="commercant", fetch=FetchType.EAGER)
	private List<Client> clients;

	//bi-directional many-to-one association to Clientvirtuel
	@OneToMany(mappedBy="commercant", fetch=FetchType.EAGER)
	private List<Clientvirtuel> clientvirtuels;

	//bi-directional one-to-one association to Utilisateur
	@OneToOne
	@JoinColumn(name="idcommercant")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Compte
	@OneToMany(mappedBy="commercant", fetch=FetchType.EAGER)
	private List<Compte> comptes;

	//bi-directional many-to-one association to Ravitaillement
	@OneToMany(mappedBy="commercant", fetch=FetchType.EAGER)
	private List<Ravitaillement> ravitaillements;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="commercant", fetch=FetchType.EAGER)
	private List<Stock> stocks;

	public Commercant() {
	}

	public Integer getIdcommercant() {
		return this.idcommercant;
	}

	public void setIdcommercant(Integer idcommercant) {
		this.idcommercant = idcommercant;
	}

	public List<Boutique> getBoutiques() {
		return this.boutiques;
	}

	public void setBoutiques(List<Boutique> boutiques) {
		this.boutiques = boutiques;
	}

	public Boutique addBoutique(Boutique boutique) {
		getBoutiques().add(boutique);
		boutique.setCommercant(this);

		return boutique;
	}

	public Boutique removeBoutique(Boutique boutique) {
		getBoutiques().remove(boutique);
		boutique.setCommercant(null);

		return boutique;
	}

	public List<Boutiquier> getBoutiquiers() {
		return this.boutiquiers;
	}

	public void setBoutiquiers(List<Boutiquier> boutiquiers) {
		this.boutiquiers = boutiquiers;
	}

	public Boutiquier addBoutiquier(Boutiquier boutiquier) {
		getBoutiquiers().add(boutiquier);
		boutiquier.setCommercant(this);

		return boutiquier;
	}

	public Boutiquier removeBoutiquier(Boutiquier boutiquier) {
		getBoutiquiers().remove(boutiquier);
		boutiquier.setCommercant(null);

		return boutiquier;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setCommercant(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setCommercant(null);

		return client;
	}

	public List<Clientvirtuel> getClientvirtuels() {
		return this.clientvirtuels;
	}

	public void setClientvirtuels(List<Clientvirtuel> clientvirtuels) {
		this.clientvirtuels = clientvirtuels;
	}

	public Clientvirtuel addClientvirtuel(Clientvirtuel clientvirtuel) {
		getClientvirtuels().add(clientvirtuel);
		clientvirtuel.setCommercant(this);

		return clientvirtuel;
	}

	public Clientvirtuel removeClientvirtuel(Clientvirtuel clientvirtuel) {
		getClientvirtuels().remove(clientvirtuel);
		clientvirtuel.setCommercant(null);

		return clientvirtuel;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Compte addCompte(Compte compte) {
		getComptes().add(compte);
		compte.setCommercant(this);

		return compte;
	}

	public Compte removeCompte(Compte compte) {
		getComptes().remove(compte);
		compte.setCommercant(null);

		return compte;
	}

	public List<Ravitaillement> getRavitaillements() {
		return this.ravitaillements;
	}

	public void setRavitaillements(List<Ravitaillement> ravitaillements) {
		this.ravitaillements = ravitaillements;
	}

	public Ravitaillement addRavitaillement(Ravitaillement ravitaillement) {
		getRavitaillements().add(ravitaillement);
		ravitaillement.setCommercant(this);

		return ravitaillement;
	}

	public Ravitaillement removeRavitaillement(Ravitaillement ravitaillement) {
		getRavitaillements().remove(ravitaillement);
		ravitaillement.setCommercant(null);

		return ravitaillement;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setCommercant(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setCommercant(null);

		return stock;
	}

}