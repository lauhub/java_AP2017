package fr.viacesi.pau.ap2017.formes;

public class GestionForme {

	public static void main(String[] args) {
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
