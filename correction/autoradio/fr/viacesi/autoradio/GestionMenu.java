package fr.viacesi.autoradio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionMenu {
	private Scanner scanner = new Scanner(System.in);
	
	private static GestionMenu monInstance = null;
	private Autoradio autoradio;
	
	public void setAutoradio(Autoradio autoradio){
		this.autoradio = autoradio;
	}
	
	private boolean continuer = true;
	public void gererAutoradio(){
		
		while(continuer){
			System.out.println(autoradio.getMenu());
			gererAppuiBouton();
		}
	}
	
	private void gererAppuiBouton(){
		String valeur = getValeur("Entrez votre choix:")
				.toUpperCase(); //On met en majuscule pour que 
		//les minuscules soient aussi prises en compte
		
		if(autoradio.estAllume()){
			switch(valeur){
			case "A": autoradio.augmenterVolume(); break ;
			case "D": autoradio.diminuerVolume(); break ;
			case "O": autoradio.eteindre(); break;
			case "C": autoradio.setMode(ModeAutoradio.CD); break;
			case "R": autoradio.setMode(ModeAutoradio.TUNER); break;
			}
		}else{
			switch(valeur){
			case "O": autoradio.allumer(); break ;
			case "Q": continuer = false; break ;
			}
		}
		
	}
	
	public String getValeur(String message){
		System.out.println(message);
		return scanner.next();
	}
	
	public int getValeurInt(String message){
		System.out.println(message);
		return scanner.nextInt();
	}
	

	public static GestionMenu getInstance(){
		if(monInstance == null) {
			monInstance = new GestionMenu();
		}
		return monInstance ;
	}
}

