package fr.viacesi.pau.ap2017.formes;

public class ListeForme {
	private Forme[] formes = new Forme[10];
	private int longueur = 0;
	
	public void ajouter(Forme forme){
		if(longueur == formes.length){
			Forme[] nouveauTab = 
					new Forme[formes.length + 10];
			//Copie du tableau
			for (int i = 0; i < formes.length; i++) {
				nouveauTab[i] = formes[i];
			}
			formes = nouveauTab ;
		}
		formes[longueur] = forme;
		longueur ++;
	}
	public int getLongueur(){
		return longueur;
	}
	public Forme getForme(int index){
		return formes[index];
	}
	public void supprimerA(int index){
		formes[index] = null;
		int dernierIndex = longueur - 1;
		for (int i = index; i < dernierIndex; i++) {
			formes[i] = formes[i+1];
		}
		formes[dernierIndex] = null;
		longueur --;
	}
	public String toString(){
		String representation = "ListeForme[";
		for (int i = 0; i < longueur; i++) {
			representation += formes[i] + ", " ;
		}
		representation += "]";
		return representation;
	}
}

