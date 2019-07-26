package sn.ucad.gestionCommerciale.utilitaire;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final String PERSISTENCE_UNIT_NAME = "persistence-unit";
	private static EntityManagerFactory factory;

	static {

		try {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
	
    public static EntityManager getEntityManager(){
        return getEntityManagerFactory().createEntityManager();
    }

}

