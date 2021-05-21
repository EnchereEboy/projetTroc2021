/**
 * 
 */
/**
 * 
 */
package fr.eni.eboy.dal;

import java.util.List;

import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Categorie;
import fr.eni.eboy.bo.Enchere;
import fr.eni.eboy.bo.Utilisateur;

/**
 * Classe en charge
 * @author tkervran2021
 * @version ProjetEncheresEboy - v1.0
 * @date 14 mai 2021 - 16:40:19
 */
public interface EnchereDao {

	// Début des create update delete
	public Enchere insertNewEnchere(Enchere newEnchere);

	public boolean deleteById (Integer idEnchere);
	
	//Debut des Select
	public Enchere selectById(Integer idEnchere);
	
	public List<Enchere> selectByUtilisateurAcheteur(Utilisateur utilisateur, String recherche);
	public List<Enchere> selectByUtilisateurAcheteurByCatByName(Categorie cat, Utilisateur utilisateur, String recherche);
	
	
	
	public List<Enchere> selectByUtilisateurGagne(Utilisateur utilisateur);
	public List<Enchere> selectByUtilisateurAcheteurGagneByCatByName (Categorie cat, Utilisateur utilisateur, String recherche);

	public Enchere selectByArticleMeilleurOffre (Article article);
	
	public int enchereTransact (Enchere newEnchere);
	
		

}