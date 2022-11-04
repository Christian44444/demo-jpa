package fr.diginamic;

import java.util.Calendar;
import java.util.Date;

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
		Regionj r1 = new Regionj();
		r1.setId(1);
		r1.setNom("Bretagne");
		// mise en persistence de la Région r1
		em.persist(r1);
		
		Regionj r2 = new Regionj();
		r2.setId(2);
		r2.setNom("Pays de la Loire");
		em.persist(r2);
		
		Villej v1 = new Villej();
		v1.setNom("Nantes");
		v1.setCodePostal("44000");
		Calendar cat = Calendar.getInstance();
		Date dr =  cat.getTime();
		v1.setDateDerRecencement(dr);
		v1.setCategorie(Categorie.GRANDE);
		v1.setRegion(r2);
		em.persist(v1);
		
		Villej v2 = new Villej();
		v2.setNom("Saint-Nazaire");
		v2.setCodePostal("44100");
		Calendar cat2 = Calendar.getInstance();
		Date dr2 =  cat2.getTime();
		v2.setDateDerRecencement(dr2);
		v2.setCategorie(Categorie.MOYENNE);
		v2.setRegion(r2);
		em.persist(v2);
		
		Habitantj h1 = new Habitantj();
		h1.setNom("DURAND");
		h1.setPrenom("Jean");
		h1.getVillejs().add(v1); // h1 est dans la ville v1
		h1.getVillejs().add(v2); // et dans la ville v2
		em.persist(h1);

		// Commit en base des 2 enregistrements
		trans.commit();
		
		// pour récupérer une région
		Regionj r3 = em.find(Regionj.class, 1);
		System.out.println(r3);
		
		
	}

}
