package fr.viacesi.pau.ap2017.formes;

import java.util.Scanner;

public class Triangle extends Forme {
	private double coteAB, coteBC, coteCA;
	
	public Triangle(String nom) {
		super("Triangle", nom);
	}

	@Override
	public double getPerimetre() {
		return coteAB + coteBC + coteCA;
	}

	@Override
	public void saisirValeurs() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Longueur coté AB:");
		coteAB = in.nextDouble();
		System.out.println("Longueur coté BC:");
		coteBC = in.nextDouble();
		System.out.println("Longueur coté CA:");
		coteCA = in.nextDouble();
		in.close();
	}

}
