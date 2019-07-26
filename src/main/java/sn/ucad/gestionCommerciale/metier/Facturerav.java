package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the facturerav database table.
 * 
 */
@Entity
@NamedQuery(name="Facturerav.findAll", query="SELECT f FROM Facturerav f")
public class Facturerav implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idfacturerav;

	//bi-directional many-to-one association to Ravitaillement
	@ManyToOne
	@JoinColumn(name="idravitaillement")
	private Ravitaillement ravitaillement;

	public Facturerav() {
	}

	public Integer getIdfacturerav() {
		return this.idfacturerav;
	}

	public void setIdfacturerav(Integer idfacturerav) {
		this.idfacturerav = idfacturerav;
	}

	public Ravitaillement getRavitaillement() {
		return this.ravitaillement;
	}

	public void setRavitaillement(Ravitaillement ravitaillement) {
		this.ravitaillement = ravitaillement;
	}

}