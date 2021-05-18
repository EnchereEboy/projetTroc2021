/**
 * 
 */
package fr.eni.eboy.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant l'objet catégorie
 * @author sboussoukou2021
 *
 */
public class Categorie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numero;
	private String libelle; //30 caractères maximum
	
	private List<Article> listeArticles = new ArrayList<Article>();
	
	
	public Categorie() {
		
	}

	public Categorie(Integer numero, String libelle, List<Article> listeArticles) {
		this();
		setNumero(numero);
		setLibelle(libelle);
		setListeArticles(listeArticles);
	}



	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Article> getListeArticles() {
		return listeArticles;
	}

	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}

	@Override
	public String toString() {
		return "Categorie [numero=" + numero + ", libelle=" + libelle + ", listeArticles=" + listeArticles + "]";
	}
}