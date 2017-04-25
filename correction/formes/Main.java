package fr.viacesi.pau.ap2017.formes;

public class Main {

	public static void main(String[] args) {
		Forme triangle = new Triangle("TriangleRouge");
		triangle.saisirValeurs();
		System.out.println(triangle+
				" Périmètre = " +triangle.getPerimetre());
		
		Forme carre = new Carre("CarreJaune");
		carre.saisirValeurs();
		System.out.println(carre+
				" Périmètre = " +carre.getPerimetre());
	}

}
