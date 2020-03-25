package fr.diginamic.jdbc.dao;

import java.sql.SQLException;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Ajout du fournisseur

		Fournisseur fournisseur = new Fournisseur(5, "L''Espace Création");

		FournisseurDao newFouDao = new FournisseurDaoJdbc();
		newFouDao.insert(fournisseur);

		// Affichage de la liste des fournisseurs
		System.out.println("Après ajout, la nouvelle liste des fournisseurs est :" + newFouDao.extraire());

		// Modification du nom du fournisseur
		newFouDao.update("L''Espace Création", "Lespace creation");

		// Affichage de la liste des fournisseurs
		System.out.println("Après modifications, la liste des Fournisseurs est : " + newFouDao.extraire());

		// Suppression du dernier fournisseur ajouté.
		newFouDao.delete(fournisseur);

		// Affichage de la liste des fournisseurs apres suppression
		System.out.println(" La Liste des Fournisseurs apres suppression est :");
		System.out.println(newFouDao.extraire());

	}
}
