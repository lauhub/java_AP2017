package fr.viacesi.pau.ap2017.date;

import java.util.Scanner;
/**
 * La classe ValiditeDate
 * @author lauhub
 */
public class ValiditeDate {
	/* Attributs */
	private Scanner scanner = new Scanner(System.in);
	private boolean doitSortir = false ;
	/* méthodes */
	/**
	 * Permet d'afficher le menu
	 */
	public void afficherMenu(){
		System.out.println("Choisissez l'action à réaliser:");
		System.out.println("1. créer une date");
		System.out.println("0. sortir du programme");
	}
	/**
	 * Demande à l'utilisateur d'entrer une valeur
	 * @return la valeur saisie
	 */
	public int demanderChoix(){
		int choix = scanner.nextInt();
		if(choix == 0) {
			doitSortir = true;
		}
		return choix;
	}
	public boolean jeDoisSortir(){
		return doitSortir;
	}
	
}
