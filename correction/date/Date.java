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
    public void setJour(int jour){this.jour = jour;}
    public void setMois(int mois){this.mois = mois; }
    public void setAnnee(int annee){this.annee = annee; }
    
    private boolean estMois30j(){
    		return 	mois == 4 || mois == 6 ||
    				mois == 9 || mois == 11;
    }
    private boolean jourComprisEntreUnEt(int jourMax){
    		return jour >=1 && jour <= jourMax;
    }
    private boolean moisValide(){
    		return mois <= 12 && mois >= 1;
    }
    private boolean estMoisFevrier(){
    		return mois == 2;
    }
    private boolean estAnneeBissextile(){
    		return (annee % 4 == 0 && annee % 100 != 0) || 
    				annee % 400 == 0;
    		/*
    		 * if(annee % 4 == 0 ){ //Tautologie
    		 * 		if(annee % 100 != 0){
    		 * 			return true;
    		 * 		}else {
    		 * 			return false;
    		 * 		}
    		 * } else {
    		 * 		if (annee % 400 == 0){
    		 * 			return true;
    		 * 		} else {
    		 * 			return false;
    		 * 		}
    		 * }
    		 * 
    		 */
    }
    /**
     * Indique si la date est valide
     * @return
     */
    public boolean estValide(){ // appelante/caller
    		if(moisValide()){
    			if(estMois30j()){
    				return jourComprisEntreUnEt(30);
    			}else if(estMoisFevrier()){
    				//Dépend de l'année bissextile ou non
    				if(estAnneeBissextile()){ //appelée/callee
    					return jourComprisEntreUnEt(29);
    				}else {
    					return jourComprisEntreUnEt(28);
    				}
    			}
    			else{ // Mois de 31j
    				return jourComprisEntreUnEt(31);
    			}
    		}
    		else{
    			return false;
    		}
    }
    public String getRepresentation(){
    		return jour+"/"+mois+"/"+annee;
    }

}
