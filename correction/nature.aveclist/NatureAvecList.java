package fr.viacesi.pau.ap2017.nature.aveclist;

import fr.viacesi.pau.ap2017.nature.Fleur;

public class NatureAvecList implements ObservateurChamps {
	@Override
	public void champsModifie(Champs champs) {
		System.out.println("###DEBUT champs modifié ###");
		System.out.println("### "+champs);
		System.out.println("###FIN -------------- ###");
	}
	
	public static void main(String[] args) {
		NatureAvecList nature = new NatureAvecList();
		Champs champs = new Champs("de blé");
		champs.enregistrerObservateur(nature);
		champs.addObjet(new Fleur("Paquerette", 1));
		champs.addObjet(new Fleur("Jonquille", 2));
		
		ObservateurChamps autreObs = new UnAutreObservateur();
		champs.enregistrerObservateur(autreObs);
		
		champs.addObjet(new Fleur("Paquerette", 3));
		
		champs.setNom("herbe");
		
		champs.addObjet(new Fleur("Jonquille", 4));
		
	}
}
class UnAutreObservateur implements ObservateurChamps{
	@Override
	public void champsModifie(Champs champs) {
		System.out.println(">>> Autre observateur:"+champs);
	}
}

