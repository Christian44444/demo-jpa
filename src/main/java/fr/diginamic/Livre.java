package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * Classe livre à tester avec BibliothèqueTest
 * @author cmich
 *
 */
@Entity
@Table(name = "livre")
public class Livre {
	/** id Identifiant du livre*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 10, nullable = false)
	private Integer id;
	/** titre Nom du livre*/
	@Column(name = "TITRE", length = 255, nullable = false)
	private String titre;
	/** auteur Auteur du livre*/
	@Column(name = "AUTEUR", length = 50, nullable = false)
	private String auteur;
	
	@ManyToMany
	@JoinTable(name = "COMPO", 
			   joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "Id" ),
			   inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "Id"))
	private List<Emprunt> emprunts = new ArrayList<Emprunt>();

	
	/**
	 * Constructeur sans arguments
	 */
	public Livre() {
		super();
	}

	

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + /*", emprunts=" + emprunts +*/ "]";
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**
	 * @return the emprunts
	 */
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}
	
	
	
}
