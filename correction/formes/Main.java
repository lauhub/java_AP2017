package fr.viacesi.pau.ap2017.formes;

public class Main {

	public static void main(String[] args) {
		Forme triangle = new Triangle("TriangleRouge");
		triangle.saisirValeurs();
		
		if (triangle instanceof Triangle){
			System.out.println( //cast ou trans-typage
					((Triangle)triangle).estEquilateral());
		}
		
		System.out.println(triangle +
				" Périmètre = " +triangle.getPerimetre());
		
		Forme carre = new Carre("TrucJaune");
		carre.saisirValeurs();
		
		if (carre.getType().equals("Triangle")){
			System.out.println( //cast ou trans-typage
				((Triangle)carre).estEquilateral());
		}
		
		System.out.println(carre+
				" Périmètre = " +carre.getPerimetre());
		System.out.println(carre.getNom());
	}

}
