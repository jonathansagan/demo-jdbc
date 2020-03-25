package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
				// �tape 0 - lecture fichier "db.properties"
				ResourceBundle db = ResourceBundle.getBundle("db");

				// �tape 1 : enregistrer le pilote
				Class.forName(db.getString("db.driver"));

				// �tape 2 : cr�ation de la connection
				Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
						db.getString("db.pass"));

				// �tape 3 : requ�tes
				Statement statement = connection.createStatement();
				
				// �tape 4 : select

		ResultSet resultSet = statement.executeQuery("select * from fournisseur");

		// fournisseurs dans une ArrayList
		ArrayList<Fournisseur> Listefournisseurs = new ArrayList<>();

		while (resultSet.next()) {
			Fournisseur fournisseur = new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom"));
			Listefournisseurs.add(fournisseur);
		}

		// affichage des fournisseurs
		for (Fournisseur fournisseur : Listefournisseurs) {
			System.out.println(fournisseur);
		}
		
		// �tape 5 : on ferme tout
		resultSet.close();
		statement.close();
		connection.close();
	}

}
