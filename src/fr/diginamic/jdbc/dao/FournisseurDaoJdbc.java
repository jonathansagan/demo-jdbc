package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	@Override
	public List<Fournisseur> extraire() throws ClassNotFoundException, SQLException {
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

		ResultSet lecture = statement.executeQuery("select * from fournisseur");

// fournisseurs dans une ArrayList
		ArrayList<Fournisseur> Listefournisseurs = new ArrayList<>();

		while (lecture.next()) {
			Fournisseur fournisseur = new Fournisseur(lecture.getInt("id"), lecture.getString("nom"));
			Listefournisseurs.add(fournisseur);
		}

// �tape 5 : on ferme tout
		lecture.close();
		statement.close();
		connection.close();
		return Listefournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws ClassNotFoundException, SQLException {
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// �tape 1 : enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// �tape 2 : cr�ation de la connection
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// �tape 3 : requ�tes
		Statement statement = connection.createStatement();

		// requ�tes insert
		int ajout = statement.executeUpdate("insert into fournisseur(id,nom) values(" + fournisseur.getId() + ", '" + fournisseur.getNom()+ "')");
		statement.close();
		connection.close();
	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws ClassNotFoundException, SQLException {
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// �tape 1 : enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// �tape 2 : cr�ation de la connection
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// �tape 3 : requ�tes
		Statement statement = connection.createStatement();

		// requ�tes update
		int update = statement.executeUpdate("UPDATE fournisseur " + "SET nom =  '" + nouveauNom
				+ "' " + "WHERE nom = '" + ancienNom + "'");
		statement.close();
		connection.close();
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException, ClassNotFoundException {
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// �tape 1 : enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// �tape 2 : cr�ation de la connection
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// �tape 3 : requ�tes
		Statement statement = connection.createStatement();

		// requ�tes delete
		int delete = statement.executeUpdate("DELETE FROM fournisseur " + "WHERE fournisseur.nom = '" + fournisseur.getNom() + "'");
		statement.close();
		connection.close();
		return false;
	}

}
