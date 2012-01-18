//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

public class ObservationNumerique {


	private double value;
	

	public ObservationNumerique(double d) {
		this.setValue(d);
	}
	
	public boolean hasValueIn(Domaine d) throws BadDomainException {
		// je teste si ma valeur est dans d
		if (d instanceof IntervalleNumerique)
		{
			return ((IntervalleNumerique) d).contains(this.getValue());
		}
		else
		{
			throw new BadDomainException();
		}
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
