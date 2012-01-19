//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import tools.Msg;

// Class: Categorie
//========================================================
public class Categorie {

	// Attributes
	// ========================================================
	private String nom;
	private String mere;
	private ArrayList<Caracteristique> caracteristiques;
	private ArrayList<Categorie> filles;
	int level = 0;
	
	// Constructors
	// ========================================================
	public Categorie() {
		this.caracteristiques = new ArrayList<Caracteristique>();
		this.setfilles(new ArrayList<Categorie>());
		this.level = 0; // pour aligner les categories à l'affichage
	}

	public Categorie(String nom, String mere, Caracteristique ca) {
		this.nom = nom;
		this.setMere(mere);
		this.caracteristiques = new ArrayList<Caracteristique>();
		this.setfilles(new ArrayList<Categorie>());
		this.caracteristiques.add(ca);
		this.level = 0; // pour aligner les categories à l'affichage
	}

	// Methods
	// ========================================================
	
	// setters and getters
	
	// getMere
	public String getMere() {
		return mere;
	}
	// setMere
	public void setMere(String mere) {
		this.mere = mere;
	}
	
	// getCaracteristiques
	public  ArrayList<Caracteristique> getCaracteristiques() {
		return this.caracteristiques;
	}
	
	// setCaracteristiques
	public  void setCaracteristiques( ArrayList<Caracteristique> c) {
		this.caracteristiques = c;
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
	
	// find_fille_by_name
	public Categorie find_fille_by_name(String name) {
		for (Categorie f : this.filles) {
			if (f.getNom().equalsIgnoreCase(name)) {
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
	public boolean seClasseSous(Observation o) throws BadDomainException {
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
		String res = "CATEGORIE : " + this.nom  + "\n";
		int i = this.level;
		for (Caracteristique ca : this.caracteristiques) {
			if (i !=0) {
				res += Msg.puts_i_times("\t", i);
			}
			res += ca.toString() + "\n";
		}
		res += "\n\t";
		for (Categorie fille : this.getFilles()) {
			fille.increaseLevel();
			res = res + fille.toString();
		}
		
		return res;
	}

	// Write in file with ".gv" specification
	public void writeCat(FileWriter fw) throws IOException {
		for ( Categorie fille : this.filles) {
			fw.write("\t" + this.getNom() + "->" + fille.getNom() + "\n");
			if ( fille.getFilles() != null) {
				fille.writeCat(fw);
			}
		}
	}
	
	public void increaseLevel() {
		this.level = this.level +1;
	}
	
	public int getLevel() {
		return this.level;
	}
}
