//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package applications;

// Imports
//========================================================
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import classifieur.*;


// Class: Test
//========================================================
public class Test {

	// Static data
	// ========================================================
	
	// Arbre
	static Categorie arbre() {
		Categorie _arbre = new Categorie("arbre", "TOP", new Caracteristique());
		_arbre.setfilles( new ArrayList<Categorie>());
		ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
		Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
		EnsembleDeChaines ens = (EnsembleDeChaines)_c.getDomaine();
		ens.addElement(new Element("arrondi"));
		ens.addElement(new Element("conique"));
		ens.addElement(new Element("iregulier"));
		_caracteristiques.add(_c);
		_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.2, 3.0));
		_caracteristiques.add(_c);
		_c = new Caracteristique("taille", new IntervalleNumerique(5.0, 50.0));
		_caracteristiques.add(_c);
		_c = new Caracteristique("ecorce", new EnsembleDeChaines());
		ens = (EnsembleDeChaines)_c.getDomaine();
		ens.addElement(new Element("ecailles"));
		ens.addElement(new Element("fissuree"));
		ens.addElement(new Element("lisse"));
		ens.addElement(new Element("plaques"));
		_caracteristiques.add(_c);
		return _arbre;
	};
	
	// conifere
		static Categorie conifere() {
			Categorie _arbre = new Categorie("conifere", "arbre", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 2.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(5.0, 40.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("ecailles"));
			ens.addElement(new Element("fissuree"));
			ens.addElement(new Element("lisse"));
			_caracteristiques.add(_c);
			return _arbre;
		};

		// epicea
		static Categorie epicea() {
			Categorie _arbre = new Categorie("epicea", "conifere", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.5));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(20.0, 30.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("ecailles"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("aiguilles", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("brosse"));
			ens.addElement(new Element("peigne"));
			_caracteristiques.add(_c);
			return _arbre;
		};
	

		// meleze
		static Categorie meleze() {
			Categorie _arbre = new Categorie("meleze", "arbre", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.5));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(20.0, 40.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("lisse"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("aiguilles", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("bouquet"));
			_caracteristiques.add(_c);
			return _arbre;
		};
	
		// feuillu
		static Categorie feuillu() {
			Categorie _arbre = new Categorie("feuillu", "conifere", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("arrondi"));
			ens.addElement(new Element("conique"));
			ens.addElement(new Element("iregulier"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 2.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(5.0, 50.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("ecailles"));
			ens.addElement(new Element("fissuree"));
			ens.addElement(new Element("lisse"));
			ens.addElement(new Element("plaques"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("aiguilles", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("dentelee"));
			ens.addElement(new Element("lobe"));
			ens.addElement(new Element("ovale"));
			_caracteristiques.add(_c);
			return _arbre;
		};
		
		// thuya
		static Categorie thuya() {
			Categorie _arbre = new Categorie("thuya", "conifere", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(5.0, 20.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("fissuree"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("aiguilles", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("dentelee"));
			_caracteristiques.add(_c);
			return _arbre;
		};
		
		// aulne
		static Categorie aulne() {
			Categorie _arbre = new Categorie("aulne", "feuillu", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(10.0, 25.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("lisse"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("feuilles", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("dentelee"));
			ens.addElement(new Element("ovale"));
			_caracteristiques.add(_c);
			return _arbre;
		};
		
		// chene
		static Categorie chene() {
			Categorie _arbre = new Categorie("chene", "feuillu", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("irregulier"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(1.0, 2.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(20.0, 50.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("fissuree"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("feuilles", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("lobe"));
			_caracteristiques.add(_c);
			return _arbre;
		};
		
		// hetre
		static Categorie hetre() {
			Categorie _arbre = new Categorie("hetre", "feuillu", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("arrondi"));
			ens.addElement(new Element("conique"));
			ens.addElement(new Element("iregulier"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.5));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(20.0, 40.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("lisse"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("feuilles", new EnsembleDeChaines());
			ens = (EnsembleDeChaines)_c.getDomaine();
			ens.addElement(new Element("dentelee"));
			ens.addElement(new Element("lobe"));
			_caracteristiques.add(_c);
			return _arbre;
		};
		
		
		
		public static void main(String[] args) throws ParserConfigurationException, SAXException {
			
			// Classifieur classifieur =new Classifieur();
			
			
			
		}
}
