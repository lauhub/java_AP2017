package fr.viacesi.pau.ap2017.date;

public class Date {
	private int jour; //Attribut d'instance
	private int mois;
	private int annee;
	
	public Date(int jour /*paramètre*/, int mois, int annee){
		this.jour = jour; 	//this.jour : l'attribut de l'instance
							//jour : paramètre
		this.mois = mois;
		this.annee = annee;
	}
    public void setJour(int jour){
    		this.jour = jour;
    }
    public void setMois(int mois){ }
    public void setAnnee(int annee){ }
    
    public boolean estValide(){
    		if (jour > 31) {
    			return false;
    		} else if (mois > 12 || mois < 1) {
    			return false;
    		} else{
    			return true;
    		}
    }
    public String getRepresentation(){
    		return jour+"/"+mois+"/"+annee;
    }

}
