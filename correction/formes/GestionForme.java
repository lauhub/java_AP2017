package fr.viacesi.pau.ap2017.formes;

import java.util.Scanner;

public class GestionForme {
	private Scanner scanner = new Scanner(System.in);
	private ListeForme liste = new ListeForme();
	
	public static void main(String[] args) {
		GestionForme gf = new GestionForme();
		gf.gererProgramme();
		
	}
	public static final int CHOIX_CREER_FORME = 1;
	public static final int CHOIX_AFFICHER_PERIMETRE = 3;
	public static final int CHOIX_AFFICHER_LISTE_FORMES = 4;
	
	public void gererProgramme(){
		int choix = -1;
		while(choix != 0){
			afficherMenu();
			choix = getValeur("Entrez votre choix:");
			switch(choix){
			case CHOIX_CREER_FORME:
				int typeForme = getTypeForme();
				Forme forme = creerForme(typeForme);
				liste.ajouter(forme);
				break;
			case CHOIX_AFFICHER_LISTE_FORMES:
				System.out.println(liste);
				break;
			case CHOIX_AFFICHER_PERIMETRE:
				int index = getValeur("Indiquer l'index de la forme");
				System.out.println(
						liste.getForme(index).getPerimetre());
				break;	
				
			}
		}
	}
	
	private Forme creerForme(int type){
		Forme forme ;
		switch(type){
		case 1: forme = new Triangle("triangle"); break;
		case 2: forme = new Carre("carre"); break;
		default: System.out.println("C'est une erreur"); return null;
		}
		forme.saisirValeurs();
		return forme;
	}
	
	public int getTypeForme(){
		System.out.println("Choisir le type de forme");
		System.out.println("1. Triangle");
		System.out.println("2. Carre");
		return getValeur("Entrez le type:");
	}
	
	public int getValeur(String message){
		System.out.println(message);
		return scanner.nextInt();
	}
	
	public void afficherMenu(){
		System.out.println("Gestion des formes");
		System.out.println("1. Créer une nouvelle forme");
		System.out.println("2. supprimer une forme");
		System.out.println("3. afficher le périmètre d'une forme");
		System.out.println("4. afficher la liste des formes");
		System.out.println("0. quitter le programme");
	}
	
	private void essai(){
		ListeForme liste = new ListeForme();
		
		Forme forme = new Carre("MachinRouge");
		liste.ajouter(forme);
		
		for (int i = 0; i < 6; i++) {
			liste.ajouter(new Carre("Carre-"+i, i+1));
		}
		liste.supprimerA(4);
		
		System.out.println(liste);
		System.out.println(
				liste.getForme(4).getPerimetre());		
	}

}
