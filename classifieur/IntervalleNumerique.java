//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

import java.io.Serializable;

//Class: IntervalleNumerique 
//========================================================
public class IntervalleNumerique extends Domaine
implements Serializable {
	
	// Attributes
	// ========================================================
	private double inf;
	private double sup;
	
	// Constructor
	// ========================================================
	public IntervalleNumerique() {
		this.inf=0.0;
		this.sup=0.0;
	}
	
	public IntervalleNumerique(double a, double b) {
		this.inf=a;
		this.sup=b;
	}
	
	// Methods
	// ========================================================
	
	// getter and setter 
	// setInf
	public void setInf(Double i) {
		this.inf = i;
	}
	
	// getInf
	public Double getInf() {
		return this.inf;
	}
	
	// setSup
	public void setSup(Double i) {
		this.sup = i;
	}
	
	// getSup
	public Double getSup() {
		return this.sup;
	}
	
	// contains 
	public boolean contains(double d){
		return (d>=this.inf) && (d<=this.sup);
	}
	
	// inclus
	public boolean inclus (Domaine d) throws BadDomainException {
		// test si je suis inclus dans "d"
		if(d instanceof IntervalleNumerique)
		{
			return ((IntervalleNumerique) d).contains(this.inf) && ((IntervalleNumerique) d).contains(this.sup);
		}
		else
		{
			throw new BadDomainException();
		}
	}
	
	// toString
	public String toString(){
		String result;
		result="Intervalle : ["+this.inf+", "+this.sup+"]";
		return result;
	}
}
