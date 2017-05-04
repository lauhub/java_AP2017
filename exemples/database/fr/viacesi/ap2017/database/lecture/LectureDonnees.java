package fr.viacesi.ap2017.database.lecture;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.viacesi.ap2017.database.ConnectionMySQL;
import fr.viacesi.ap2017.database.Personne;
import fr.viacesi.ap2017.database.PersonneData;

public class LectureDonnees {
		
	public List<Personne> recupererDonnees(ConnectionMySQL connecteur) throws SQLException{
		List<Personne> personnes = new ArrayList<>();
		connecteur.connect();
		
		ResultSet resultats = connecteur.execute("SELECT * FROM personne");
		boolean contientDAutresDonnees = resultats.next();
		while (contientDAutresDonnees) {
			PersonneData p = new PersonneData();
			
			p.setNom(resultats.getString("nom"));
			p.setPrenom(resultats.getString("prenom"));
			//p.setDate(resultats.getDate("Nom"));
			
			java.sql.Date date = resultats.getDate("dnaissance");
			Date javaDate = new Date(date.getTime());
			p.setDateNaissance(javaDate);
			
			personnes.add(p);
			contientDAutresDonnees = resultats.next();
		}

		resultats.close();
		//Bonne pratique: fermer le connecteur
		connecteur.close();
		return personnes;
	}
	public static void main(java.lang.String[] args) {
		try {
			ConnectionMySQL.init();			
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			System.err.println("La librairie n'est pas disponible");
			System.exit(5);
		} 
		
		
		//On peut continuer ici:
		ConnectionMySQL connecteur = new ConnectionMySQL("lamp.exemple.cesi", "demouser", "MotDePasse");
		try {
			LectureDonnees ld = new LectureDonnees(); 
			List<Personne> lp = ld.recupererDonnees(connecteur);
			for (Personne personne : lp) {
				System.out.println(personne);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	
}
