//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

public class ObservationString {

	
	private String value;
	
	
	public ObservationString(String s) {
		this.setValue(s);
	}
	
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
