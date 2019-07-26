package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detailrav database table.
 * 
 */
@Embeddable
public class DetailravPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer idravitaillement;

	@Column(insertable=false, updatable=false)
	private Integer idproduit;

	public DetailravPK() {
	}
	public Integer getIdravitaillement() {
		return this.idravitaillement;
	}
	public void setIdravitaillement(Integer idravitaillement) {
		this.idravitaillement = idravitaillement;
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
		if (!(other instanceof DetailravPK)) {
			return false;
		}
		DetailravPK castOther = (DetailravPK)other;
		return 
			this.idravitaillement.equals(castOther.idravitaillement)
			&& this.idproduit.equals(castOther.idproduit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idravitaillement.hashCode();
		hash = hash * prime + this.idproduit.hashCode();
		
		return hash;
	}
}