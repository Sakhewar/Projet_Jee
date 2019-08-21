package sn.ucad.gestionCommerciale.controller;


import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import sn.ucad.gestionCommerciale.metier.Categorie;
import sn.ucad.gestionCommerciale.metier.Conditionnement;
import sn.ucad.gestionCommerciale.metier.Format;
import sn.ucad.gestionCommerciale.metier.Marque;
import sn.ucad.gestionCommerciale.metier.Produit;
import sn.ucad.gestionCommerciale.service.CommercantService;
import sn.ucad.gestionCommerciale.utilitaire.JpaUtil;
import sn.ucad.gestionCommerciale.utilitaire.SpringUtil;

/**
 * @author Sakhewar
 *
 */


@ManagedBean
@SessionScoped
public class CommercantBean implements Serializable {
	
	/*
	 * Si les getbean ne marche pas
	 * 
    private Produit produit = new Produit() ; 
	
	private CommercantService commercantservice = new CommercantService() ;
	
/*	private Categorie categorie = new Categorie();
		
	private Format format = new Format() ;
	
	private Marque marque = new Marque() ; 
	
	private Conditionnement conditionnement = new Conditionnement() ; 
	
	*
	*
	*/


	private static final long serialVersionUID = 6213491104039114607L;
	
	
    private CommercantService commercantservice = (CommercantService) SpringUtil.getBean("commercantService") ; 
	
	private Produit produit =( Produit ) SpringUtil.getBean("produit") ; 
	
	private Produit selectedProduit = (Produit) SpringUtil.getBean("produit") ;

	private Categorie categorie = (Categorie) SpringUtil.getBean("categorie") ; 

	private Format format = (Format) SpringUtil.getBean("format") ; 

	private Marque marque = (Marque) SpringUtil.getBean("marque") ;
	
	private Conditionnement conditionnement = (Conditionnement) SpringUtil.getBean("conditionnement")  ;
	

	public CommercantService getCommercantservice() {
		return commercantservice;
	}

	public void setCommercantservice(CommercantService commercantservice) {
		this.commercantservice = commercantservice;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Conditionnement getConditionnement() {
		return conditionnement;
	}

	public void setConditionnement(Conditionnement conditionnement) {
		this.conditionnement = conditionnement;
	}

	public String save() {

		try {
			produit.setCategorieBean(categorie);
			produit.setFormatBean(format);
			produit.setConditionnementBean(conditionnement);
			produit.setMarqueBean(marque);
			commercantservice.save(produit) ; 			
			commercantservice.clear(produit) ;
			return "affichage" ;

		}catch(Exception es) {
			es.printStackTrace();
			System.out.println("Produit non inséré");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produit non inséré"));	

		}
		return "insertionproduit" ; 

	}
	

	public List<Produit> affiche() {
		return( commercantservice.affichage() );
	}
	
	public Object aff() {
		  return (commercantservice.aff() ) ; 
	}
	
	public String delete(Produit produit) {
		System.out.println("produit supprimé") ;
		return "insertionproduit" ; 
	}
	

	
	public void update(Produit produit) {
		commercantservice.update(produit);
	}
		
	
	public List<Categorie> categorie() {
		 //CommercantService commercantservice = (CommercantService) SpringUtil.getBean("commercantService") ;
		return( commercantservice.categorie() );

	}
	public List<Format> format() {
		// CommercantService commercantservice = (CommercantService) SpringUtil.getBean("commercantService") ;
		return( commercantservice.format() );

	}
	public List<Marque> marque() {
		// CommercantService commercantservice = (CommercantService) SpringUtil.getBean("commercantService") ;
		return( commercantservice.marque());

	}
	public List<Conditionnement> conditionnement() {
		// CommercantService commercantservice = (CommercantService) SpringUtil.getBean("commercantService") ;
		return( commercantservice.conditionnement());

	}

	public Produit getSelectedProduit() {
		return selectedProduit;
	}

	public void setSelectedProduit(Produit selectedProduit) {
		this.selectedProduit = selectedProduit;
	}
	

	
	
	


}
