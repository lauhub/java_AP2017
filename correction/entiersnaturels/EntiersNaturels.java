
public class EntiersNaturels {

	public static void main(String[] args) {
		GestionEntiersNaturels gen = new GestionEntiersNaturels();
		
		
		try {
			gen.ajouter(5);
			gen.ajouter(4);
			gen.ajouter(3);
			gen.ajouter(2);
			gen.supprimerDernier();
			gen.ajouter(1);
			gen.ajouter(8);
			gen.ajouter(7);
			gen.ajouter(6);
			gen.ajouter(10);
			gen.vider();
			gen.ajouter(11);
			gen.ajouter(12);
			gen.ajouter(-8);
		} catch (ArgumentInvalideException e) {
			System.err.println(e.getMessage());
		} catch (TableauPleinException e){
			System.err.println(e.getMessage());
		}
		
		
		gen.afficher();
	}

}
