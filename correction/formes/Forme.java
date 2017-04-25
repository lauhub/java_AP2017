package fr.viacesi.pau.ap2017.formes;
public abstract class Forme {
	private String type ;
	private String nom ;
	
	public Forme(String type, String nom){
		this.type = type;
		this.nom = nom;
	}


	/** Renvoie le périmètre de la forme courante */
	public abstract double getPerimetre();

	/** Fonction qui pose des questions à l'utilisateur pour
    saisir les valeurs nécessaires aux calculs*/
	public abstract void saisirValeurs();

	public String getType(){
		return type;
	}
	public String getNom(){ 
		return nom;
	}
	/**
    Renvoie la concaténation du type et du nom.
    Ex: triangle/bermudes
	 */
	public String getRepresentation(){
		//...
		return null;
	}
}
