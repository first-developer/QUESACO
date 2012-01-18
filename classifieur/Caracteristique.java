package classifieur;

public class Caracteristique {
	/**
	 * attribut
	 */
	private String intitule;
	private Domaine dm;

	/**
	 * constructeur
	 */
	public Caracteristique() {
		this.intitule = "";
		this.dm= null;
	}
	
	public Caracteristique(String s, Domaine d) {
		this.intitule = s;
		this.dm=d;
	}
	
	public void setIntitule(String s) {
		this.intitule=s;		
	}

	/**
	 * methodes
	 */
	public String toString(){
		String result="- "+this.getIntitule()+" : ";
		result=result+ dm.toString();
		return result;
	}
	
	public Domaine getDomaine (){
		return this.dm;
	}
	
	public void setDomaine (Domaine d){
		this.dm = d;
	}

	public boolean checkObservation(Observation o) {
		return o.hasCharact(this);
	}

	public String getIntitule() {
		return intitule;
	}
}
