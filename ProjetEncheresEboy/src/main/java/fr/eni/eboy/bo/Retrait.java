/**
 * 
 */
package fr.eni.eboy.bo;

import java.io.Serializable;

/**
 *  @author sboussoukou2021
 *
 */

public class Retrait implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Article article;
	private String rue;// 30 Caratctères maximum
	private String codePostal;// 15 Caratctères maximum
	private String ville;// 30 Caratctères maximum
	
	public Retrait() {
		
	}
	public Retrait(Article article, String rue, String codePostal, String ville) {
		this();
		setArticle(article);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
	}
	
	public Retrait( String rue, String codePostal, String ville) {
		this(); 
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
	}
	

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		return "Retrait [article=" + article + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	
}