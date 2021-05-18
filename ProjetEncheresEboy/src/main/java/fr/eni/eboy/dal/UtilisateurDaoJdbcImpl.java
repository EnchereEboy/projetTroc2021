package fr.eni.eboy.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.eboy.bo.Utilisateur;

public class UtilisateurDaoJdbcImpl implements UtilisateurDao {
	private static final String SELECT_BY_PSEUDO = "SELECT * FROM Utilisateurs WHERE pseudo=?";
	private static final String SELECT_BY_ID = "SELECT * FROM Utilisateurs WHERE no_utilisateur=?";
	private static final String UPDATE_USER = "UPDATE Utilisateurs SET pseudo=?,nom=?,prenom=?,email=?"
			+ ",telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?"
			+ " WHERE no_utilisateur=?";
	private final static String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS(pseudo,nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit,administrateur) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
	private final static String SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE (pseudo=? OR email=?) and mot_de_passe=?";
	
	private Utilisateur utilisateur = new Utilisateur();
	
	@Override
	public Utilisateur insertConnection(String pseudoOuEmail, String password) {
		Utilisateur utilisateur = new Utilisateur(); 
		try(Connection cnxpageConnection = ConnectionProvider.getConnection()){
			
			PreparedStatement pStmtConnection = cnxpageConnection.prepareStatement(SELECT_UTILISATEUR);
			pStmtConnection.setString(1, pseudoOuEmail);
			pStmtConnection.setString(2, pseudoOuEmail);
			pStmtConnection.setString(3, password);
			//Récupération du résultat de SELECT_UTILISATEUR
			ResultSet rsConnection = pStmtConnection.executeQuery();
			
			//Parcours le rsConnection afin de récupérer les données
			while (rsConnection.next()) {
			 
				utilisateur.setNumero(rsConnection.getInt(1));
				utilisateur.setPseudo(rsConnection.getString(2)); 
				utilisateur.setNom(rsConnection.getString(3));
				utilisateur.setPrenom(rsConnection.getString(4));
				utilisateur.setEmail(rsConnection.getString(5));
				utilisateur.setTelephone(rsConnection.getString(6));
				utilisateur.setRue(rsConnection.getString(7));
				utilisateur.setCodePostal(rsConnection.getString(8));
				utilisateur.setVille(rsConnection.getString(9));
				
				utilisateur.setCredit(rsConnection.getInt(11));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	@Override
	public Utilisateur insert(Utilisateur utilisateur) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, 100);
			pStmt.setBoolean (11, false);
			//J'exécute
			int nbreInsert=pStmt.executeUpdate();
			System.out.println(nbreInsert);
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				utilisateur.setNumero(rs.getInt(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		return utilisateur;
	}
	
	@Override
	public Utilisateur selectByPseudo(String pseudo) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pStmt.setString(1, pseudo);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				utilisateur.setNumero(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return utilisateur;
	}

	@Override
	public Utilisateur selectById(Integer numero) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ID);
			pStmt.setInt(1, numero);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				utilisateur.setNumero(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return utilisateur;
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_USER);
			
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getNumero());
			
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
