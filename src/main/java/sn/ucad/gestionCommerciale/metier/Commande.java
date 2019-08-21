package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcommande;

	private String adresselivraison;

	private Timestamp datecommande;

	private String etatcommande;

	private String modelivraison;

	private double prixtotal;

	private Integer totalproduit;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client;

	//bi-directional many-to-one association to Facturecommande
	@OneToMany(mappedBy="commande", fetch=FetchType.EAGER)
	private List<Facturecommande> facturecommandes;

	//bi-directional many-to-one association to Lignecommande
	@OneToMany(mappedBy="commande", fetch=FetchType.EAGER)
	private List<Lignecommande> lignecommandes;

	public Commande() {
	}

	public Integer getIdcommande() {
		return this.idcommande;
	}

	public void setIdcommande(Integer idcommande) {
		this.idcommande = idcommande;
	}

	public String getAdresselivraison() {
		return this.adresselivraison;
	}

	public void setAdresselivraison(String adresselivraison) {
		this.adresselivraison = adresselivraison;
	}

	public Timestamp getDatecommande() {
		return this.datecommande;
	}

	public void setDatecommande(Timestamp datecommande) {
		this.datecommande = datecommande;
	}

	public String getEtatcommande() {
		return this.etatcommande;
	}

	public void setEtatcommande(String etatcommande) {
		this.etatcommande = etatcommande;
	}

	public String getModelivraison() {
		return this.modelivraison;
	}

	public void setModelivraison(String modelivraison) {
		this.modelivraison = modelivraison;
	}

	public double getPrixtotal() {
		return this.prixtotal;
	}

	public void setPrixtotal(double prixtotal) {
		this.prixtotal = prixtotal;
	}

	public Integer getTotalproduit() {
		return this.totalproduit;
	}

	public void setTotalproduit(Integer totalproduit) {
		this.totalproduit = totalproduit;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Facturecommande> getFacturecommandes() {
		return this.facturecommandes;
	}

	public void setFacturecommandes(List<Facturecommande> facturecommandes) {
		this.facturecommandes = facturecommandes;
	}

	public Facturecommande addFacturecommande(Facturecommande facturecommande) {
		getFacturecommandes().add(facturecommande);
		facturecommande.setCommande(this);

		return facturecommande;
	}

	public Facturecommande removeFacturecommande(Facturecommande facturecommande) {
		getFacturecommandes().remove(facturecommande);
		facturecommande.setCommande(null);

		return facturecommande;
	}

	public List<Lignecommande> getLignecommandes() {
		return this.lignecommandes;
	}

	public void setLignecommandes(List<Lignecommande> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}

	public Lignecommande addLignecommande(Lignecommande lignecommande) {
		getLignecommandes().add(lignecommande);
		lignecommande.setCommande(this);

		return lignecommande;
	}

	public Lignecommande removeLignecommande(Lignecommande lignecommande) {
		getLignecommandes().remove(lignecommande);
		lignecommande.setCommande(null);

		return lignecommande;
	}

}