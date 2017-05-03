package fr.viacesi.pau.ap2017.nature.aveclist;

public interface ObservateurChamps {
	/**
	 * Appelé quand le champs passé en paramètre a été modifié
	 * @param champs
	 */
	public void champsModifie(Champs champs) ;
}
