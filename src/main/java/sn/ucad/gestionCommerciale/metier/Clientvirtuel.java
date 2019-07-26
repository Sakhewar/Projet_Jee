package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clientvirtuel database table.
 * 
 */
@Entity
@NamedQuery(name="Clientvirtuel.findAll", query="SELECT c FROM Clientvirtuel c")
public class Clientvirtuel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idclientvirtuel;

	//bi-directional many-to-one association to Commercant
	@ManyToOne
	@JoinColumn(name="idcommercant")
	private Commercant commercant;

	public Clientvirtuel() {
	}

	public Integer getIdclientvirtuel() {
		return this.idclientvirtuel;
	}

	public void setIdclientvirtuel(Integer idclientvirtuel) {
		this.idclientvirtuel = idclientvirtuel;
	}

	public Commercant getCommercant() {
		return this.commercant;
	}

	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}

}