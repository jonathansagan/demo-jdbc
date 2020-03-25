import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// �tape 0 - lecture fichier "db.properties"
        ResourceBundle db = ResourceBundle.getBundle("db");
        
		// �tape 1 : enregistrer le pilote
        Class.forName(db.getString("db.driver"));
		
        // �tape 2 : cr�ation de la connection
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
		
        // �tape 3 : requ�tes
        
        Statement statement= connection.createStatement();
        
        // v�rification via un syso
        boolean verif = connection.isValid(800);
        if (verif==true) {
        	System.out.println("�a marche");
        }else {
        	System.out.println("�a plante");
        }
        
        connection.close();
	}

}
