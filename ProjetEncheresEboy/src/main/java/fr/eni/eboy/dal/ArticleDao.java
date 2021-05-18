/**
 * 
 */
package fr.eni.eboy.dal;

import java.util.List;

import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Categorie;

/**
 * Classe en charge
 * @author tkervran2021
 * @version ProjetEncheresEboy - v1.0
 * @date 18 mai 2021 - 09:38:53
 */
public interface ArticleDao {

	    Article ajouter(Article articleAAjouter) throws Exception  ; 
	 /*
	  * Début avec les Create Update Delete
	  */
	 	Article insert(Article article);
	 	
	 	boolean delete (Integer idArticle);
	 	
	 	public boolean update(Article article);

	 	/*
	 	 * Methode spécifique utile pour l'affichage de l'écran d'acceuil
	 	 */
	 	List<Article> selectByCategorieAndNameAndUtilisateur(Categorie cat, String recherche, Integer idUtilisateur);

	 	List<Article> selectByCategorieAndNameAndUtilisateurGagnee(Categorie cat, String recherche, Integer idUtilisateur);

	 	List<Article> selectByCategorieAndNameEnCours(Categorie cat, String recherche);

	 	List<Article> selectAllEnCours();

	 	List<Article> selectAll();

	 	/**
	 	 * Méthode en charge de
	 	 * @param idArticle 
	 	 * @return
	 	 */
	 	Article selectById(Integer idArticle);

	 	
	 	
	  
}
