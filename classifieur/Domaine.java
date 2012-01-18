package classifieur;

public abstract class Domaine {
	/**
	 * m�thodes
	 */
	public Domaine() {
		
	}
	
	abstract public boolean Inclus (Domaine d) throws BadDomainException;

}
