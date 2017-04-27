package fr.viacesi.autoradio;

public interface LectureCD {
	/**
	 * Lit le CD dans l'autoradio.
	 * 
	 * Si aucun CD n'est présent, 
	 * reste sur l'état 'pause'
	 */
	public void lire();
	
	/**
	 * Met le CD en pause
	 */
	public void pause();
	
	/**
	 * Passe à la prochaine piste.
	 */
	public void prochainePiste();
	
	/**
	 * Passe à la piste précédente.
	 */
	public void pistePrecedente();
	
	/**
	 * Ejecte le CD
	 */
	public void ejecter();
}
