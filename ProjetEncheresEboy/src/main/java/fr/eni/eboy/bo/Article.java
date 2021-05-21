package fr.eni.eboy.bo;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe représentant un article
 * 
 * @author sboussoukou2021
 *
 */
public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numero;
	private String nom;//String de 30 maximum
	private String description;//String de 300 maximum
	private LocalDateTime dateDebutEncheres;// supérieur à la date du jour
	private LocalDateTime dateFinEncheres;// superieur à la date du début des enchères
	private Integer prixInitial;
	private Integer prixVente;
	private boolean etatVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	
	private Retrait lieuRetrait;
	

	private List<Enchere> listeEncheres = new ArrayList<>();
	
	
	public Article() {
		
	}


	public Article(Integer numero, String nom, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer prixInitial, Integer prixVente, boolean etatVente,
			Utilisateur utilisateur, Categorie categorie, List<Enchere> listeEncheres) {
		this();
		setNumero(numero);
		setNom(nom);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setPrixInitial(prixInitial);
		setPrixVente(prixVente);
		setEtatVente(etatVente);
		setUtilisateur(utilisateur);
		setCategorie(categorie);
		setListeEncheres(listeEncheres);
	}

	public Article(Integer numero, String nom, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer prixInitial, Integer prixVente, boolean etatVente,
			Utilisateur utilisateur, Categorie categorie) {
		this();
		setNumero(numero);
		setNom(nom);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setPrixInitial(prixInitial);
		setPrixVente(prixVente);
		setEtatVente(etatVente);
		setUtilisateur(utilisateur);
		setCategorie(categorie);
	}


	public Article(Integer numero, String nom, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer prixInitial, Integer prixVente, boolean etatVente,
			Utilisateur utilisateur, Categorie categorie, Retrait lieuRetrait) {
		this();
		setNumero(numero);
		setNom(nom);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setPrixInitial(prixInitial);
		setPrixVente(prixVente);
		setEtatVente(etatVente);
		setUtilisateur(utilisateur);
		setCategorie(categorie);
		setLieuRetrait(lieuRetrait);
	}

	
	/**
	 * Constructeur d'un nouvel article en BDD.
	 * @param nom
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param etatVente
	 * @param utilisateur
	 * @param categorie
	 * @param lieuRetrait
	 */
	public Article(String nom, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres,
			Integer prixInitial, Integer prixVente, boolean etatVente, Utilisateur utilisateur, Categorie categorie,
			Retrait lieuRetrait) {
		this();
		setNom(nom);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setPrixInitial(prixInitial);
		setPrixVente(prixVente);
		setEtatVente(etatVente);
		setUtilisateur(utilisateur);
		setCategorie(categorie);
		setLieuRetrait(lieuRetrait);	
		}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getDateDebutEncheres() {
		return dateDebutEncheres;
	}


	public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}


	public LocalDateTime getDateFinEncheres() {
		return dateFinEncheres;
	}


	public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}


	public Integer getPrixInitial() {
		return prixInitial;
	}


	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}


	public Integer getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}


	public boolean isEtatVente() {
		return etatVente;
	}


	public void setEtatVente(boolean etatVente) {
		this.etatVente = etatVente;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	/**
	 * Getter pour lieuRetrait.
	 * @return the lieuRetrait
	 */
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}


	/**
	 * Setter pour lieuRetrait.
	 * @param lieuRetrait the lieuRetrait to set
	 */
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}


	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}

	

	/**
	* {@inheritDoc}
	*/
	@Override
	public boolean equals(Object other) {
		boolean retourEgalité= false;
		if (other == null) {
			retourEgalité = false;
		}
		if(this.getClass() != other.getClass()) {
			retourEgalité = false;
		}
		if(this.getNumero() == ((Article)other).getNumero()) {
			retourEgalité = true;
		}
		return retourEgalité;
	}


	@Override
	public String toString() {
		return "Article [numero=" + numero + ", nom=" + nom + ", description=" + description + ", dateDebutEncheres="
				+ dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", prixInitial=" + prixInitial
				+ ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", utilisateur=" + utilisateur
				+ ", categorie=" + categorie + ", listeEncheres=" + listeEncheres + "]";
	}
	
	
	
	
	
	
	
	
	
	

}


