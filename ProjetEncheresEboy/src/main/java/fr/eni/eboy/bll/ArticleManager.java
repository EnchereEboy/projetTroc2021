/**
 * 
 */
package fr.eni.eboy.bll;

import java.time.LocalDateTime;

import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Retrait;
import fr.eni.eboy.dal.DaoFactory;

/**
 * @author SIDY
 *
 */
public class ArticleManager {
//   private ArticleDao articleDao;
//   
//   public ArticleManager() {
//	   articleDao=DaoFactory.getArticleDao();
//   }
   
   public Article Ajouter(String nomArticle,String description,   LocalDateTime dateDebutEnchere, 
		   LocalDateTime dateFinEnchere,Integer prixInitial,Integer prixVente, boolean etatvente,
		   Integer noUtilisateur, Integer noCategorie, Retrait ptRetrait) throws Exception {
	   Article nouveauArticle=new Article( nomArticle,  description, dateDebutEnchere,
			   dateFinEnchere, prixInitial,  prixVente, false, noUtilisateur,  noCategorie,ptRetrait); 
	  return  DaoFactory.getArticleDao().ajouter(nouveauArticle);
	    
   }
   
//   public Article Ajouter(String nomArticle,String description,   LocalDateTime dateDebutEnchere, 
//		   LocalDateTime dateFinEnchere,Integer prixInitial,Integer prixVente, boolean etatvente,
//		   Integer noUtilisateur, Integer noCategorie) throws Exception {
//	   Article nouveauArticle=new Article( nomArticle,  description, dateDebutEnchere,
//			   dateFinEnchere, prixInitial,  prixVente, false, noUtilisateur,  noCategorie); 
//	  return  DaoFactory.getArticleDao().ajouter(nouveauArticle);
//	    
//   }
   
   
}
