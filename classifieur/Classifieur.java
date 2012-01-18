package classifieur;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import tools.Msg;

public class Classifieur {
	
	static Categorie mere;
	
	public Classifieur () throws ParserConfigurationException, SAXException{
		Classifieur.mere=new Categorie();
	}
	
	public ArrayList<Categorie> classer(Observation o){
		ArrayList<Categorie> liste_categories = new ArrayList<Categorie>();
		
		this.ajoute_si_se_classe_sous(mere, liste_categories, o);
		
		for (Categorie fille : mere.getFilles()){
			this.ajoute_si_se_classe_sous(fille, liste_categories, o);
		}
		return liste_categories;
	}
	
	
	private void ajoute_si_se_classe_sous(Categorie cat, ArrayList<Categorie> liste_categories, Observation o) {
		if(cat.seClasseSous(o))
		{
			liste_categories.add(cat);
		}
	}
	
	public ArrayList<String> getListIntituleTypo(){
		return Classifieur.mere.getIntitule();
	}
	
	public static void showCategorieTree(){
		Msg.puts(mere.toString());
	}
	
}
