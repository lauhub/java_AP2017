package fr.viacesi.ap2017.util;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GestionMenu {
	private Scanner scanner = new Scanner(System.in);
	
	private static GestionMenu instance = null;
	public static GestionMenu getInstance(){
		if(instance == null){
			instance = new GestionMenu();
		}
		return instance;
	}
	

	public String getValeur(String message){
		System.out.println(message);
		return  scanner.next();
	}	
	
	
	
	public int getValeurInt(String message){
		boolean valeurOK = false;
		int valeur = -1;
		while (!valeurOK){
			System.out.println(message);
			try{
				valeur =  scanner.nextInt();
				valeurOK = true;
			}catch(InputMismatchException e){
				System.out.println(
						"ERREUR: le nombre "+
						"doit être un entier");
				//Réinitialise le scanner
				scanner = new Scanner(System.in);
			}
		}
		return valeur;
	}	
	
	public double getValeurDouble(String message){
		boolean valeurOK = false;
		double valeur = -1;
		while (!valeurOK){
			System.out.println(message);
			try{
				valeur =  scanner.nextDouble();
				valeurOK = true;
			}catch(InputMismatchException e){
				System.out.println(
						"ERREUR: le nombre "+
						"doit être un double:"+
						" 1,6 par exemple");
				//Réinitialise le scanner
				scanner = new Scanner(System.in);
			}
		}
		return valeur;
	}	
}
