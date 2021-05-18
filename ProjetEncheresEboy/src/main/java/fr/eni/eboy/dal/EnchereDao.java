/**
 * 
 */
package fr.eni.eboy.dal;

import fr.eni.eboy.bo.Article;
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

	public boolean deleteById (int id);
	
	//Debut des Select
	public Enchere selectById(int id);
	
	public Enchere selectByUtilisateurAcheteur(Utilisateur utilisateur);
	
	public Enchere selectByUtilisateurGagne(Utilisateur utilisateur);

	public Enchere selectByArticleMeilleurOffre (Article article);

}
