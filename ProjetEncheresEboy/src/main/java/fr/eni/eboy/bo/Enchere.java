package fr.eni.eboy.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Classe représentant l'ojet enchere
 * @author sboussoukou2021
 *
 */
public class Enchere implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numero;
	private LocalDateTime date;
	private Integer montant;
	private Article article;
	private Utilisateur utilisateur;
	
	
	public Enchere() {
		
	}

	public Enchere(Integer numero, LocalDateTime date, Integer montant, Article article, Utilisateur utilisateur) {
		this();
		setNumero(numero);
		setDate(date);
		setMontant(montant);
		setArticle(article);
		setUtilisateur(utilisateur);
	}

	
	public Enchere( LocalDateTime date, Integer montant, Article article, Utilisateur utilisateur) {
		this(); 
		setDate(date);
		setMontant(montant);
		setArticle(article);
		setUtilisateur(utilisateur);
	}



	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public Integer getMontant() {
		return montant;
	}


	public void setMontant(Integer montant) {
		this.montant = montant;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	@Override
	public String toString() {
		return "Enchere [numero=" + numero + ", date=" + date + ", montant=" + montant + ", article=" + article
				+ ", utilisateur=" + utilisateur + "]";
	}
	
}
