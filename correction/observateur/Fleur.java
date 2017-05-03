package fr.viacesi.pau.ap2017.nature;

public class Fleur {
	private String nom ;
	private int identifiant ;
	
	public Fleur(String nom, int identifiant){
		this.nom = nom;
		this.identifiant = identifiant ;
	}
	public String toString(){
		return nom+"("+identifiant+")" ;
	}
}
