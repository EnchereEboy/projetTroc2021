/**
 * 
 */
package fr.eni.eboy.dal;
 

/**
 * @author SIDY
 *
 */
public class DaoFactory {
	 
	  
	/**
	 * Méthode en charge de
	 * @return
	 */
	public static ArticleDao getArticleDao() {
		return new ArticleDaoJdbcImpl();
	}
	
	/**
	 * Méthode en charge de
	 * @return
	 */
	public static UtilisateurDao getUtilisateurDao() {
		return new UtilisateurDaoJdbcImpl();
	}

	/**
	 * Méthode en charge de
	 * @return
	 */
	public static CategorieDao getCategorieDao() {
		return new CategorieDaoJdbcImpl();
	}

	/**
	 * Méthode en charge de
	 * @return
	 */
	public static EnchereDao getEnchereDao() {
		return new EnchereDaoJdbcImpl();
	}	
	
	
	
}
