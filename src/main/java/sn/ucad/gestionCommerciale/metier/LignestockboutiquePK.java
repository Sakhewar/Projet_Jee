package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the lignestockboutique database table.
 * 
 */
@Embeddable
public class LignestockboutiquePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer idstockboutique;

	@Column(insertable=false, updatable=false)
	private Integer idproduit;

	public LignestockboutiquePK() {
	}
	public Integer getIdstockboutique() {
		return this.idstockboutique;
	}
	public void setIdstockboutique(Integer idstockboutique) {
		this.idstockboutique = idstockboutique;
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
		if (!(other instanceof LignestockboutiquePK)) {
			return false;
		}
		LignestockboutiquePK castOther = (LignestockboutiquePK)other;
		return 
			this.idstockboutique.equals(castOther.idstockboutique)
			&& this.idproduit.equals(castOther.idproduit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idstockboutique.hashCode();
		hash = hash * prime + this.idproduit.hashCode();
		
		return hash;
	}
}