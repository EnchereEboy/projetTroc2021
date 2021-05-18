/**
 * 
 */
package fr.eni.eboy.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Enchere;
import fr.eni.eboy.bo.Utilisateur;

/**
 * Classe en charge
 * @author tkervran2021
 * @version ProjetEncheresEboy - v1.0
 * @date 14 mai 2021 - 16:50:45
 */
public class EnchereDaoJdbcImpl implements EnchereDao {

	

	private static final DateTimeFormatter formatJourMoisAnneeHeureMinute = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private static final DateTimeFormatter formatBDDVersJavaLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
	
	//CONSTANTES DES REQUETE SQL
	private static final String REQ_INSERT_ENCHERE = "INSERT INTO ENCHERES"
			+ "(date_enchere"
			+ ", montant_enchere"
			+ ", no_article"
			+ ", no_utilisateur) "
			+ "VALUES (? ,?, ?, ?)";
	private static final String REQ_SELECT_MEILLEURE_ENCHERE = "SELECT * "
			+ "FROM ENCHERES "
			+ "WHERE "
			+ "no_article = ? "
			+ "AND montant_enchere = ? ";

	//---Constant du nom des colonnes de la BDD
	private static final String NUM_COL = "no_enchere";
	private static final String DATE_ENCH_COL ="date_enchere";
	private static final String MONTANT_COL = "montant_enchere";
	private static final String NUM_ARTICLE_COL = "no_article";
	private static final String NUM_UTILISATEUR_COL = "no_utilisateur";
	
	
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public Enchere insertNewEnchere(Enchere newEnchere) {
try (Connection cnx = ConnectionProvider.getConnection()){
	PreparedStatement pStmt= cnx.prepareStatement(REQ_INSERT_ENCHERE, Statement.RETURN_GENERATED_KEYS);
	pStmt.setString(1, newEnchere.getDate().format(formatBDDVersJavaLocalDateTime));
	pStmt.setInt(2, newEnchere.getMontant());
	pStmt.setInt(3, newEnchere.getArticle().getNumero());
	pStmt.setInt(4, newEnchere.getUtilisateur().getNumero());
	int nbreLigneInseree= pStmt.executeUpdate();
	System.out.println("nombre d'enchere insérée"+nbreLigneInseree);//Debugi
	ResultSet rs=pStmt.getGeneratedKeys();
	if(rs.next()) {
		newEnchere.setNumero(rs.getInt(1));
	}
	
} catch (SQLException e) {
e.printStackTrace();
}
		return newEnchere;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public Enchere selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public Enchere selectByUtilisateurAcheteur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public Enchere selectByUtilisateurGagne(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public Enchere selectByArticleMeilleurOffre(Article article) {
		Enchere meilleureEnchere = new Enchere();
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pStmt= cnx.prepareStatement(REQ_SELECT_MEILLEURE_ENCHERE);
			Integer idArticle = article.getNumero();
			Integer meilleurOffre = article.getPrixVente();
			pStmt.setInt(1, idArticle);
			pStmt.setInt(2, meilleurOffre);
			ResultSet rs= pStmt.executeQuery();
			if(rs.next()) {
				meilleureEnchere = map(rs);
			}
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
				return meilleureEnchere;
	}

	/**
	 * Méthode en charge de
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private Enchere map(ResultSet rs) throws SQLException {
		//-----Debug sysout de récupération d'enchere
		String debug;
		debug = rs.getString(NUM_COL);
		System.out.println(debug);
		debug = rs.getString(DATE_ENCH_COL);
		System.out.println(debug);
		debug = rs.getString(MONTANT_COL);
		System.out.println(debug);
		debug = rs.getString(NUM_ARTICLE_COL);
		System.out.println(debug);
		debug = rs.getString(NUM_UTILISATEUR_COL);
		System.out.println(debug);
		//--- Fin debug sysout enchere
		Enchere enchereRetour = new Enchere(); 
		enchereRetour.setNumero(rs.getInt(NUM_COL));
		enchereRetour.setDate(LocalDateTime.parse(rs.getString(DATE_ENCH_COL), formatBDDVersJavaLocalDateTime));
		enchereRetour.setMontant(rs.getInt(MONTANT_COL));
		enchereRetour.setArticle(DaoFactory.getArticleDao().selectById(rs.getInt(NUM_ARTICLE_COL)));
		enchereRetour.setUtilisateur(DaoFactory.getUtilisateurDao().selectById(rs.getInt(NUM_UTILISATEUR_COL)));
		return enchereRetour;
	}

}
