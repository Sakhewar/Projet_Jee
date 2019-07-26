package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idstock;

	private Boolean etatstock;

	private double prixtotal;

	private Integer quantitestocktotal;

	//bi-directional many-to-one association to Lignestock
	@OneToMany(mappedBy="stock", fetch=FetchType.EAGER)
	private List<Lignestock> lignestocks;

	//bi-directional many-to-one association to Commercant
	@ManyToOne
	@JoinColumn(name="idcommercant")
	private Commercant commercant;

	public Stock() {
	}

	public Integer getIdstock() {
		return this.idstock;
	}

	public void setIdstock(Integer idstock) {
		this.idstock = idstock;
	}

	public Boolean getEtatstock() {
		return this.etatstock;
	}

	public void setEtatstock(Boolean etatstock) {
		this.etatstock = etatstock;
	}

	public double getPrixtotal() {
		return this.prixtotal;
	}

	public void setPrixtotal(double prixtotal) {
		this.prixtotal = prixtotal;
	}

	public Integer getQuantitestocktotal() {
		return this.quantitestocktotal;
	}

	public void setQuantitestocktotal(Integer quantitestocktotal) {
		this.quantitestocktotal = quantitestocktotal;
	}

	public List<Lignestock> getLignestocks() {
		return this.lignestocks;
	}

	public void setLignestocks(List<Lignestock> lignestocks) {
		this.lignestocks = lignestocks;
	}

	public Lignestock addLignestock(Lignestock lignestock) {
		getLignestocks().add(lignestock);
		lignestock.setStock(this);

		return lignestock;
	}

	public Lignestock removeLignestock(Lignestock lignestock) {
		getLignestocks().remove(lignestock);
		lignestock.setStock(null);

		return lignestock;
	}

	public Commercant getCommercant() {
		return this.commercant;
	}

	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}

}