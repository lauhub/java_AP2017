package fr.viacesi.ap2017.database;

import java.util.Date;

public class PersonneData implements Personne {
	private String nom, prenom;
	private Date dateNaissance ;
	
	public PersonneData(){
	}

	public String toString(){
		return new StringBuffer("Personne{Nom:")
				.append(nom).append(", Prenom:").append(prenom)
				.append(dateNaissance==null?"":", naissance:")
				.append(dateNaissance==null?"":dateNaissance.toString())
				.append("}").toString();
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrenom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDateNaissance() {
		// TODO Auto-generated method stub
		return null;
	}

}
