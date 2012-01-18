//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

public class Element {
	/**
	 * attribut
	 */
	private String nom;
	
	/**
	 * methodes
	 */
	public Element() {
		this.setNom("");
	}
	public Element(String s) {
		this.setNom(s);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return this.nom;
	}
}
