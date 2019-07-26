package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the lignecommande database table.
 * 
 */
@Embeddable
public class LignecommandePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer idcommande;

	@Column(insertable=false, updatable=false)
	private Integer idproduit;

	public LignecommandePK() {
	}
	public Integer getIdcommande() {
		return this.idcommande;
	}
	public void setIdcommande(Integer idcommande) {
		this.idcommande = idcommande;
	}
	public Integer getIdproduit() {
		return this.idproduit;
	}
	public void setIdproduit(Integer idproduit) {
		this.idproduit = idproduit;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LignecommandePK)) {
			return false;
		}
		LignecommandePK castOther = (LignecommandePK)other;
		return 
			this.idcommande.equals(castOther.idcommande)
			&& this.idproduit.equals(castOther.idproduit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idcommande.hashCode();
		hash = hash * prime + this.idproduit.hashCode();
		
		return hash;
	}
}