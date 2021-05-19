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
import java.util.ArrayList;
import java.util.List;

import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Categorie;
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
	private static final String ETAT_VENTE_COL = "etat_vente";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String NOM_COL = "nom_article";
	/**
	 * Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String NUM_CAT_COL = "no_categorie";
	private static final String REQ_SELECT_BY_CAT_AND_NAME_AND_ACHETEUR = "SELECT * "
			+ "FROM ENCHERES e"
			+ "JOIN ARTICLES_VENDUS a ON e."+ NUM_COL +"=a."+NUM_COL+" "
			+ "WHERE "
			+ NUM_UTILISATEUR_COL + "=? "
			+ "AND " +  +"=0 "
			+ "AND LOWER(a."+ NOM_COL +") LIKE  ?";
	
	
	
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
	public List<Enchere> selectByUtilisateurAcheteurByCatByName(Categorie cat, Utilisateur utilisateur, String recherche) {

		List<Enchere> listeEnchereUtilisateur = new ArrayList<Enchere>();
		try (Connection cnx =ConnectionProvider.getConnection()){
			PreparedStatement pStmt= cnx.prepareStatement(REQ_SELECT_BY_CAT_AND_NAME_AND_ACHETEUR);
			pStmt.setInt(1, cat.getNumero());
			pStmt.setInt(2, utilisateur.getNumero());
			pStmt.setString(3, "%" + recherche.toLowerCase().trim() + "%");
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				listeEnchereUtilisateur.add(map(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeEnchereUtilisateur;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public List<Enchere> selectByUtilisateurGagne(Utilisateur utilisateur) {
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

	/**
	* {@inheritDoc}
	*/
	@Override
	public boolean deleteById(Integer idEnchere) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public Enchere selectById(Integer idEnchere) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public List<Enchere> selectByUtilisateurAcheteur(Utilisateur utilisateur, String rechereche) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
