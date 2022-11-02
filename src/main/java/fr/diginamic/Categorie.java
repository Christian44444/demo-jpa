/**
 * 
 */
package fr.diginamic;

/**
 * @author cmich
 *
 */
public enum Categorie {
	/** Catégorie de villej */
	PETITE("petite"), MOYENNE("Moyenne"), GRANDE("Grande");
	
	/** libelle */
	private String libelle;
	
	/**
	 * Constructeur
	 * 
	 * @param libelle libellé
	 */
	private Categorie (String libelle) {
		this.libelle = libelle;
	}
	/**
	 * Permet de rechercher une Saison à partir de son libellé
	 * 
	 * @param libelle libellé
	 * @return {@link Saison}
	 */
	public static Categorie valueOfLibelle(String libelle) {
		if (libelle == null) {
			return null;
		}
		Categorie[] cats = Categorie.values();
		for (Categorie cat : cats) {
			if (libelle.equals(cat.getLibelle())) {
				return cat;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
}
