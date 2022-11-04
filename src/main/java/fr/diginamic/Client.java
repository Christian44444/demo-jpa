package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe Client à tester avec BibliothèqueTest
 * @author cmich
 *
 */
@Entity
@Table(name = "client")
public class Client {
	/** id Identifiant du client*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 10, nullable = false)
	private Integer id;
	/** nom Nom du client*/
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	/** prenom Prenom du client*/
	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;
	
	@OneToMany (mappedBy = "client")
	private List<Emprunt> emprunts = new ArrayList<Emprunt>();

	/**
	 * Constructeur sans arguments
	 */
	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the emprunts
	 */
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}
		
		

}
