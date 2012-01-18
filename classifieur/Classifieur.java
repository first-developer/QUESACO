//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import tools.Msg;

// Class: Classifieur 
// @implements: Serializable
//========================================================
public class Classifieur implements Serializable{
	
	// Attributes
	// ========================================================
	private static final long serialVersionUID = 1L;
	private Categorie mere;
	
	// Constructors
	// ========================================================
	public Classifieur () throws ParserConfigurationException, SAXException{
		this.mere=new Categorie();
	}
	
	// Methods
	// ========================================================
	
	// setters and getters
	// getMere
	public Categorie getMere() {
		return this.mere;
	}
	
	// setMere
	public void setMere(Categorie c) {
		this.mere = c;
	}
	
	// getListIntituleTypo
	public ArrayList<String> getListIntituleTypo(){
		return this.getMere().getIntitule();
	}
	
	// classer
	public ArrayList<Categorie> classer(Observation o){
		ArrayList<Categorie> liste_categories = new ArrayList<Categorie>();
		
		this.ajoute_si_se_classe_sous(this.getMere(), liste_categories, o);
		
		for (Categorie fille : this.getMere().getFilles()){
			this.ajoute_si_se_classe_sous(fille, liste_categories, o);
		}
		return liste_categories;
	}
	
	// ajoute_si_se_classe_sous
	private void ajoute_si_se_classe_sous(Categorie cat, ArrayList<Categorie> liste_categories, Observation o) {
		if(cat.seClasseSous(o)) {
			liste_categories.add(cat);
		}
	}
	
	// showCategorieTree
	public void showCategorieTree(){
		Msg.puts(this.getMere().toString());
	}
	
	// testEngloge
	public static void testEngloge(Categorie mere, Categorie fille) {
		if ( mere.englobe(fille)) {
			Msg.puts("La categorie ["+ mere + "] englobe la categorie [" + fille.getNom() +"]" );
		}
		else {
			Msg.puts("La categorie ["+ mere + "] n'englobe pas la categorie [" + fille.getNom() +"]" );
		}
	}
	
	// Save
	public void save (String fileName) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream (fileName) );
		out.writeObject(this.getMere());
		out.close();
	}
	
	// Load
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		Msg.puts("Chargement de la typologie  ... ");
		ObjectInputStream in = new ObjectInputStream( new FileInputStream(fileName));
		this.setMere((Categorie)in.readObject());
	}
	
}
