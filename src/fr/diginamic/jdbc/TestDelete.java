package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// étape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// étape 1 : enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// étape 2 : création de la connection
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// étape 3 : requêtes
		Statement statement = connection.createStatement();

		// requêtes delete
		int nb = statement.executeUpdate("delete from fournisseur WHERE id=4 and nom = 'La Maison des Peintures'");
		statement.close();
		connection.close();
	}
}