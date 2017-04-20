
class StyloSansSousClasse {
	public static void main(String[] args) {
		NouveauStylo stylo = new NouveauStylo("");
		stylo.ecrire("Bonjour");

		NouveauStylo styloBleu = new NouveauStylo("BLEU");
		styloBleu.ecrire("Bonjour");
		stylo.ecrire("Au revoir");
		styloBleu.ecrire("Au revoir");
	}
}

class NouveauStylo{
	private String couleur = ""; //attribut

	NouveauStylo(String coul){ //Constructeur
		couleur = coul;
	}

	public void ecrire(String message){ //méthode
		if(couleur.equals("")){
			System.out.println(message);
		}
		else{
			System.out.println("ECRIRE_EN_"+couleur+"{"+
					message+"}");
		}
	}
}
