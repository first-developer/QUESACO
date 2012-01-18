package classifieur;


public class IntervalleNumerique extends Domaine {

	private double inf;
	private double sup;
	

	public IntervalleNumerique() {
		this.inf=0.0;
		this.sup=0.0;
	}
	
	public IntervalleNumerique(double a, double b) {
		this.inf=a;
		this.sup=b;
	}
	
	public void setInf(Double i) {
		this.inf = i;
	}
	
	public void setSup(Double i) {
		this.sup = i;
	}
	
	public Double getInf() {
		return this.inf;
	}
	
	public Double getSup() {
		return this.sup;
	}
	
	public boolean contains(double d){
		return (d>=this.inf) && (d<=this.sup);
	}
	
	public boolean Inclus (Domaine d) throws BadDomainException {
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
	
	public String toString(){
		String result;
		result="Intervalle : ["+this.inf+", "+this.sup+"]\n";
		return result;
	}
}
