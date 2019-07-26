package sn.ucad.gestionCommerciale.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import sn.ucad.gestionCommerciale.metier.*;
import sn.ucad.gestionCommerciale.utilitaire.JpaUtil;
import sn.ucad.gestionCommerciale.utilitaire.SpringUtil;

public class CommercantDao {

	EntityManager em =  JpaUtil.getEntityManager() ; 
	
	/* Début des méthodes de produit CRUD DE PRODUIT */
		
	public void save (Produit P) {
		EntityManager em =  JpaUtil.getEntityManager() ; 
		EntityTransaction t = em.getTransaction() ;

		System.out.println("transaction obtenue") ;
		t.begin();
		System.out.println("transaction crée") ;  
		P = em.merge(P) ; 
		em.persist(P);
		System.out.println("produit insere") ;
		t.commit();
		System.out.println("transaction commit") ; 
		em.close();


	}

	public void update(Produit produit) {
		EntityManager entitymanager =  JpaUtil.getEntityManager() ; 

		EntityTransaction te = entitymanager.getTransaction();
		te.begin();
		entitymanager.merge(produit);
		te.commit();
		entitymanager.close();	
	}

	@SuppressWarnings("unchecked")
	public List<Produit> produitList(){ 
		EntityManager em =  JpaUtil.getEntityManager() ; 
		
		Query queryObj = em.createQuery("SELECT u FROM Produit u ORDER BY (idproduit) DESC" , Produit.class);
		@SuppressWarnings("rawtypes")
		List utilisateurList = queryObj.getResultList();
		if (utilisateurList != null && utilisateurList.size() > 0) { 
			em.close();
			return utilisateurList;
			
		} else {
			return null;
		}
		
	}
	
	/*public void delete(Produit produit) {
		EntityManager em =  JpaUtil.getEntityManager() ; 
		EntityTransaction te = em.getTransaction();
		te.begin();
		produit = em.merge(produit) ; 
		em.remove(produit);
		te.commit();
        em.close();
	}*/
	
	public void clear(Produit produit) {
		 
		/*Categorie categorie = new Categorie() ; 
		Format format = new Format() ; 
		Marque marque = new Marque() ; 
		Conditionnement conditionnement = new Conditionnement() ; */
		Categorie categorie= (Categorie) SpringUtil.getBean("categorie") ; 
		Format format= (Format) SpringUtil.getBean("format") ;
		Marque marque= (Marque) SpringUtil.getBean("marque") ; 
		Conditionnement conditionnement= (Conditionnement) SpringUtil.getBean("conditionnement") ;
		produit.setLibelle(null);
		categorie.setIdcategorie(null);
		produit.setCategorieBean(categorie);
		format.setIdformat(null);
		produit.setFormatBean(format);
		marque.setIdmarque(null);
		produit.setMarqueBean(marque);
		conditionnement.setIdconditionnement(null);
		produit.setConditionnementBean(conditionnement);
		produit.setDescription(null);
		produit.setPrixu(0.0);
		produit.setPrixachat(0.0);
		produit.setQuantiteprod(null);
		
	}
	

	
	
	/*  Fin des méthodes de produit */
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Categorie> categorieList(){ 
		Query queryObj = em.createQuery("SELECT u FROM Categorie u ORDER BY (idcategorie) desc" , Categorie.class);
        @SuppressWarnings("rawtypes")
		List utilisateurList = queryObj.getResultList();
        if (utilisateurList != null && utilisateurList.size() > 0) {           
            return utilisateurList;
        } else {
            return null;
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Format> formatList(){ 
		Query queryObj = em.createQuery("SELECT u FROM Format u ORDER BY(u.idformat) desc" , Format.class);
        @SuppressWarnings("rawtypes")
		List utilisateurList = queryObj.getResultList();
        if (utilisateurList != null && utilisateurList.size() > 0) {           
            return utilisateurList;
        } else {
            return null;
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Marque> marqueList(){ 
		Query queryObj = em.createQuery("SELECT u FROM Marque u ORDER BY (idmarque) desc" , Marque.class);
        @SuppressWarnings("rawtypes")
		List utilisateurList = queryObj.getResultList();
        if (utilisateurList != null && utilisateurList.size() > 0) {           
            return utilisateurList;
        } else {
            return null;
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Conditionnement> conditionnementList(){ 
		Query queryObj = em.createQuery("SELECT u FROM Conditionnement u ORDER BY (u.idconditionnement) desc" , Conditionnement.class);
        @SuppressWarnings("rawtypes")
		List utilisateurList = queryObj.getResultList();
        if (utilisateurList != null && utilisateurList.size() > 0) {           
            return utilisateurList;
        } else {
            return null;
        }
	}
	
	

	


}
