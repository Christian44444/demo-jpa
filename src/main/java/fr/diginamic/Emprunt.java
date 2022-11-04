package fr.diginamic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Classe Emprunt à tester avec BibliothèqueTest
 * @author cmich
 *
 */
@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
	/** id Identifiant de l'emprunt */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 10, nullable = false)
	private Integer id;
	
	@Column(name = "DATE_DEBUT", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateDebut;
	
	@Column(name = "DELAI",length = 10 , nullable = true) 
	private Integer delai;
	
	@Column(name = "DATE_FIN", nullable = true)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn (name = "ID_CLIENT" )
	private Client client;
	
	@ManyToMany
	@JoinTable(name = "COMPO", 
			   joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID" ),       // ID fait référence au name du @Column 
			   inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID")) // et non à la variable
	private List<Livre> livres = new ArrayList<Livre>();

	
	/**
	 * Constructeur sans arguments
	 */
	public Emprunt() {
		super();
	}

	

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", delai=" + delai + ", dateFin=" + dateFin
				+ ", client=" + client + ", livres=" + livres + "]";
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
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}

	/**
	 * @param delai the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the idClient
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return livres;
	}
	
	
}
