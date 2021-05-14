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

public class Enchere implements Serializable{
	private Integer no_enchere;
	private LocalDateTime date_enchere;
	private Integer montant_enchere;
	private Integer no_article;
	private Integer no_utilisateur;
	public Integer getNo_enchere() {
		return no_enchere;
	}
	public void setNo_enchere(Integer no_enchere) {
		this.no_enchere = no_enchere;
	}
	public LocalDateTime getDate_enchere() {
		return date_enchere;
	}
	public void setDate_enchere(LocalDateTime date_enchere) {
		this.date_enchere = date_enchere;
	}
	public Integer getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	public Integer getNo_article() {
		return no_article;
	}
	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}
	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	@Override
	public String toString() {
		return "Enchere [no_enchere=" + no_enchere + ", date_enchere=" + date_enchere + ", montant_enchere="
				+ montant_enchere + ", no_article=" + no_article + ", no_utilisateur=" + no_utilisateur + "]";
	}
	
	public Enchere() {
		
	}
	
	public Enchere(Integer no_enchere, LocalDateTime date_enchere, Integer montant_enchere, Integer no_article,
			Integer no_utilisateur) {
		this();
		setNo_enchere(no_enchere);
		setDate_enchere(date_enchere);
		setMontant_enchere(montant_enchere);
		setNo_article(no_article);
		setNo_utilisateur(no_utilisateur);
	}

	
	
}
