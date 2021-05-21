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

import fr.eni.eboy.bll.UtilisateurManager;
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
<<<<<<< HEAD
=======
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String PRIX_VENTE_COL = "prix_vente";
>>>>>>> branch 'master' of https://github.com/EnchereEboy/projetTroc2021.git
	private static final String REQ_SELECT_BY_CAT_AND_NAME_AND_ACHETEUR = "SELECT * "
<<<<<<< HEAD
			+ "FROM ENCHERES e"
			+ "JOIN ARTICLES_VENDUS a ON e."+ NUM_COL +"=a."+NUM_COL+" "
=======
			+ "FROM ENCHERES e "
			+ "JOIN ARTICLES_VENDUS a ON e."+ NUM_ARTICLE_COL +"=a."+NUM_ARTICLE_COL+" "
>>>>>>> branch 'master' of https://github.com/EnchereEboy/projetTroc2021.git
			+ "WHERE "
<<<<<<< HEAD
			+ NUM_UTILISATEUR_COL + "=? "
			+ "AND " +  +"=0 "
=======
			+ "e."+NUM_UTILISATEUR_COL + "=? "
			+ "AND a." + NUM_CAT_COL +"=? "
>>>>>>> branch 'master' of https://github.com/EnchereEboy/projetTroc2021.git
			+ "AND LOWER(a."+ NOM_COL +") LIKE  ?";
	
	private static final String REQ_SELECT_BY_CAT_AND_NAME_AND_ACHETEUR_GAGNE = "SELECT * "
			+ "FROM ENCHERES e "
			+ "JOIN ARTICLES_VENDUS a ON e."+ NUM_ARTICLE_COL +"=a."+NUM_ARTICLE_COL+" "
			+ "WHERE "
			+ "a."+ETAT_VENTE_COL+"=1 "
			+ "AND e."+MONTANT_COL+"="+PRIX_VENTE_COL+" "
			+ "AND e."+NUM_UTILISATEUR_COL + "=? "
			+ "AND a." + NUM_CAT_COL +"=? "
			+ "AND LOWER(a."+ NOM_COL +") LIKE  ?";
//REQUETE POUR DEBUG
//	private static final String REQ_TEST = "SELECT * \r\n"
//			+ "FROM ENCHERES e\r\n"
//			+ "JOIN ARTICLES_VENDUS a ON e.no_article=a.no_article\r\n"
//			+ "WHERE\r\n"
//			+ "e.no_utilisateur =2\r\n"
//			+ "AND  a.no_categorie =3 \r\n"
//			+ "AND LOWER(a.nom_article ) LIKE  '%o%'";
//	
	 
	/**
	* {@inheritDoc}
	*/
	@Override
	public Enchere insertNewEnchere(Enchere newEnchere) {
try (Connection cnx = ConnectionProvider.getConnection()){
	PreparedStatement pStmt= cnx.prepareStatement(REQ_INSERT_ENCHERE, Statement.RETURN_GENERATED_KEYS);
	pStmt.setString(1, newEnchere.getDate().format(formatJourMoisAnneeHeureMinute)); 
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
			pStmt.setInt(1, utilisateur.getNumero());
			pStmt.setInt(2, cat.getNumero());
			pStmt.setString(3, "%" + recherche.toLowerCase().trim() + "%");
			ResultSet rs = pStmt.executeQuery();
//			Statement stmt=cnx.createStatement();
//			ResultSet rs=stmt.executeQuery(REQ_TEST);
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
	
	public List<Enchere> selectByUtilisateurAcheteurGagneByCatByName (Categorie cat, Utilisateur utilisateur, String recherche) {
	
		List<Enchere> listeEnchereUtilisateur = new ArrayList<Enchere>();
		try (Connection cnx =ConnectionProvider.getConnection()){
			PreparedStatement pStmt= cnx.prepareStatement(REQ_SELECT_BY_CAT_AND_NAME_AND_ACHETEUR_GAGNE);
			pStmt.setInt(1, utilisateur.getNumero());
			pStmt.setInt(2, cat.getNumero());
			pStmt.setString(3, "%" + recherche.toLowerCase().trim() + "%");
			ResultSet rs = pStmt.executeQuery();
//			Statement stmt=cnx.createStatement();
//			ResultSet rs=stmt.executeQuery(REQ_TEST);
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
	@Override
	public int enchereTransact (Enchere newEnchere ) {
		//on annule l'auto-commit (par défaut true avec JDBC)
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			 cnx.setAutoCommit(false);
			 
			  try { 
					 
					 UtilisateurManager utilisateurUpdate=new UtilisateurManager();
					 UtilisateurManager utilisateurUpdate1=new UtilisateurManager(); 
					 
					  utilisateurUpdate.crediter(newEnchere.getArticle().getNumero());
					  utilisateurUpdate1.debiter(newEnchere.getUtilisateur().getNumero(), newEnchere.getMontant());
					 insertNewEnchere(newEnchere);
						
					  
					
					 
					 cnx.commit(); 
			  }catch (Exception e) {
				  cnx.rollback();
				  e.printStackTrace();
				// TODO: handle exception
			}
			  
		}catch (Exception e) {
			 
			e.printStackTrace();
		}
		  
		
 	return 5;
	}
	
	

}