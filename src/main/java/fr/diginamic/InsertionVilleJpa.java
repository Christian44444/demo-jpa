package fr.diginamic;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Class de test d'insertion de Villej
 * @author cmich
 *
 */
public class InsertionVilleJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("recensement");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction trans = eM.getTransaction();
// Videz les tables avant => persistence.xml		
		trans.begin();
		
		Villej v1 = new Villej();
		v1.setNom("Nantes");
		v1.setCodePostal("44000");
		Calendar cat = Calendar.getInstance();
		Date dr =  cat.getTime();
		v1.setDateDerRecencement(dr);
		v1.setCategorie(Categorie.GRANDE);
		eM.persist(v1);
		
		Villej v2 = new Villej();
		v2.setNom("Saint-Nazaire");
		v2.setCodePostal("44100");
		Calendar cat2 = Calendar.getInstance();
		Date dr2 =  cat2.getTime();
		v2.setDateDerRecencement(dr2);
		v2.setCategorie(Categorie.MOYENNE);
		eM.persist(v2);
		
		Adresse a1 = new Adresse();
		a1.setNumero(12);
		a1.setRue("rue du Daguenet");
		a1.setVille("Angers");
		// Les champs non connus doivent être créés dans la table de la base : ALTER TABLE Habitants ADD COLUMN rue varchar(50);
		// Comme ça cela fonctionne et ce sont bien les champs de la classe Adresse qui sont ajoutés et non l'objet Ardesse lui même
		Habitantj h1 = new Habitantj();
		h1.setNom("MARCO");
		h1.setPrenom("Polo");
		h1.setAdresse(a1);
		eM.persist(h1);
		
		trans.commit();
	}
}
