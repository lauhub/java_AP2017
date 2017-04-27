
public class GestionEntiersNaturels {
	public static final int LONGUEUR_MAX = 5;
	private int[] tableau = new int[LONGUEUR_MAX];
	private int longueur = 0;
	
	public void ajouter(int entier)
				throws ArgumentInvalideException,
						TableauPleinException{
		if(entier >= 0){ //Entier naturel ?
			//J'ajoute un élément uniquement si
			//le tableau n'est pas plein
			if(longueur < LONGUEUR_MAX){
				tableau[longueur] = entier ; 
				longueur ++;
			} else {
				throw new TableauPleinException(
						"Le tableau est plein, videz-le "+
						"ou supprimez un élément !");
			}
		}else { //Ce n'est pas un entier naturel
			//throw new IllegalArgumentException(
			throw new ArgumentInvalideException(
			"Vous devez saisir un entier naturel: "+entier);
		}
	}
	
	public void supprimerDernier(){
		if(longueur > 0){
			supprimerVraimentLeDernier();
		}
	}
	
	private void supprimerVraimentLeDernier(){
		tableau[longueur - 1] = -1;
		longueur -- ;
	}
	
	public void vider(){
		while(longueur > 0){
			supprimerVraimentLeDernier();
		}
	}
	
	public void afficher(){
		System.out.println(toString());
	}
	
	public String toString(){
		String rep = "GestionEntiersNaturels[";
		for (int i = 0; i < longueur; i++) {
			rep += tableau[i]+ ", ";
		}
		rep += "]" ;	
		return rep;
	}
}
