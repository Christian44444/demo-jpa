package fr.diginamic;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Class POJO Regions
 * @author cmich
 *
 */

@Entity
@Table(name = "regions")
public class Regionj {
	/**
	 * Champ Id de la région  
	 */
	@Id
	@Column(name = "Id")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Champ Nom de la région
	 */
	@Column(name = "NOM", length = 30, nullable = false)
	private String nom;
	
	@OneToMany(mappedBy = "region")
	private List<Villej> villejs;
	
	public Regionj() {
		// TODO Auto-generated constructor stub
		villejs = new ArrayList<Villej>();
	}

	@Override
	public String toString() {
		return "Regions [iD=" + id + ", nom=" + nom + "]";
	}

	/**
	 * @return the iD
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param iD the iD to set
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
	 * @return the villejs
	 */
	public List<Villej> getVillejs() {
		return villejs;
	}

	/**
	 * @param villejs the villejs to set
	 */
	public void setVillejs(List<Villej> villejs) {
		this.villejs = villejs;
	}
	

}
