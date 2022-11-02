package fr.diginamic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Classe Villej pour l'exo JPA de génération
 * @author cmich
 *
 */
@Entity()
@Table(name = "Ville")
public class Villej {
	/** Id de la ville */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", length = 11, nullable = false, unique = true)
	private Integer Id; 
	/** Nom de la ville */
	@Column(name = "Nom", length = 50, nullable = false)
	private String nom;
	/** Code postal de la ville */
	@Column(name = "Code_Postal", length = 6, nullable = false)
	private String codePostal;
	/** Date de dernier recensement de la ville */
	@Column(name = "DateDernierRecencement")
	@Temporal(value = TemporalType.DATE)
	private Date dateDerRecencement;
	/** Catégorie de la ville */
	@Column (name = "Categorie", nullable = false)
	@Enumerated (EnumType.STRING) // Stocke le nom par défaut ORDINAL
	private Categorie categorie;
	
	/**
	 * Constructeur obligatoire
	 */
	public Villej() {
		super();
	}
	@Override
	public String toString() {
		return "Villej [Id=" + Id + ", nom=" + nom + ", codePostal=" + codePostal + ", dateDerRecencement="
				+ dateDerRecencement + ", categorie=" + categorie + "]";
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
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
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the dateDerRecencement
	 */
	public Date getDateDerRecencement() {
		return dateDerRecencement;
	}
	/**
	 * @param dateDerRecencement the dateDerRecencement to set
	 */
	public void setDateDerRecencement(Date dateDerRecencement) {
		this.dateDerRecencement = dateDerRecencement;
	}
	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	
}
