package fr.eni.eboy.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.eboy.bo.Categorie;

public class CategorieDaoJdbcImpl implements CategorieDao {

	private static final String SELECT_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie=? ";
	
	private Categorie categorie = new Categorie();
	@Override
	public Categorie selectById(Integer id) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ID);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				categorie.setNumero(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categorie;
	}

}
