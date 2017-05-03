package fr.viacesi.pau.ap2017.nature.aveclist;

import java.util.List;
import java.util.ArrayList;

public class Champs {
	@SuppressWarnings("rawtypes")
	private List mesObjets = new ArrayList();
	private List<ObservateurChamps> observateurs = new ArrayList<>();	
	private String nom;
	private StringBuffer buffer = new StringBuffer(128);
	
	public Champs(String nom){
		this.nom  = nom;
	}
	
	public void setNom(String nom){
		this.nom = nom;
		notifierObservateurs();
	}
	
	@SuppressWarnings("unchecked")
	public void addObjet(Object o){
		mesObjets.add(o);
		notifierObservateurs();
	}
	public String toStringAncienne(){
		String valeur = "Champ("+nom+") [";
		String chaineFleurs = "";
		
		for (Object o : mesObjets) {
			if(chaineFleurs.length() > 0){
				chaineFleurs += ", ";
			}
			chaineFleurs += o.toString() ;
		}
		return valeur + chaineFleurs + "]" ;
	}
	
	public String toString(){
		buffer.setLength(0);
		
		for (Object o : mesObjets) {
			if(buffer.length() > 0){
				buffer.append(", ") ;
			}
			buffer.append(o.toString()) ;
		}
		buffer.append("]");
		//J'ajoute au début
		buffer.insert(0, ") [")
			  .insert(0, nom)
			  .insert(0, "Champ(");
		
		//buffer.append(".").append(".").append(".");
		
		return buffer.toString() ;
	}
	
	public void enregistrerObservateur(ObservateurChamps obs){
		observateurs.add(obs);
		//observateurs[observateursCompteur] = obs;
	}
	public void oublierObservateur(ObservateurChamps obs){
		//...
		observateurs.remove(obs);
	}
	public void notifierObservateurs(){
		for (ObservateurChamps obs : observateurs) {
			//Pour chaque item (nommé obs de type ObservateurChamps)
			//de la liste observateurs 
			//je fais :
			obs.champsModifie(this);
		}
//		for (int i = 0; i < observateurs.length; i++) {
//			if(observateurs[i] != null){
//				observateurs[i].champsModifie(this);
//			}
//		}
	}
}
