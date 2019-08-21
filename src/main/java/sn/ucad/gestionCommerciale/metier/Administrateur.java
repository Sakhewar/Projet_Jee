package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the administrateur database table.
 * 
 */
@Entity
@NamedQuery(name="Administrateur.findAll", query="SELECT a FROM Administrateur a")
public class Administrateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idadministrateur;

	//bi-directional one-to-one association to Utilisateur
	@OneToOne
	@JoinColumn(name="idadministrateur")
	private Utilisateur utilisateur;

	public Administrateur() {
	}

	public Integer getIdadministrateur() {
		return this.idadministrateur;
	}

	public void setIdadministrateur(Integer idadministrateur) {
		this.idadministrateur = idadministrateur;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}