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


@Entity
@Table(name = "habitants")
public class Habitantj {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id") 
	private Integer id;
	
	@Column(name = "Nom", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "Prenom", length = 50, nullable = false)
	private String prenom;
	
	@ManyToMany
	@JoinTable(name = "villes_habitants", 
			   joinColumns = @JoinColumn(name = "id_hab", referencedColumnName = "Id" ),
			   inverseJoinColumns = @JoinColumn(name = "id_ville", referencedColumnName = "Id"))
	private List<Villej> villejs = new ArrayList<Villej>();

	/**
	 * Constructeur sans paramètre Obligatoire
	 */
	public Habitantj() {
		super();
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
	 * @return the villejs
	 */
	public List<Villej> getVillejs() {
		return villejs;
	}

//	/** le virer
//	 * @param villejs the villejs to set
//	 */
//	public void setVillejs(List<Villej> villejs) {
//		this.villejs = villejs;
//	}
	
	
}
