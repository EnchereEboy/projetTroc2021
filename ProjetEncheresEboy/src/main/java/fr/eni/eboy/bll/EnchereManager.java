/**
 * 
 */
package fr.eni.eboy.bll;

import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Enchere;
import fr.eni.eboy.bo.Utilisateur;
import fr.eni.eboy.dal.DaoFactory;

/**
 * Classe en charge
 * @author tkervran2021
 * @version ProjetEncheresEboy - v1.0
 * @date 14 mai 2021 - 16:26:52
 */
public class EnchereManager {

	
	
	// Début des create update delete
	public Enchere insertNewEnchere(Enchere newEnchere) {
		return DaoFactory.getEnchereDao().insertNewEnchere(newEnchere);
	}
	
	public boolean deleteById (int id){
		return DaoFactory.getEnchereDao().deleteById(id);
	}
	//Fin C.R.U.D.
	
	//Debut des Select
	public Enchere selectById(int id) {
		return DaoFactory.getEnchereDao().selectById(id);
	}
	public Enchere selectByUtilisateurAcheteur(Utilisateur utilisateur) {
		return DaoFactory.getEnchereDao().selectByUtilisateurAcheteur(utilisateur);
	}
	public Enchere selectByUtilisateurGagne(Utilisateur utilisateur) {
		return DaoFactory.getEnchereDao().selectByUtilisateurGagne(utilisateur);
	}
	
	public Enchere selectByArticleMeilleurOffre(Article article) {
		return DaoFactory.getEnchereDao().selectByArticleMeilleurOffre(article);
	}
	
	
}
