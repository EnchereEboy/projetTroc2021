/**
 * 
 */
package fr.eni.eboy.bll;

import fr.eni.eboy.bo.Categorie;
import fr.eni.eboy.dal.DaoFactory;

/**
 * Classe en charge
 * @author tkervran2021
 * @version ProjetEncheresEboyLocal - v1.0
 * @date 18 mai 2021 - 10:26:18
 */
public class CategorieManager {

	public Categorie selectById(Integer idCategorie) {
		return DaoFactory.getCategorieDao().selectById(idCategorie);
	}
}
