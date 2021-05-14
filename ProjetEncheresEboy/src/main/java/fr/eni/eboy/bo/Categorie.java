/**
 * 
 */
package fr.eni.eboy.bo;

import java.io.Serializable;

/**
 * @author SIDY
 *
 */

public class Categorie implements Serializable{
	private Integer no_categorie;
	private String libelle; //30 caractères maximum
	public Integer getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(Integer no_categorie) {
		this.no_categorie = no_categorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Categorie [no_categorie=" + no_categorie + ", libelle=" + libelle + "]";
	}
	public Categorie() {
		
	}
	
	public Categorie(Integer no_categorie, String libelle) {
		this();
		setNo_categorie(no_categorie);
		setLibelle(libelle);
	}

	
	
	
}