/**
 * 
 */
package fr.eni.eboy.dal;

import fr.eni.eboy.bo.Article;

/**
 * @author SIDY
 *
 */
public interface ArticleDao {

	    Article ajouter(Article articleAAjouter) throws Exception  ; 
	 
	 Article selectById(int id);
	 
	 boolean updateById(int id);
	 
	  
}
