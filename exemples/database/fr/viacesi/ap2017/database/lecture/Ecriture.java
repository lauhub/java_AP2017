package fr.viacesi.ap2017.database.lecture;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.viacesi.ap2017.database.ConnectionMySQL;
import fr.viacesi.ap2017.database.DateSimple;
import fr.viacesi.ap2017.database.Personne;
import fr.viacesi.ap2017.util.GestionMenu;

public class Ecriture {
	//INSERT INTO `personne`(`nom`, `prenom`, `dnaissance`) VALUES ('RABHI','Pierre','1938-05-29')
	
	public void remplir(ConnectionMySQL connecteur){
		//Nécessaire pour faire les insertions
		Statement stmt = null;
		try {
			connecteur.connect();
	        stmt = connecteur.getConnection().createStatement();
	        boolean continuer = true;
			while(continuer){
				String nom = GestionMenu.getInstance().getValeur("Entrez le nom:");
				String prenom = GestionMenu.getInstance().getValeur("Entrez le prénom:");
				DateSimple ds = null;
				while(ds == null){
					String date = GestionMenu.getInstance().getValeur("Entrez une date:");
					ds = DateSimple.checkDate(date);
				}
				inserer(stmt, nom, prenom, ds);
				String doitContinuer = GestionMenu.getInstance().getValeur("Continuer (o/n):");
				continuer = doitContinuer.equals("o");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if (stmt != null) { 
				try {
					stmt.close();
				} catch (SQLException e) {
					System.err.println("Erreur à la sortie");
					e.printStackTrace();
				}
			}
		}
	}

	
	public void changerDate(ConnectionMySQL connecteur){
		//Nécessaire pour faire les insertions
		Statement stmt = null;
		try {
			connecteur.connect();
	        stmt = connecteur.getConnection().createStatement();
	        boolean continuer = true;
			while(continuer){
				String nom = GestionMenu.getInstance().getValeur("Entrez le nom:");
				String prenom = GestionMenu.getInstance().getValeur("Entrez le prénom:");
				DateSimple ds = null;
				while(ds == null){
					String date = GestionMenu.getInstance().getValeur("Entrez une date:");
					ds = DateSimple.checkDate(date);
				}
				inserer(stmt, nom, prenom, ds);
				String doitContinuer = GestionMenu.getInstance().getValeur("Continuer (o/n):");
				continuer = doitContinuer.equals("o");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if (stmt != null) { 
				try {
					stmt.close();
				} catch (SQLException e) {
					System.err.println("Erreur à la sortie");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void inserer(Statement stmt, 
			String nom, String prenom, DateSimple date) throws SQLException{
		stmt.executeUpdate(
				"insert into personne " +
				"values('"+nom+"', '"+prenom+"', '"+date.getSqlRepresentation()+"')");
	}

	public static void main(String[] args) {
		try {
			ConnectionMySQL.init();			
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			System.err.println("La librairie n'est pas disponible");
			System.exit(5);
		} 
		
		
		//On peut continuer ici:
		ConnectionMySQL connecteur = new ConnectionMySQL("lamp.exemple.cesi", "demouser", "MotDePasse");
		Ecriture ins = new Ecriture();
		ins.remplir(connecteur);

	}
}
