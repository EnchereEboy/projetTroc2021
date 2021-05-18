/**
 * 
 */
package fr.eni.eboy.bll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Categorie;
import fr.eni.eboy.bo.Retrait;
import fr.eni.eboy.bo.Utilisateur;
import fr.eni.eboy.dal.DaoFactory;

/**
 * @author SIDY
 *
 */
public class ArticleManager {
   
   public Article Ajouter( String nom, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer prixInitial, Integer prixVente, boolean etatVente,
			Utilisateur utilisateur, Categorie categorie, Retrait lieuRetrait) throws Exception {
	   Article newArticle=new Article( nom,  description, dateDebutEncheres,
			   dateFinEncheres, prixInitial,  prixVente, false, utilisateur,  categorie,lieuRetrait); 
	  return  DaoFactory.getArticleDao().ajouter( newArticle);
	    
   }

	/*Select all potentiellement inutile car il n'est pas utilisé
	 * 
	 */
	public List<Article> selectAll() {
		return DaoFactory.getArticleDao().selectAll();
	}
	
	public List<Article> selectAllEnCours() {
		return DaoFactory.getArticleDao().selectAllEnCours();
	}
	
	public List<Article> selectByCategorieAndNameEnCours (Categorie cat, String recherche){
		return DaoFactory.getArticleDao().selectByCategorieAndNameEnCours(cat, recherche); 
	}
	
	public Article selectById(Integer idArticle) {
		return DaoFactory.getArticleDao().selectById(idArticle);
	}
	
	public List<Article> selectAchatEncherePlusGagneePlusOuverte (Categorie cat, String recherche, boolean enchereOuverte, boolean encherePerso, boolean enchereGagnee, int idUtilisateur) {
		//DaoFactory.getUtilisateurDao().selectEnchereById(idUtilisateur);
		//TO DOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		List<Article> listeArticleAAfficher = new ArrayList<Article>();
		
		//Transformation des états coché ou non coché des check box en 
		// 1 String pour utiliser un Switch case
		//Etape 1 avec l'enregistrement des checkbox dans 1 Integer
		Integer checkBoxCode = 0;
		if (enchereOuverte) 
		{checkBoxCode += 1;}
		if (encherePerso) 
		{checkBoxCode += 10;}
		if (enchereGagnee)
		{checkBoxCode += 100;}
		
		//Etape 2 avec un cast en String
		String checkBoxliees = checkBoxCode.toString();
		System.out.println(checkBoxliees); //Debug pour visualiser la valeur
		
		switch(checkBoxliees){
		case "0":
			//Vide exprès car si non coché alors on est dans la recherche classique aussi du "1"
		case "1":
			listeArticleAAfficher = selectByCategorieAndNameEnCours(cat, recherche);
			break;
		case "11":
			listeArticleAAfficher = selectByCategorieAndNameEnCours(cat, recherche);
			listeArticleAAfficher.addAll(selectAchatEncherePerso(cat, recherche, idUtilisateur));
			break;
		case "101":
			listeArticleAAfficher = selectByCategorieAndNameEnCours(cat, recherche);
			listeArticleAAfficher.addAll(selectAchatEnchereGagnee(cat, recherche, idUtilisateur));
			break;
		case "111":
			listeArticleAAfficher = selectByCategorieAndNameEnCours(cat, recherche);
			listeArticleAAfficher.addAll(selectAchatEncherePerso(cat, recherche, idUtilisateur));
			listeArticleAAfficher.addAll(selectAchatEnchereGagnee(cat, recherche, idUtilisateur));
			break;
		case "10":
			listeArticleAAfficher = selectAchatEncherePerso(cat, recherche, idUtilisateur);
			break;
		case "110":
			listeArticleAAfficher = selectAchatEncherePerso(cat, recherche, idUtilisateur);
			listeArticleAAfficher.addAll(selectAchatEnchereGagnee(cat, recherche, idUtilisateur));
			break;
		case "100":
			listeArticleAAfficher = selectAchatEnchereGagnee(cat, recherche, idUtilisateur);
			break;
		default : 
			System.out.println("Erreur lors du switch de recherche avec le Radio Achat selectionné");
			break;
		}
		
		
		return listeArticleAAfficher;
		
	}
	
	private List<Article> selectAchatEncherePerso(Categorie cat, String recherche, int idUtilisateur) {
		return DaoFactory.getArticleDao().selectByCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur);
	}

	private List<Article> selectAchatEnchereGagnee(Categorie cat, String recherche, int idUtilisateur) {
		return DaoFactory.getArticleDao().selectByCategorieAndNameAndUtilisateurGagnee(cat, recherche, idUtilisateur);
	}
	
	public List<Article> selectByCategorieAndNameAndUtilisateur(Categorie cat, String recherche, Integer idUtilisateur){
		return DaoFactory.getArticleDao().selectByCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur);
	} 
   
	public List<Article> selectByCategorieAndNameAndUtilisateurGagnee(Categorie cat, String recherche, Integer idUtilisateur){
		return DaoFactory.getArticleDao().selectByCategorieAndNameAndUtilisateurGagnee(cat, recherche, idUtilisateur);
	} 
   
}
