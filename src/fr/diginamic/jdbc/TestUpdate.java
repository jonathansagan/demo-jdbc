package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			// �tape 0 - lecture fichier "db.properties"
	        ResourceBundle db = ResourceBundle.getBundle("db");
	        
			// �tape 1 : enregistrer le pilote
	        Class.forName(db.getString("db.driver"));
			
	        // �tape 2 : cr�ation de la connection
	        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
			
	        // �tape 3 : requ�tes        
	        Statement statement= connection.createStatement();
	        
	        // requ�tes update 	       
	        int nb = statement.executeUpdate("UPDATE fournisseur SET nom='La Maison des Peintures' WHERE id=4");
	        statement.close();
			connection.close();

	}

}
