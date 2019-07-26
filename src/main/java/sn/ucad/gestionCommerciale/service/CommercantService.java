package sn.ucad.gestionCommerciale.service;

import java.util.List;
import sn.ucad.gestionCommerciale.dao.CommercantDao;
import sn.ucad.gestionCommerciale.metier.Categorie;
import sn.ucad.gestionCommerciale.metier.Conditionnement;
import sn.ucad.gestionCommerciale.metier.Format;
import sn.ucad.gestionCommerciale.metier.Marque;
import sn.ucad.gestionCommerciale.metier.Produit;
import sn.ucad.gestionCommerciale.utilitaire.SpringUtil;

public class CommercantService {
	

    private CommercantDao commercantdao = new CommercantDao() ; 
	
	//private CommercantDao commercantdao = (CommercantDao) SpringUtil.getBean("commercanDao") ; 

		
	/* Redéfinition des méthodes de produit */
	
	public void save(Produit P) {
		//CommercantDao commercantdao = (CommercantDao) SpringUtil.getBean("CommercantDao") ;
		System.out.println("methode ajouter appele") ; 
		commercantdao.save(P);	
	}
	public List<Produit> affichage() {
		//CommercantDao commercantdao = (CommercantDao) SpringUtil.getBean("CommercantDao") ;
		System.out.println("methode affichage appele") ; 
		return ( commercantdao.produitList() ); 
	}
	
	public void update(Produit produit) {
		//CommercantDao commercantdao = (CommercantDao) SpringUtil.getBean("CommercantDao") ;
		commercantdao.update(produit);
		
	}
	
	public void clear(Produit produit) {
		commercantdao.clear(produit);
	}
	
	 /*public void delete (Produit produit) {
		 //CommercantDao commercantdao = (CommercantDao) SpringUtil.getBean("CommercantDao") ;
		 System.out.println("methode supprimer appele") ;
		 commercantdao.delete(produit);
	 }*/
	 


	 
	 
	 /* Fin de la redéfinition des méthodes de produit */
	
	
	public List<Categorie> categorie() {
		//CommercantDao commercantdao = (CommercantDao) SpringUtil.getBean("CommercantDao") ;
		System.out.println("methode categorie appele") ; 
		return ( commercantdao.categorieList()); 
	}

	 
	 public List<Format> format(){
		// CommercantDao commercantdao = (CommercantDao) SpringUtil.getBean("CommercantDao") ;
		 System.out.println("methode format appele") ; 
		return ( commercantdao.formatList() ); 
		 
	 }
	 public List<Marque> marque(){
		// CommercantDao commercantdao = (CommercantDao) SpringUtil.getBean("CommercantDao") ;
		 System.out.println("methode marque appele") ; 
		return ( commercantdao.marqueList()); 
		 
	 }
	 public List<Conditionnement> conditionnement(){
		// CommercantDao commercantdao = (CommercantDao) SpringUtil.getBean("CommercantDao") ;
		 System.out.println("methode conditionnement appele") ; 
		return ( commercantdao.conditionnementList()); 
		 
	 }

	 

}
