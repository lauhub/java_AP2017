package fr.viacesi.pau.ap2017.formes;

import java.util.Scanner;

public class Triangle extends Forme {
	private double coteAB, coteBC, coteCA;
	
	public Triangle(String nom) {
		super("Triangle", nom);
	}

	public Triangle(String nom, 
			double coteAB, 
			double coteBC, 
			double coteCA) {
		super("Triangle", nom);
		this.coteAB = coteAB;
		this.coteBC = coteBC;
		this.coteCA = coteCA;
	}

	public boolean estEquilateral(){
		return coteAB == coteBC && coteBC == coteCA;
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
	}
	public String getRepresentation(){
		return ">>>" + super.getRepresentation() ;
	}
}
