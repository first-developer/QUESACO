//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
	private Observation observation;
	
	// Constructors
	// ========================================================
	public Classifieur () throws ParserConfigurationException, SAXException{
		this.mere=new Categorie();
		this.observation = new Observation();
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
	
	// getObs
	public Observation getObs() {
		return this.observation;
	}
	
	// setObs
	public void setObs(Observation o) {
		this.observation = o;
	}
	
	// getListIntituleTypo
	public ArrayList<String> getListIntituleTypo(){
		return this.getMere().getIntituleName();
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
		try {
			if(cat.seClasseSous(o)) {
				liste_categories.add(cat);
			}
		} catch (BadDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// addCategoryThroughMere
	public void addCategoryThroughMere(Categorie c) {
		// @log: Msg.puts(" ma mere: " + c.getMere() + " --> moi : " + c.getNom());
		Categorie Rmere = find_category_by_name(this.getMere(), c.getMere());
		// @log: Msg.puts(" ma mere trouvée: " + Rmere.getNom() );
		Rmere.addChild(c);
	}
	
	// find_category_by_name
	public Categorie find_category_by_name(Categorie cat_mere, String name) {
		Categorie potential_mere = null;
		if (cat_mere.getNom().equals(name)) {  
			potential_mere = cat_mere;
		}
		else {
			for ( Categorie f : cat_mere.getFilles()) {
				// @log: Msg.puts(" FILLE : " + f.getNom() + "\n" );
				potential_mere = f.find_fille_by_name(name);
			}
		}
		return (potential_mere != null) ? potential_mere : cat_mere; 
	}	
	
	// showCategorieTree
	public void showCategorieTree(){
		if (!this.mere.equals(null)) {
			Msg.puts(this.getMere().toString());
		}
		else {
			Msg.puts("Aucune categorie mere");
		}
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
	
	// show
	public void show(String fileName, String format) throws IOException, IOException, InterruptedException
	{
		// generate the '.dot' file
		String src = fileName + ".gv";
	
		FileWriter fw = new FileWriter(src, false);
		fw.write("digraph G {\n");
		
		this.getMere().writeCat(fw);
		fw.write("}");
		fw.close();
	
		// puts the right image in a specific file
		String file=fileName +format;
		String cmd ="dot -Tpng -o " + file +  " "+src;
		Runtime.getRuntime().exec(cmd).waitFor();
	}
	
	public void showClassification(Observation o, String fileName,String format) throws IOException, InterruptedException
	{
		// classify categories by a given observation
		ArrayList<Categorie> liste_categories_sous_o = this.classer(o); 
		String src=fileName + ".gv";
		FileWriter fw = new FileWriter(src, false);
		fw.write("digraph G {\n \t" );
		fw.write("node [color = green];");
		
		// write those categories in a file
		for ( Categorie cat : liste_categories_sous_o) {
			fw.write(cat.getNom() + " ");
		}
		fw.write(";\n");
		fw.write("\tnode [color = black];\n");
		
		this.getMere().writeCat(fw);
		fw.write("}");
		fw.close();
		
		// build the fileName.format with the image
		String file=fileName + format;
	    String fst_cmd ="rm " + file;
	    Runtime.getRuntime().exec(fst_cmd);
		String snd_cmd ="dot -Tpng -o " + file +  " " + src;
		Runtime.getRuntime().exec(snd_cmd).waitFor();
	}
}
