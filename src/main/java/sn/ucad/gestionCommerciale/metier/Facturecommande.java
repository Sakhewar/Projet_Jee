package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the facturecommande database table.
 * 
 */
@Entity
@NamedQuery(name="Facturecommande.findAll", query="SELECT f FROM Facturecommande f")
public class Facturecommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idfacture;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="idcommande")
	private Commande commande;

	public Facturecommande() {
	}

	public Integer getIdfacture() {
		return this.idfacture;
	}

	public void setIdfacture(Integer idfacture) {
		this.idfacture = idfacture;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}