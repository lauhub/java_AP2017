package fr.viacesi.ap2017.database;

public class DateSimple {
	private int jour; //Attribut d'instance
	private int mois;
	private int annee;
	
	public DateSimple(int jour /*paramètre*/, int mois, int annee){
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
     * 
     * Pour les mois de 30 j : jour <= 30
     * Pour les mois de 31 j : jour <= 31
     * 
     * Pour les mois de Février: 28 sauf année bissextile (29)
     * 
     * On rappelle que le mois de février 
     * compte 29 jours sauf si l'année est 
     * bissextile et qu'une année est bissextile 
     * si elle est divisible par 4 mais pas par 100 
     * (exception faite des années divisibles par 400,
     *  qui sont également bissextiles).
     * @return
     */
    public boolean estValide(){ // appelante/caller
    		if(moisValide()){
    			if(estMois30j()){
    				return jourComprisEntreUnEt(30);
    			} else if(estMoisFevrier()){
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
    public String getSqlRepresentation(){
    	StringBuilder sb = new StringBuilder(String.valueOf(annee));
    	sb.append("-").append(String.valueOf(mois)).append("-").append(String.valueOf(jour));
    	return sb.toString();
    }

    public static DateSimple checkDate(String date){
    	String[] dateItems = date.split("-");
    	
    	DateSimple d = new DateSimple(
    			Integer.parseInt(dateItems[0]),
    			Integer.parseInt(dateItems[1]),
    			Integer.parseInt(dateItems[2])
    			);
    	if(d.estValide()){
    		return d;
    	}
    	else{
    		return null;
    	}    			
    }
}
