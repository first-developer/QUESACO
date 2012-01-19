//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

import java.io.Serializable;

// Class:  ObservationString
//========================================================
public class ObservationString  extends ObservationItem
					implements Serializable {

	// Attributes
	//========================================================
	private String value;
	
	// Constructor
	//========================================================
	public ObservationString(String s) {
		this.setValue(s);
	}
	
	public ObservationString(String caractName, String d) {
		this.setValue(d);
		this.setCaractName(caractName);
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
