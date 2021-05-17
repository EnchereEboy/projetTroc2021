/**
 * 
 */
package fr.eni.eboy.bo;

import java.io.Serializable;

/**
 * @author SIDY
 *
 */

public class Retrait implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer no_article;
	private String rue;// 30 Caratctères maximum
	private String code_postale;// 15 Caratctères maximum
	private String ville;// 30 Caratctères maximum
	public Integer getNo_article() {
		return no_article;
	}
	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCode_postale() {
		return code_postale;
	}
	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Retrait [no_article=" + no_article + ", rue=" + rue + ", code_postale=" + code_postale + ", ville="
				+ ville + "]";
	}
	public Retrait() {
		
	}
	public Retrait(Integer no_article, String rue, String code_postale, String ville) {
		this();
		setNo_article(no_article);
		setRue(rue);
		setCode_postale(code_postale);
		setVille(ville);
	}
	
	public Retrait( String rue, String code_postale, String ville) {
		this(); 
		setRue(rue);
		setCode_postale(code_postale);
		setVille(ville);
	}
	

	
}