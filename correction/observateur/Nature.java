package fr.viacesi.pau.ap2017.nature;

public class Nature implements ObservateurChamps {
	private Champs champs ;
	Nature(){
		champs = new Champs();
		champs.enregistrerObservateur(this);
	}
	
	@Override
	public void champsModifie(Champs champs) {
		System.out.println("### Le champs a été modifié");
		System.out.println("### "+champs);
	}
	
	public static void main(String[] args) {
		Nature nature = new Nature();
		nature.champs.addObjet(new Fleur("Paquerette", 1));
		nature.champs.addObjet(new Fleur("Jonquille", 2));
		
		ObservateurChamps autreObs = new AutreObservateur();
		nature.champs.enregistrerObservateur(autreObs);
		
		nature.champs.addObjet(new Fleur("Paquerette", 3));
		nature.champs.addObjet(new Fleur("Jonquille", 4));
		
	}
}
class AutreObservateur implements ObservateurChamps{
	@Override
	public void champsModifie(Champs champs) {
		System.out.println(">>> Je suis un autre "
				+ "observateur et le champ a changé:"+champs);
	}
}

