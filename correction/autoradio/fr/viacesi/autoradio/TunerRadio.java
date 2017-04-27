package fr.viacesi.autoradio;

public interface TunerRadio {
	public void chercherFrequenceHaut();
	public void chercherFrequenceBas();
	public void diminuerFrequence(float nbHertz);
	public void augmenterFrequence(float nbHertz);
	/**
	 * Mémorise la fréquence dans l'emplacement mémoire
	 * donné en paramètre
	 * La valeur maximale dépend de l'autoradio
	 * @param emplacementMemoire
	 */
	public void memoriserFrequence(int emplacementMemoire);
	/**
	 * Restaure la fréquence de l'emplacement mémoire
	 * donné en paramètre
	 * @param emplacementMemoire
	 */
	public void restaurerFrequence(int emplacementMemoire);
	
}
