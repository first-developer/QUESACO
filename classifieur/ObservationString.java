//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

// Class:  ObservationString
//========================================================
public class ObservationString {

	// Attributes
	//========================================================
	private String value;
	
	// Constructor
	//========================================================
	public ObservationString(String s) {
		this.setValue(s);
	}

	// Methods
	//========================================================
	// hasValueIn 
	public boolean hasValueIn (Domaine d) throws BadDomainException {
		// je teste si ma valeur est dans d
		if (d instanceof EnsembleDeChaines)
		{
			return ((EnsembleDeChaines) d).contains(this.getValue());
		}
		else
		{
			throw new BadDomainException();
		}
	}

	// getValue
	public String getValue() {
		return value;
	}

	// setValue
	public void setValue(String value) {
		this.value = value;
	}
}
