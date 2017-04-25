package fr.viacesi.pau.ap2017.formes;

import java.util.Scanner;

public class Carre extends Forme {
	private double cote;
	public Carre(String nom) {
		super("Carre", nom);
	}

	@Override
	public double getPerimetre() {
		return 4 * cote;
	}

	@Override
	public void saisirValeurs() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Longueur coté :");
		cote = in.nextDouble();
		
		in.close();	
	}
}
