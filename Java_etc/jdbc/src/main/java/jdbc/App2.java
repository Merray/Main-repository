package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App2 {

	public static void main(String[] args) throws Exception {
		// A faire une fois
		// Charger les drivers
		
		Class.forName("org.postgresql.Driver");
		
		
		// Récupérer une connexion
		
		Connection connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/maBase", "postgres", "admin");
		
		// Récupérer un objet pour lancer des instructions
		
		Statement st = connexion.createStatement();
		
		
		// N'IMPORTE QUELLE REQUETTE SAUF SELECT
		
//		 st.executeUpdate("truncate table adherent");
//		 st.executeUpdate("insert into adherent ( num_adherent, prenom, nom) values (nextval('seq_adherent') , 'Jimmy', 'DESBOIS')");
		
		
		// UN SELECT
		
		ResultSet rs =st.executeQuery("select * from adherent");
		
		
		
		while (rs.next()) {
			
			System.out.println(rs.getInt("num_adherent") + " " + rs.getString("prenom") + " " + rs.getString("nom"));
			
		}
		
		String chaine = "Jimmy";
		
		PreparedStatement ps = connexion.prepareStatement("select * from adherent where prenom like ?");
		
		ps.setString(1, chaine); // Tous les caractères spéciaux de SQL sont échappés donc pas d'injection et pas de pb de securité
		
		rs =ps.executeQuery();
		
		while (rs.next()) {
			
			System.out.println(rs.getInt("num_adherent") + " " + rs.getString("prenom") + " " + rs.getString("nom"));
			
		}
		
		
		//Fermeture de la connexion

		connexion.close();
		
		
	}

}
