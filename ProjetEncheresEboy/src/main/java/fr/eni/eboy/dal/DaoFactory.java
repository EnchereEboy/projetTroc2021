/**
 * 
 */
package fr.eni.eboy.dal;
 

/**
 * @author SIDY
 *
 */
public class DaoFactory {
	 
	  
	public static ArticleDao getArticleDao() {
		return new ArticleDaoJdbcImpl();
	}
	
	
	
}
