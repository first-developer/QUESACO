//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

public abstract class Domaine {

	// Methods
	// ========================================================
	public Domaine() {
	}
	
	abstract public boolean inclus (Domaine d) throws BadDomainException;

}
