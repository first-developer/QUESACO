//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

import java.util.ArrayList;

// Class: Categorie
//========================================================
public class Categorie {

	// Attributes
	// ========================================================
	private String nom;
	private String mere;
	private ArrayList<Caracteristique> caracteristiques;
	private ArrayList<Categorie> filles;

	
	// Constructors
	// ========================================================
	public Categorie() {
		this.caracteristiques = new ArrayList<Caracteristique>();
		this.setfilles(new ArrayList<Categorie>());
	}

	public Categorie(String nom, String mere, Caracteristique ca) {
		this.nom = nom;
		this.setMere(mere);
		this.caracteristiques = new ArrayList<Caracteristique>();
		this.setfilles(new ArrayList<Categorie>());
		this.caracteristiques.add(ca);
	}

	// Methods
	// ========================================================
	
	// setters and getters
	
	// getMere
	public String getMere() {
		return mere;
	}
	// getCaracteristiques
	public void setMere(String mere) {
		this.mere = mere;
	}
	
	// getCaracteristiques
	public  ArrayList<Caracteristique> getCaracteristiques() {
		return this.caracteristiques;
	}
	
	// getFilles
	public ArrayList<Categorie> getFilles() {
		return filles;
	}

	// setFilles
	public void setfilles(ArrayList<Categorie> filles) {
		this.filles = filles;
	}

	// setNom
	public void setNom(String name) {
		this.nom = name;
	}
	// getNom
	public String getNom() {
		return this.nom;
	}
	
	// others methods 
	// --------------
	
	// find_by_mere_name
	public Categorie find_by_mere_name(String name) {
		for (Categorie f : this.filles) {
			if (f.mere.equalsIgnoreCase(name)) {
				return f;
			}
		}
		return this;
	}
	
	// addChild
	public void addChild(Categorie c) {
		this.getFilles().add(c);
	}

	// getIntitule
	public boolean estFeuille() {
		return this.getFilles().isEmpty();
	}

	// getIntitule
	public ArrayList<String> getIntitule() {
		ArrayList<String> intitule = new ArrayList<String>();
		for (Caracteristique ca : this.caracteristiques) {
			intitule.add(ca.toString());
		}
		for (Categorie cat : getFilles()) {
			intitule.addAll(cat.getIntitule());
		}
		return intitule;
	}

	// checkObservation
	public boolean checkObservation(Observation o) {
		boolean b;
		b = true;
		for (Caracteristique ca : this.caracteristiques) {
			b = b && ca.checkObservation(o);
		}
		return b;
	}

	// englobe
	public boolean englobe(Categorie cat) {
		boolean b = true;
		for (Caracteristique ca : this.caracteristiques) {
			b = b && cat.verifCaracteristique(ca);
		}
		return b;
	}

	// verifCaracteristique
	private boolean verifCaracteristique(Caracteristique ca) {
		return this.caracteristiques.contains(ca);
	}

	// seClasseSous
	public boolean seClasseSous(Observation o) {
		boolean b = true;
		for (Caracteristique ca : this.caracteristiques) {
			b = b && o.verifObservation(ca);
		}
		if (b) {
			for (Caracteristique ca : this.caracteristiques) {
				b = b && o.verifObservationValue(ca);
			}
		}
		return b;
	}
	
	// addCaracteristique
	public void addCaracteristique(Caracteristique caract) {
		this.caracteristiques.add(caract);
	}
	
	// toString
	public String toString() {
		String res = "CATEGORIE : " + this.nom + "\n";
		
		for (Caracteristique ca : this.caracteristiques) {
			res = res + ca.toString();
		}
		
		res += "\n\t";
		for (Categorie filles : this.getFilles()) {
			res = res + filles.toString();
		}
		
		return res;
	}
}
