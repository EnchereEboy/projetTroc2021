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
import fr.eni.eboy.bo.Utilisateur;

/**
 * Classe en charge
 * @author tkervran2021
 * @version ProjetEncheresEboy - v1.0
 * @date 14 mai 2021 - 14:26:50
 */
public class ArticleDaoJdbcImpl implements ArticleDao {
	

	/**
	 * Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String NUM_CAT_COL = "no_categorie";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String NUM_UTIL_COL = "no_utilisateur";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String ETAT_VENTE_COL = "etat_vente";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String PRIX_VENTE_COL = "prix_vente";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String PRIX_INIT_COL = "prix_initial";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String DATE_FIN_COL = "date_fin_encheres";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String DATE_DEBUT_COL = "date_debut_encheres";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String DESC_COL = "description";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String NOM_COL = "nom_article";
	/**
	 *  Constante du nom de la colonne de BDD pour la table ARTICLE_VENDUS
	 */
	private static final String NUM_COL = "no_article";
	//Les constantes et les Statement préconcu pour SQL 
	private static final String REQ_INSERT="INSERT INTO ARTICLES_VENDUS ("
			+ NOM_COL + ","
			+ DESC_COL + ","
			+ DATE_DEBUT_COL +","
			+ DATE_FIN_COL + ","
			+ PRIX_INIT_COL+","
			+ PRIX_VENTE_COL+","
			+ NUM_UTIL_COL +","
			+ NUM_CAT_COL + ")" 
			+ "VALUES(? ,?, ?, ?, ?, ?, ?, ?)"; 

	
	
	private static final String REQ_SELECT_ALL_EN_COURS="SELECT *"
			+"FROM ARTICLES_VENDUS "
			+"WHERE etat_vente=0 ";

	private static final String REQ_SELECT_ALL="SELECT * "
			+"FROM ARTICLES_VENDUS ";
	
	private static final DateTimeFormatter formatJourMoisAnneeHeureMinute = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.S");
	private static final DateTimeFormatter formatBDDVersJavaLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
	//Ce format de java correspond à une String et non un LocalDateTime donc utiliser le : LocaDateTime.parse(TempsAParser, formatter); à la place
	//private static final DateTimeFormatter formatJavaLocalDateTimeVersBDD = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final String REQ_SELECT_BY_ID = "SELECT * "
			+ "FROM ARTICLES_VENDUS "
			+ "WHERE no_article=?";
	
//	private static final DateTimeFormatter formatJourMoisAnneeHeureMinute = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//	private static final String REQ_INSERT="INSERT INTO ARTICLES_VENDUS (nom_article,"
//			+ "description,"
//			+ "date_debut_encheres,"
//			+ "date_fin_encheres,"
//			+ "prix_initial,"
//			+ "prix_vente,"
//			+ "no_utilisateur,"
//			+ "no_categorie)" 
//			+ "VALUES(? ,?, ?, ?, ?, ?, ?, ?)"; 
	private static final String REQ_INSERT_RETRAIT="INSERT INTO RETRAITS (no_article , rue , code_postal , ville) VALUES(?, ?, ?, ?)";
	private static final String REQ_SELECT_BY_CAT_AND_NAME_AND_USER = "SELECT * "
			+ "FROM ARTICLES_VENDUS "
			+ "WHERE "
			+ NUM_CAT_COL + "=? "
			+ "AND " + NUM_UTIL_COL +"=? "
			+ "AND LOWER("+ NOM_COL +") LIKE  ?";
	private static final String REQ_SELECT_BY_CAT_AND_NAME_EN_COURS = "SELECT * "
			+ "FROM ARTICLES_VENDUS "
			+ "WHERE "
			+ NUM_CAT_COL + "=? "
			+ "AND " + ETAT_VENTE_COL +"=0 "
			+ "AND LOWER("+ NOM_COL +") LIKE  ?";
	
//	private static final String REQ_SELECTBYID="select nom_article,description,date_debut_encheres,"
//			+ "date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente\r\n"
//			+ "from ARTICLES_VENDUS where no_article=?";
//	
//	private static final String REQ_UPDATEBYID="update ARTICLES_VENDUS set nom_article=?, description=?, "
//			+ "date_debut_encheres=?,date_fin_encheres=?,prix_initial=?, prix_vente=?,no_categorie=? "
//			+ "  where no_article=?";
//	
	
	
	
	@Override
	public Article ajouter(Article articleAAjouter) { 
		try(Connection cnx=ConnectionProvider.getConnection()){
			  cnx.setAutoCommit(false);
	     if(articleAAjouter !=null) {
	    	 try {    
	    		     PreparedStatement pStmt= cnx.prepareStatement(REQ_INSERT, Statement.RETURN_GENERATED_KEYS);
					  pStmt.setString(1, articleAAjouter.getNom());
					  pStmt.setString(2, articleAAjouter.getDescription());
					  pStmt.setString(3, articleAAjouter.getDateDebutEncheres().format(formatJourMoisAnneeHeureMinute)) ;
					  pStmt.setString(4, articleAAjouter.getDateFinEncheres().format(formatJourMoisAnneeHeureMinute)) ; 
					  pStmt.setInt(5,articleAAjouter.getPrixInitial());
					  pStmt.setInt(6, articleAAjouter.getPrixVente());   
					  pStmt.setInt(7,articleAAjouter.getUtilisateur().getNumero());
					  pStmt.setInt(8, articleAAjouter.getCategorie().getNumero());
		//			  int nbreLigneInseree= pStmt.executeUpdate();
					   pStmt.executeUpdate();
					   ResultSet rs=pStmt.getGeneratedKeys();
					   if(rs.next()) {
							articleAAjouter.setNumero(rs.getInt(1));
					   }
					   //System.err.println(articleAAjouter.getLieuRetrait().getRue());
					   //System.err.println(articleAAjouter.getLieuRetrait());
					   
					 if(articleAAjouter.getLieuRetrait().getRue()!=null) {
						 System.out.println("ajout de l'adresse");
						 PreparedStatement pStmtRetrait=cnx.prepareStatement(REQ_INSERT_RETRAIT);
						 pStmtRetrait.setInt(1, articleAAjouter.getNumero());
						 pStmtRetrait.setString(2, articleAAjouter.getLieuRetrait().getRue());
						 pStmtRetrait.setString(3, articleAAjouter.getLieuRetrait().getCodePostal());
						 pStmtRetrait.setString(4, articleAAjouter.getLieuRetrait().getVille());
						 pStmtRetrait.executeUpdate() ;			
						 }else {
							 System.out.println("Adresse non ajouter");
                          }
					   
				cnx.commit();
		     }catch (SQLException e) {
		    	 cnx.rollback();
		    	 e.printStackTrace();
			 }
		 } 	
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		System.out.println("affichage de l'article ajouté");
		System.out.println(articleAAjouter);
		
		return articleAAjouter;
	}




	@Override
	public Article insert(Article articleAAjouter) {
		try(Connection cnx=ConnectionProvider.getConnection()){
			PreparedStatement pStmt= cnx.prepareStatement(REQ_INSERT, Statement.RETURN_GENERATED_KEYS);
			  pStmt.setString(1, articleAAjouter.getNom());
			  pStmt.setString(2, articleAAjouter.getDescription());
			  pStmt.setString(3, articleAAjouter.getDateDebutEncheres().format(formatJourMoisAnneeHeureMinute));
			  pStmt.setString(4, articleAAjouter.getDateFinEncheres().format(formatJourMoisAnneeHeureMinute));
			  pStmt.setInt(5,articleAAjouter.getPrixInitial());
			  pStmt.setInt(6, articleAAjouter.getPrixVente());
			  pStmt.setInt(7,articleAAjouter.getUtilisateur().getNumero());
			  pStmt.setInt(8, articleAAjouter.getCategorie().getNumero());
			int nbreLigneInseree= pStmt.executeUpdate();
			System.out.println("nombre d'Article inséré"+nbreLigneInseree); //Debug pour voir le nombre d'insertion
			ResultSet rs=pStmt.getGeneratedKeys();
			if(rs.next()) {
				articleAAjouter.setNumero(rs.getInt(1));
			}
			
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return articleAAjouter;
	}

	
	
	
	@Override
	public List<Article> selectAllEnCours() {
		List<Article> listeArticlesARetourner = new ArrayList<Article>();
		try (Connection cnx =ConnectionProvider.getConnection()){
			Statement stmt= cnx.createStatement();
			ResultSet rs = stmt.executeQuery(REQ_SELECT_ALL_EN_COURS);
			while(rs.next()) {
				listeArticlesARetourner.add(map(rs));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticlesARetourner;
	}

	
	
	
	
	@Override
	public boolean delete(Integer id) {
		// TODO  itération 2 pour supprimer un article
		return false;
	}

	@Override
	public boolean update(Article article) {
		boolean reussiteUpdate = false;
		// TODO itération 2 pour modifier un article
		return reussiteUpdate;
	}

	
	@Override
	public List<Article> selectByCategorieAndNameEnCours(Categorie cat, String recherche) {

		List<Article> listeArticlesARetourner = new ArrayList<Article>();
		try (Connection cnx =ConnectionProvider.getConnection()){
			PreparedStatement pStmt= cnx.prepareStatement(REQ_SELECT_BY_CAT_AND_NAME_EN_COURS);
			pStmt.setInt(1, cat.getNumero());
			pStmt.setString(2, "%" + recherche.toLowerCase().trim() + "%");
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				listeArticlesARetourner.add(map(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticlesARetourner;
	}
	
	@Override
	public List<Article> selectByCategorieAndNameAndUtilisateur(Categorie cat, String recherche, Integer idUtilisateur) {

		List<Article> listeArticlesARetourner = new ArrayList<Article>();
		try (Connection cnx =ConnectionProvider.getConnection()){
			PreparedStatement pStmt= cnx.prepareStatement(REQ_SELECT_BY_CAT_AND_NAME_AND_USER);
			pStmt.setInt(1, cat.getNumero());
			pStmt.setInt(2, idUtilisateur);
			pStmt.setString(3, "%" + recherche.toLowerCase().trim() + "%");
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				listeArticlesARetourner.add(map(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticlesARetourner;
	}

	

	@Override
	public List<Article> selectByCategorieAndNameAndUtilisateurGagnee(Categorie cat, String recherche,
			Integer idUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectAll() {
		
		List<Article> listeArticlesARetourner = new ArrayList<Article>();
		try (Connection cnx =ConnectionProvider.getConnection()){
			Statement stmt= cnx.createStatement();
			ResultSet rs = stmt.executeQuery(REQ_SELECT_ALL);
			while(rs.next()) {
				listeArticlesARetourner.add(map(rs));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticlesARetourner;
		
	}




	/**
	* {@inheritDoc}
	*/
	@Override
	public Article selectById(Integer idArticle) {

		Article article = new Article();
		try (Connection cnx =ConnectionProvider.getConnection()){
			PreparedStatement pStmt= cnx.prepareStatement(REQ_SELECT_BY_ID);
			pStmt.setInt(1, idArticle);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				article = map(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}


	
	
	private Article map(ResultSet rs) throws SQLException{
		//---- Debut debug sysout
		String debug;
		debug = rs.getString(NUM_COL);
		System.out.println(debug);
		debug = rs.getString(NOM_COL);
		System.out.println(debug);
		debug = rs.getString(DESC_COL);
		System.out.println(debug);
		debug = rs.getString(DATE_DEBUT_COL);
		System.out.println(debug);
		debug = rs.getString(DATE_FIN_COL);
		System.out.println(debug);
		debug = rs.getString(PRIX_INIT_COL);
		System.out.println(debug);
		debug = rs.getString(PRIX_VENTE_COL);
		System.out.println(debug);
		debug = rs.getString(NUM_UTIL_COL);
		System.out.println(debug);
		debug = rs.getString(NUM_CAT_COL);
		System.out.println(debug);
		debug = rs.getString(ETAT_VENTE_COL);
		System.out.println(debug);
		///----Fin debug sysout
		Integer id = rs.getInt(NUM_COL);
		String nom = rs.getString(NOM_COL);
		String description = rs.getString(DESC_COL);
		LocalDateTime dateDebutEncheres = LocalDateTime.parse(rs.getString(DATE_DEBUT_COL), formatBDDVersJavaLocalDateTime);
		LocalDateTime dateFinEncheres = LocalDateTime.parse(rs.getString(DATE_FIN_COL), formatBDDVersJavaLocalDateTime);
		Integer prixInitial = rs.getInt(PRIX_INIT_COL);
		Integer prixVente = rs.getInt(PRIX_VENTE_COL);
		boolean etatVente = rs.getBoolean(ETAT_VENTE_COL);
		Integer idUtilisateur = rs.getInt(NUM_UTIL_COL);
		Utilisateur utilisateur = DaoFactory.getUtilisateurDao().selectById(idUtilisateur);
		Integer idCategorie = rs.getInt(NUM_CAT_COL);
		Categorie categorie = DaoFactory.getCategorieDao().selectById(idCategorie);
		//java.sql.Date.valueOf(articleAAjouter.getDate_debut_encheres().format(formatJourMoisAnneeHeureMinute))
		return new Article(id, nom, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, etatVente, utilisateur, categorie);
	}
	
}
