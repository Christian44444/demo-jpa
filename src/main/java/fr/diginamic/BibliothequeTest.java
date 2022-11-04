package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * Classe pour tester le TP02 et TP03
 * En fin de classe il y a le script de génération des données 
 * @author cmich
 *
 */
public class BibliothequeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("recensement");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction trans = eM.getTransaction();
		System.out.println(eM.find(Livre.class, 1));
		System.out.println(eM.find(Emprunt.class,1));
		
		// raz du mapping de ce qui suit
		trans.begin();
		// remove du livre dans l'emprunt 1 et du livre mais ne gère pas la compo
		Emprunt esuplivre1 = eM.find(Emprunt.class, 1);
		for (int i = 0; i < esuplivre1.getLivres().size(); i++) {
			Livre l_encours = esuplivre1.getLivres().get(i);
			if (l_encours.getTitre().equals("Les rois maudits")) {
				esuplivre1.getLivres().remove(i);
				eM.remove(l_encours);
			}
		}
		
		trans.commit();
		Livre liv1 = new Livre();
		liv1 =  eM.find(Livre.class, 1);
		System.out.println("\n");
		for (Emprunt emp : liv1.getEmprunts()) {
			System.out.println(emp);
		}
		System.out.println("\n");
		
//		trans.begin();
//		Livre l1 = new Livre();
//		l1.setTitre("Les rois maudits");
//		l1.setAuteur("Maurice DRUON");
//		eM.persist(l1);
//		
//		Emprunt e1 = eM.find(Emprunt.class,1);
//		e1.getLivres().add(l1);
//		eM.persist(e1);
//		trans.commit();
		
		System.out.println(eM.find(Emprunt.class,1));
		
	}

}

/*
DROP TABLE IF EXISTS CLIENT ;
DROP TABLE IF EXISTS LIVRE ;
DROP TABLE IF EXISTS EMPRUNT ;
DROP TABLE IF EXISTS COMPO ;
create table CLIENT (ID integer(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, NOM varchar(50) NOT NULL, PRENOM varchar(50) NOT NULL);
create table LIVRE (ID integer(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, TITRE varchar(255) NOT NULL, AUTEUR varchar(50) NOT NULL);
create table EMPRUNT (ID integer(10) NOT NULL PRIMARY KEY, DATE_DEBUT DATETIME NOT NULL, DATE_FIN DATETIME,DELAI integer(10), ID_CLIENT integer(10) not null);
CREATE TABLE COMPO (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, ID_LIV integer(10) NOT NULL, ID_EMP integer(10) NOT NULL);
insert into CLIENT (NOM, PRENOM) VALUES ('Brigand', 'Pierre');
insert into CLIENT (NOM, PRENOM) VALUES ('YU', 'Cheng');
insert into CLIENT (NOM, PRENOM) VALUES ('BERRAD', 'Hicham');
insert into LIVRE VALUES (1, 'Vingt mille lieues sous les mers', 'Jules Verne');
insert into LIVRE VALUES (2, 'Germinal', 'Emile Zola');
insert into LIVRE VALUES (3, 'Guerre et paix', 'Léon Tolstoï');
insert into LIVRE VALUES (4, 'Apprendre à parler aux animaux', 'Gaston Pouet');
insert into LIVRE VALUES (5, '1001 recettes de Cuisine', 'Jean-Pierre Coffe');
insert into EMPRUNT VALUES (1, '2017-11-12', '2017-11-18', 15, 1);
insert into EMPRUNT VALUES (2, '2017-12-08', '2017-12-23', 30, 2);
insert into EMPRUNT VALUES (3, '2017-12-09', '2018-01-04', 30, 3);
insert into EMPRUNT VALUES (4, '2018-01-03', NULL, 21, 1);
insert into EMPRUNT VALUES (5, '2018-01-13', NULL, 21, 3);
insert into COMPO VALUES (1, 1, 1);
insert into COMPO VALUES (2, 4, 1);
insert into COMPO VALUES (3, 2, 2);
insert into COMPO VALUES (4, 3, 2);
insert into COMPO VALUES (5, 1, 3);
insert into COMPO VALUES (6, 5, 4);
insert into COMPO VALUES (7, 2, 4);
insert into COMPO VALUES (8, 3, 5);
*/