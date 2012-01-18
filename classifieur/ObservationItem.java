//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

// Class: ObservationItem 
// ========================================================
public abstract class ObservationItem {

	// Attributes
	// ========================================================
	private String caractName;
	
	// Constructor
	// ========================================================
	public ObservationItem() {
		
	}
	
	// Methods
	// ========================================================
	// hasValueIn
	abstract public boolean hasValueIn (Domaine d) throws BadDomainException;

	// getCaractName
	public String getCaractName() {
		return this.caractName;
	}
	
	// setCaractName
	public void setCaractName(String name) {
		this.caractName = name;
	}

}
