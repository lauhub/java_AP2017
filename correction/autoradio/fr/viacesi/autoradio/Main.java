package fr.viacesi.autoradio;

public class Main {

	public static void main(String[] args) {
		GestionMenu gm = new GestionMenu();
		Autoradio autoradio = new Autoradio();
		gm.setAutoradio(autoradio);
		gm.gererAutoradio();
	}

}
