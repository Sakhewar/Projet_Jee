package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the lignestock database table.
 * 
 */
@Embeddable
public class LignestockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer idstock;

	@Column(insertable=false, updatable=false)
	private Integer idproduit;

	public LignestockPK() {
	}
	public Integer getIdstock() {
		return this.idstock;
	}
	public void setIdstock(Integer idstock) {
		this.idstock = idstock;
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
		if (!(other instanceof LignestockPK)) {
			return false;
		}
		LignestockPK castOther = (LignestockPK)other;
		return 
			this.idstock.equals(castOther.idstock)
			&& this.idproduit.equals(castOther.idproduit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idstock.hashCode();
		hash = hash * prime + this.idproduit.hashCode();
		
		return hash;
	}
}