package fr.diginamic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class POJO Regions
 * @author cmich
 *
 */

@Entity
@Table(name = "regions")
public class Regions {
	/**
	 * Champ Id de la région  
	 */
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iD;
	
	/**
	 * Champ Nom de la région
	 */
	@Column(name = "NOM", length = 11, nullable = false)
	private String nom;
	
	public Regions() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public String toString() {
		return "Regions [iD=" + iD + ", nom=" + nom + "]";
	}

	/**
	 * @return the iD
	 */
	public Integer getiD() {
		return iD;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setiD(Integer iD) {
		this.iD = iD;
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
	
	
}
