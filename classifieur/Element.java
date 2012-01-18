//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

public class Element {

	// Attributes
	// ========================================================
	private String nom;
	
	// Constructor
	// ========================================================
	public Element() {
		this.setNom("");
	}
	
	public Element(String s) {
		this.setNom(s);
	}

	// Methods
	// ========================================================
	
	// getter and setter
	
	// getNom
	public String getNom() {
		return nom;
	}

	// setNom
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// toString
	public String toString() {
		return this.nom;
	}
}
