/**
 * 
 */
package fr.eni.eboy.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 

/**
 * @author SIDY
 *
 */

public class ConnectionProvider {

	private static DataSource dataSource;
	
	static {
		try {
			//Lecture du XML et récupération de la ressource
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
}
