/**
 * 
 */
package fr.eni.eboy.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import fr.eni.eboy.bo.Article;

/**
 * @author SIDY
 *
 */

public class ArticleDaoJdbcImpl implements ArticleDao {
	private static final DateTimeFormatter formatJourMoisAnneeHeureMinute = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private static final String REQ_INSERT="INSERT INTO ARTICLES_VENDUS (nom_article,"
			+ "description,"
			+ "date_debut_encheres,"
			+ "date_fin_encheres,"
			+ "prix_initial,"
			+ "prix_vente,"
			+ "no_utilisateur,"
			+ "no_categorie)" 
			+ "VALUES(? ,?, ?, ?, ?, ?, ?, ?)"; 
	private static final String REQ_INSERT_RETRAIT="INSERT INTO RETRAITS (no_article , rue , code_postal , ville) VALUES(?, ?, ?, ?)";
	
	private static final String REQ_SELECTBYID="select nom_article,description,date_debut_encheres,"
			+ "date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente\r\n"
			+ "from ARTICLES_VENDUS where no_article=?";
	
	private static final String REQ_UPDATEBYID="update ARTICLES_VENDUS set nom_article=?, description=?, "
			+ "date_debut_encheres=?,date_fin_encheres=?,prix_initial=?, prix_vente=?,no_categorie=? "
			+ "  where no_article=?";
	
	
	
	
	@Override
	public Article ajouter(Article articleAAjouter) { 
		try(Connection cnx=ConnectionProvider.getConnection()){
			PreparedStatement pStmt= cnx.prepareStatement(REQ_INSERT, Statement.RETURN_GENERATED_KEYS);
			  pStmt.setString(1, articleAAjouter.getNom_article());
			  pStmt.setString(2, articleAAjouter.getDescription());
			  pStmt.setString(3, articleAAjouter.getDate_debut_encheres().format(formatJourMoisAnneeHeureMinute)) ;
			  pStmt.setString(4, articleAAjouter.getDate_fin_encheres().format(formatJourMoisAnneeHeureMinute)) ; 
			  pStmt.setInt(5,articleAAjouter.getPrix_initial());
			  pStmt.setInt(6, articleAAjouter.getPrix_vente());   
			  pStmt.setInt(7,articleAAjouter.getNo_utilisateur());
			  pStmt.setInt(8, articleAAjouter.getNo_categorie());
//			int nbreLigneInseree= pStmt.executeUpdate();
			 pStmt.executeUpdate();
			ResultSet rs=pStmt.getGeneratedKeys();
			if(rs.next()) {
				articleAAjouter.setNo_article(rs.getInt(1));
			}
			
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		System.out.println(articleAAjouter);
		return articleAAjouter;
	}

	@Override
	public Article selectById(int id) {
		 
		return null;
	}  

	@Override
	public boolean updateById(int id) {
	    
		return false;
	}

}