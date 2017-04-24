package fr.viacesi.pau.ap2017.date;

public class Main {
	/* Méthode main */
	public static void main(String[] args) {
		ValiditeDate vd = new ValiditeDate();
		
		while(!vd.jeDoisSortir()){
			vd.afficherMenu();
			int choix = vd.demanderChoix();
			//Réalise une action en fonction du choix		
		}
		
		System.out.println("Au revoir");
	}

}
