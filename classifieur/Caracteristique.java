//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

// Class: Caracteristique
// ========================================================
public class Caracteristique {

	// Attributes
	// ========================================================
	private String intitule;
	private Domaine dm;


	// Constructor
	// ========================================================
	public Caracteristique() {
		this.intitule = "";
		this.dm= null;
	}
	
	public Caracteristique(String s, Domaine d) {
		this.intitule = s;
		this.dm=d;
	}
	

	// Methods
	// ========================================================
	
	// getter and setter
	
	// getDomaine 
	public Domaine getDomaine (){
		return this.dm;
	}
	
	// setDomaine
	public void setDomaine (Domaine d){
		this.dm = d;
	}

	// getIntitule
	public String getIntitule() {
		return intitule;
	}
	// setIntitule
	public void setIntitule(String s) {
		this.intitule=s;		
	}
	
	// checkObservation
	public boolean checkObservation(Observation o) {
		return o.hasCharact(this);
	}
	
	// toString
	public String toString(){
		String result="- "+this.getIntitule()+" : ";
		result=result+ dm.toString();
		return result;
	}

}
