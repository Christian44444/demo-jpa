package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * Utilise demo-jpas/pom.xml, 
 * 		   demo-jpa/src/main/resources/META-INF/persistence.xml,
 * 		   la classe POJO Regions qui mappe la table regions de la BdD	 
 * @author cmich
 *
 */
public class ConnexionJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory eMF 
				= Persistence.createEntityManagerFactory("recensement");
		EntityManager em = eMF.createEntityManager();
		
		// objet transaction
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		// Création d'une Région
		Regions r1 = new Regions();
		r1.setiD(1);
		r1.setNom("Bretagne");
		// mise en persistence de la Région r1
		em.persist(r1);
		
		Regions r2 = new Regions();
		r2.setiD(2);
		r2.setNom("Pays de la Loire");
		em.persist(r2);
		// Commit en base des 2 enregistrements
		trans.commit();
		
		// pour récupérer une région
		Regions r3 = em.find(Regions.class, 1);
		System.out.println(r3);
		
		
	}

}
