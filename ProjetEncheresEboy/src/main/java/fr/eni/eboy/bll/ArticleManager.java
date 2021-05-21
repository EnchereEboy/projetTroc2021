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

	public Article Ajouter(String nom, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer prixInitial, Integer prixVente, boolean etatVente,
			Utilisateur utilisateur, Categorie categorie, Retrait lieuRetrait) throws Exception {
		Article newArticle = new Article(nom, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente,
				false, utilisateur, categorie, lieuRetrait);
		return DaoFactory.getArticleDao().ajouter(newArticle);

	}

	/*
	 * Select all potentiellement inutile car il n'est pas utilisé
	 * 
	 */
	public List<Article> selectAll() {
		return DaoFactory.getArticleDao().selectAll();
	}

	public List<Article> selectAllEnCours() {
		return DaoFactory.getArticleDao().selectAllEnCours();
	}

	public List<Article> selectByCategorieAndNameEnCours(Categorie cat, String recherche) {
		return DaoFactory.getArticleDao().selectByCategorieAndNameEnCours(cat, recherche);
	}

	public Article selectById(Integer idArticle) {
		return DaoFactory.getArticleDao().selectById(idArticle);
	}

	public List<Article> selectAchatEncherePlusGagneePlusOuverte(Categorie cat, String recherche,
			boolean enchereOuverte, boolean encherePerso, boolean enchereGagnee, int idUtilisateur) {
		// DaoFactory.getUtilisateurDao().selectEnchereById(idUtilisateur);
		// TO DOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		List<Article> listeArticleAAfficher = new ArrayList<Article>();

		// Transformation des états coché ou non coché des check box en
		// 1 String pour utiliser un Switch case
		// Etape 1 avec l'enregistrement des checkbox dans 1 Integer
		Integer checkBoxCode = 0;
		if (enchereOuverte) {
			checkBoxCode += 1;
		}
		if (encherePerso) {
			checkBoxCode += 10;
		}
		if (enchereGagnee) {
			checkBoxCode += 100;
		}

		// Etape 2 avec un cast en String
		String checkBoxliees = checkBoxCode.toString();
		System.out.println(checkBoxliees); // Debug pour visualiser la valeur

		switch (checkBoxliees) {
		case "0":
			// Vide exprès car si non coché alors on est dans la recherche classique aussi
			// du "1"
		case "1":
			listeArticleAAfficher = selectByCategorieAndNameEnCours(cat, recherche);
			break;
		case "11":
			listeArticleAAfficher = selectByCategorieAndNameEnCours(cat, recherche);
			listeArticleAAfficher
					.addAll(selectByEnchereAndCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur));
			break;
		case "101":
			listeArticleAAfficher = selectByCategorieAndNameEnCours(cat, recherche);
			listeArticleAAfficher
					.addAll(selectByEnchereGagneeAndCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur));
			break;
		case "111":
			listeArticleAAfficher = selectByCategorieAndNameEnCours(cat, recherche);
			listeArticleAAfficher
					.addAll(selectByEnchereAndCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur));
			listeArticleAAfficher
					.addAll(selectByEnchereGagneeAndCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur));
			break;
		case "10":
			listeArticleAAfficher = selectByEnchereAndCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur);
			break;
		case "110":
			listeArticleAAfficher = selectByEnchereAndCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur);
			listeArticleAAfficher
					.addAll(selectByEnchereGagneeAndCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur));
			break;
		case "100":
			listeArticleAAfficher = selectByEnchereGagneeAndCategorieAndNameAndUtilisateur(cat, recherche,
					idUtilisateur);
			break;
		default:
			System.out.println("Erreur lors du switch de recherche avec le Radio Achat selectionné");
			break;
		}

		return listeArticleAAfficher;

	}
	
	public List<Article> selectVentePlusNonDebuteePlusTerminee(Categorie cat, String recherche,
			boolean venteEnCours, boolean venteNonDebutee, boolean venteTerminee, int idUtilisateur) {
		// DaoFactory.getUtilisateurDao().selectEnchereById(idUtilisateur);
		// TO DOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		List<Article> listeArticleAAfficher = new ArrayList<Article>();

		// Transformation des états coché ou non coché des check box en
		// 1 String pour utiliser un Switch case
		// Etape 1 avec l'enregistrement des checkbox dans 1 Integer
		Integer checkBoxCode = 0;
		if (venteEnCours) {
			checkBoxCode += 1;
		}
		if (venteNonDebutee) {
			checkBoxCode += 10;
		}
		if (venteTerminee) {
			checkBoxCode += 100;
		}

		// Etape 2 avec un cast en String
		String checkBoxliees = checkBoxCode.toString();
		System.out.println(checkBoxliees); // Debug pour visualiser la valeur

		switch (checkBoxliees) {
		case "0":
			// Vide exprès car si non coché alors on est dans la recherche classique aussi
			// du "1"
		case "1":
			listeArticleAAfficher = selectByCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur);
			break;
		case "11":
			listeArticleAAfficher = selectByCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur);
			listeArticleAAfficher
					.addAll(selectByCategorieAndNameAndUtilisateurNonDebutee(cat, recherche, idUtilisateur));
			break;
		case "101":
			listeArticleAAfficher = selectByCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur);
			listeArticleAAfficher
					.addAll(selectByCategorieAndNameAndUtilisateurTerminee(cat, recherche, idUtilisateur));
			break;
		case "111":
			listeArticleAAfficher = selectByCategorieAndNameAndUtilisateur(cat, recherche, idUtilisateur);
			listeArticleAAfficher
					.addAll(selectByCategorieAndNameAndUtilisateurNonDebutee(cat, recherche, idUtilisateur));
			listeArticleAAfficher
					.addAll(selectByCategorieAndNameAndUtilisateurTerminee(cat, recherche, idUtilisateur));
			break;
		case "10":
			listeArticleAAfficher = selectByCategorieAndNameAndUtilisateurNonDebutee(cat, recherche, idUtilisateur);
			break;
		case "110":
			listeArticleAAfficher = selectByCategorieAndNameAndUtilisateurNonDebutee(cat, recherche, idUtilisateur);
			listeArticleAAfficher
					.addAll(selectByCategorieAndNameAndUtilisateurTerminee(cat, recherche, idUtilisateur));
			break;
		case "100":
			listeArticleAAfficher = selectByCategorieAndNameAndUtilisateurTerminee(cat, recherche, idUtilisateur);
			break;
		default:
			System.out.println("Erreur lors du switch de recherche avec le Radio Vente selectionné");
			break;
		}

		return listeArticleAAfficher;

	}

	public List<Article> selectByEnchereAndCategorieAndNameAndUtilisateur(Categorie cat, String recherche,
			Integer idUtilisateur) {
		return DaoFactory.getArticleDao().selectByEnchereAndCategorieAndNameAndUtilisateur(cat, recherche,
				idUtilisateur);
	}

	public List<Article> selectByEnchereGagneeAndCategorieAndNameAndUtilisateur(Categorie cat, String recherche,
			Integer idUtilisateur) {
		return DaoFactory.getArticleDao().selectByEnchereGagneeAndCategorieAndNameAndUtilisateur(cat, recherche,
				idUtilisateur);
	}

	public List<Article> selectByCategorieAndNameAndUtilisateur(Categorie cat, String recherche,
			Integer idUtilisateur) {
		return DaoFactory.getArticleDao().selectByCategorieAndNameAndUtilisateurEnCours(cat, recherche, idUtilisateur);
	}

	public List<Article> selectByCategorieAndNameAndUtilisateurNonDebutee(Categorie cat, String recherche,
			Integer idUtilisateur) {
		return DaoFactory.getArticleDao().selectByCategorieAndNameAndUtilisateurNonDebutee(cat, recherche,
				idUtilisateur);
	}

	public List<Article> selectByCategorieAndNameAndUtilisateurTerminee(Categorie cat, String recherche,
			Integer idUtilisateur) {
		return DaoFactory.getArticleDao().selectByCategorieAndNameAndUtilisateurTerminee(cat, recherche, idUtilisateur);
	}
	
}
