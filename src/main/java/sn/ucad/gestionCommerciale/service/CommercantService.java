package sn.ucad.gestionCommerciale.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sn.ucad.gestionCommerciale.dao.CommercantDao;
import sn.ucad.gestionCommerciale.metier.Categorie;
import sn.ucad.gestionCommerciale.metier.Conditionnement;
import sn.ucad.gestionCommerciale.metier.Format;
import sn.ucad.gestionCommerciale.metier.Marque;
import sn.ucad.gestionCommerciale.metier.Produit;
import sn.ucad.gestionCommerciale.utilitaire.SpringUtil;

public class CommercantService implements Serializable {
	

	
	private static final long serialVersionUID = 7298869828367357248L;
	//private CommercantDao commercantdao= (CommercantDao) SpringUtil.getBean("commercantDao") ; 
    private CommercantDao commercantdao = new CommercantDao() ; 

		
	/* Redéfinition des méthodes de produit */
	
	public void save(Produit P) {
		System.out.println("methode ajouter appele") ; 
		commercantdao.save(P);	
	}
	public List<Produit> affichage() {
		System.out.println("methode affichage appele") ; 
		return ( commercantdao.produitList() ); 
	}
	
	public Object aff() {
		System.out.println("methode affichage appele") ; 
		return ( commercantdao.Listp() ); 
	}
	
	public void update(Produit produit) {
		commercantdao.update(produit);
		
	}
	
	public void clear(Produit produit) {
		commercantdao.clear(produit);
	}
	
	 public void delete (Produit produit) {
		 System.out.println("methode supprimer appele") ;
		 commercantdao.delete(produit);
	 }
	 


	 
	 
	 /* Fin de la redéfinition des méthodes de produit */
	
	
	public List<Categorie> categorie() {
		System.out.println("methode categorie appele") ; 
		return ( commercantdao.categorieList()); 
	}

	 
	 public List<Format> format(){
		 System.out.println("methode format appele") ; 
		return ( commercantdao.formatList() ); 
		 
	 }
	 public List<Marque> marque(){
	
		 System.out.println("methode marque appele") ; 
		return ( commercantdao.marqueList()); 
		 
	 }
	 public List<Conditionnement> conditionnement(){
	
		 System.out.println("methode conditionnement appele") ; 
		return ( commercantdao.conditionnementList()); 
		 
	 }

	 

}
