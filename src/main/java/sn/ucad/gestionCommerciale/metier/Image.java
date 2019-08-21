package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idimage;

	private String url;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="idproduit")
	private Produit produit;

	public Image() {
	}

	public Integer getIdimage() {
		return this.idimage;
	}

	public void setIdimage(Integer idimage) {
		this.idimage = idimage;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}