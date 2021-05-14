/**
 * 
 */
package fr.eni.eboy.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author SIDY
 *
 */

public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer no_article;
	private String nom_article;//String de 30 maximum
	private String description;//String de 300 maximum
	private LocalDateTime date_debut_encheres;// supérieur à la date du jour
	private LocalDateTime date_fin_encheres;// superieur à la date du d颵but des ench貥s
	private Integer prix_initial;
	private Integer prix_vente;
	private boolean etat_vente;
	private Integer no_utilisateur;
	private Integer no_categorie;
	
	private Retrait lieuRetrait;	
	
	public Article() { 	
	}
	
	
	public Article(String nom_article, String description, LocalDateTime date_debut_encheres,
			LocalDateTime date_fin_encheres, Integer prix_initial, Integer prix_vente, boolean etat_vente,
			Integer no_utilisateur, Integer no_categorie, Retrait lieuRetrait) {
		 
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.etat_vente = etat_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.lieuRetrait = lieuRetrait;
	} 


	public Article(Integer no_article, String nom_article, String description, LocalDateTime date_debut_encheres,
			LocalDateTime date_fin_encheres, Integer prix_initial, Integer prix_vente, boolean etat_vente,
			Integer no_utilisateur, Integer no_categorie, Retrait lieuRetrait) {
	 
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.etat_vente = etat_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.lieuRetrait = lieuRetrait;
	}

	public Article(String nom_article, String description, LocalDateTime date_debut_encheres,
			LocalDateTime date_fin_encheres, Integer prix_initial, Integer prix_vente, boolean etat_vente,
			Integer no_utilisateur, Integer no_categorie ) { 
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.etat_vente = etat_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie; 
	}


	public Integer getNo_article() {
		return no_article;
	}
	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}
	public String getNom_article() {
		return nom_article;
	}
	
	
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDate_debut_encheres() {
		return date_debut_encheres;
	}
	public void setDate_debut_encheres(LocalDateTime date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}
	public LocalDateTime getDate_fin_encheres() {
		return date_fin_encheres;
	}
	public void setDate_fin_encheres(LocalDateTime date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}
	public Integer getPrix_initial() {
		return prix_initial;
	}
	public void setPrix_initial(Integer prix_initial) {
		this.prix_initial = prix_initial;
	}
	public Integer getPrix_vente() {
		return prix_vente;
	}
	public void setPrix_vente(Integer prix_vente) {
		this.prix_vente = prix_vente;
	}
	public boolean isEtat_vente() {
		return etat_vente;
	}
	public void setEtat_vente(boolean etat_vente) {
		this.etat_vente = etat_vente;
	}
	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public Integer getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(Integer no_categorie) {
		this.no_categorie = no_categorie;
	}
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	} 
	
	
	 
	
	
	@Override
	public String toString() {
		return "Article [no_article=" + no_article + ", nom_article=" + nom_article + ", description=" + description
				+ ", date_debut_encheres=" + date_debut_encheres + ", date_fin_encheres=" + date_fin_encheres
				+ ", prix_initial=" + prix_initial + ", prix_vente=" + prix_vente + ", etat_vente=" + etat_vente
				+ ", no_utilisateur=" + no_utilisateur + ", no_categorie=" + no_categorie + "]";
	}
	

}


