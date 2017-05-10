# Annexes: Références


## Comment utiliser la ligne de commande

[Chapitre 2 : notions de base](http://www.jmdoudoux.fr/java/dej/chap-techniques-base.htm)


## Comment utiliser la Javadoc

[Chapitre 88: Javadoc](https://www.jmdoudoux.fr/java/dej/chap-javadoc.htm)

Exemple de déclaration:

```java
/**
 * Permet de stocker et récupérer les informations sur une Personne.
 * 
 * @author lauhub
 *
 */
public class Personne {
	private String nom = null;
	private String prenom = null;
	
	/**
	 * Permet de créer une personne ayant un nom et un prénom
	 * @param nom le nom
	 * @param prenom le prénom
	 */
	public Personne (String nom, String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * Récupère le nom de la personne
	 * @return le nom de la personne
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Récupère le prénom de la personne
	 * @return le prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Récupère le nom et le prénom séparés par un espace
	 * @return la valeur composée de nom, " " et prénom: getNom()+" "+getPrenom()
	 */
	public String getNomPrenom(){
		return nom+" "+prenom;
	}
}

```

