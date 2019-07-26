package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stockboutique database table.
 * 
 */
@Entity
@NamedQuery(name="Stockboutique.findAll", query="SELECT s FROM Stockboutique s")
public class Stockboutique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idstockboutique;

	private String etatstock;

	private double prixtotal;

	private Integer quantitestocktotal;

	//bi-directional many-to-one association to Lignestockboutique
	@OneToMany(mappedBy="stockboutique", fetch=FetchType.EAGER)
	private List<Lignestockboutique> lignestockboutiques;

	//bi-directional many-to-one association to Boutique
	@ManyToOne
	@JoinColumn(name="idboutique")
	private Boutique boutique;

	public Stockboutique() {
	}

	public Integer getIdstockboutique() {
		return this.idstockboutique;
	}

	public void setIdstockboutique(Integer idstockboutique) {
		this.idstockboutique = idstockboutique;
	}

	public String getEtatstock() {
		return this.etatstock;
	}

	public void setEtatstock(String etatstock) {
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

	public List<Lignestockboutique> getLignestockboutiques() {
		return this.lignestockboutiques;
	}

	public void setLignestockboutiques(List<Lignestockboutique> lignestockboutiques) {
		this.lignestockboutiques = lignestockboutiques;
	}

	public Lignestockboutique addLignestockboutique(Lignestockboutique lignestockboutique) {
		getLignestockboutiques().add(lignestockboutique);
		lignestockboutique.setStockboutique(this);

		return lignestockboutique;
	}

	public Lignestockboutique removeLignestockboutique(Lignestockboutique lignestockboutique) {
		getLignestockboutiques().remove(lignestockboutique);
		lignestockboutique.setStockboutique(null);

		return lignestockboutique;
	}

	public Boutique getBoutique() {
		return this.boutique;
	}

	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}

}