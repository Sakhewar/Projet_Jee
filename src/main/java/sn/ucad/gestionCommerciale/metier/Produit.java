package sn.ucad.gestionCommerciale.metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idproduit;

	private String description;

	private String libelle;

	private double prixachat;

	private double prixu;

	private Integer quantiteprod;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="produit", fetch=FetchType.EAGER)
	private List<Image> images;

	//bi-directional many-to-one association to Lignecommande
	@OneToMany(mappedBy="produit", fetch=FetchType.EAGER)
	private List<Lignecommande> lignecommandes;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="categorie")
	private Categorie categorieBean;

	//bi-directional many-to-one association to Conditionnement
	@ManyToOne
	@JoinColumn(name="conditionnement")
	private Conditionnement conditionnementBean;

	//bi-directional many-to-one association to Format
	@ManyToOne
	@JoinColumn(name="format")
	private Format formatBean;

	//bi-directional many-to-one association to Marque
	@ManyToOne
	@JoinColumn(name="marque")
	private Marque marqueBean;

	public Produit() {
	}

	public Integer getIdproduit() {
		return this.idproduit;
	}

	public void setIdproduit(Integer idproduit) {
		this.idproduit = idproduit;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrixachat() {
		return this.prixachat;
	}

	public void setPrixachat(double prixachat) {
		this.prixachat = prixachat;
	}

	public double getPrixu() {
		return this.prixu;
	}

	public void setPrixu(double prixu) {
		this.prixu = prixu;
	}

	public Integer getQuantiteprod() {
		return this.quantiteprod;
	}

	public void setQuantiteprod(Integer quantiteprod) {
		this.quantiteprod = quantiteprod;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setProduit(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setProduit(null);

		return image;
	}

	public List<Lignecommande> getLignecommandes() {
		return this.lignecommandes;
	}

	public void setLignecommandes(List<Lignecommande> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}

	public Lignecommande addLignecommande(Lignecommande lignecommande) {
		getLignecommandes().add(lignecommande);
		lignecommande.setProduit(this);

		return lignecommande;
	}

	public Lignecommande removeLignecommande(Lignecommande lignecommande) {
		getLignecommandes().remove(lignecommande);
		lignecommande.setProduit(null);

		return lignecommande;
	}

	public Categorie getCategorieBean() {
		return this.categorieBean;
	}

	public void setCategorieBean(Categorie categorieBean) {
		this.categorieBean = categorieBean;
	}

	public Conditionnement getConditionnementBean() {
		return this.conditionnementBean;
	}

	public void setConditionnementBean(Conditionnement conditionnementBean) {
		this.conditionnementBean = conditionnementBean;
	}

	public Format getFormatBean() {
		return this.formatBean;
	}

	public void setFormatBean(Format formatBean) {
		this.formatBean = formatBean;
	}

	public Marque getMarqueBean() {
		return this.marqueBean;
	}

	public void setMarqueBean(Marque marqueBean) {
		this.marqueBean = marqueBean;
	}

}