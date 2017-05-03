package fr.viacesi.pau.ap2017.nature;

import java.util.List;
import java.util.ArrayList;

public class Champs {
	@SuppressWarnings("rawtypes")
	private List mesObjets = new ArrayList();
	private ObservateurChamps[] observateurs = new ObservateurChamps[10];
	private int observateursCompteur = 0;
	
	
	@SuppressWarnings("unchecked")
	public void addObjet(Object o){
		mesObjets.add(o);
		notifierObservateurs();
	}
	
	public String toString(){
		String valeur = "Champ [";
		for (Object o : mesObjets) {
			valeur += o.toString();
		}
		return valeur +"]" ;
	}
	
	public void enregistrerObservateur(ObservateurChamps obs){
		observateursCompteur++;
		observateurs[observateursCompteur] = obs;
	}
	public void oublierObservateur(ObservateurChamps obs){
		//...
	}
	public void notifierObservateurs(){
		for (int i = 0; i < observateurs.length; i++) {
			if(observateurs[i] != null){
				observateurs[i].champsModifie(this);
			}
		}
	}
}
