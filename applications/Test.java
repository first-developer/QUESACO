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

import tools.Msg;
import classifieur.Caracteristique;
import classifieur.Categorie;
import classifieur.Classifieur;
import classifieur.Element;
import classifieur.EnsembleDeChaines;
import classifieur.IntervalleNumerique;
import classifieur.Observation;
import classifieur.ObservationItem;
import classifieur.ObservationNumerique;
import classifieur.ObservationString;


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
		EnsembleDeChaines EnsCh = (EnsembleDeChaines)_c.getDomaine();
		EnsCh.addElement(new Element("arrondi"));
		EnsCh.addElement(new Element("conique"));
		EnsCh.addElement(new Element("iregulier"));
		_caracteristiques.add(_c);
		_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.2, 3.0));
		_caracteristiques.add(_c);
		_c = new Caracteristique("taille", new IntervalleNumerique(5.0, 50.0));
		_caracteristiques.add(_c);
		_c = new Caracteristique("ecorce", new EnsembleDeChaines());
		EnsCh = (EnsembleDeChaines)_c.getDomaine();
		EnsCh.addElement(new Element("ecailles"));
		EnsCh.addElement(new Element("fissuree"));
		EnsCh.addElement(new Element("lisse"));
		EnsCh.addElement(new Element("plaques"));
		_caracteristiques.add(_c);
		_arbre.setCaracteristiques(_caracteristiques); // on ajoute le tout à la categorie
		return _arbre;
	};
	
	// conifere
		static Categorie conifere() {
			Categorie _arbre = new Categorie("conifere", "arbre", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 2.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(5.0, 40.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("ecailles"));
			EnsCh.addElement(new Element("fissuree"));
			EnsCh.addElement(new Element("lisse"));
			_caracteristiques.add(_c);
			_arbre.setCaracteristiques(_caracteristiques); // on ajoute le tout à la categorie
			return _arbre;
		};

		// epicea
		static Categorie epicea() {
			Categorie _arbre = new Categorie("epicea", "conifere", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.5));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(20.0, 30.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("ecailles"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("aiguilles", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("brosse"));
			EnsCh.addElement(new Element("peigne"));
			_caracteristiques.add(_c);
			_arbre.setCaracteristiques(_caracteristiques); // on ajoute le tout à la categorie
			return _arbre;
		};
	

		// meleze
		static Categorie meleze() {
			Categorie _arbre = new Categorie("meleze", "arbre", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.5));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(20.0, 40.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("lisse"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("aiguilles", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("bouquet"));
			_caracteristiques.add(_c);
			_arbre.setCaracteristiques(_caracteristiques); // on ajoute le tout à la categorie
			return _arbre;
		};
	
		// feuillu
		static Categorie feuillu() {
			Categorie _arbre = new Categorie("feuillu", "conifere", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("arrondi"));
			EnsCh.addElement(new Element("conique"));
			EnsCh.addElement(new Element("iregulier"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 2.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(5.0, 50.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("ecailles"));
			EnsCh.addElement(new Element("fissuree"));
			EnsCh.addElement(new Element("lisse"));
			EnsCh.addElement(new Element("plaques"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("aiguilles", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("dentelee"));
			EnsCh.addElement(new Element("lobe"));
			EnsCh.addElement(new Element("ovale"));
			_caracteristiques.add(_c);
			_arbre.setCaracteristiques(_caracteristiques); // on ajoute le tout à la categorie
			return _arbre;
		};
		
		// thuya
		static Categorie thuya() {
			Categorie _arbre = new Categorie("thuya", "conifere", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(5.0, 20.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("fissuree"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("aiguilles", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("dentelee"));
			_caracteristiques.add(_c);
			_arbre.setCaracteristiques(_caracteristiques); // on ajoute le tout à la categorie
			return _arbre;
		};
		
		// aulne
		static Categorie aulne() {
			Categorie _arbre = new Categorie("aulne", "feuillu", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("conique"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(10.0, 25.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("lisse"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("feuilles", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("dentelee"));
			EnsCh.addElement(new Element("ovale"));
			_caracteristiques.add(_c);
			_arbre.setCaracteristiques(_caracteristiques); // on ajoute le tout à la categorie
			return _arbre;
		};
		
		// chene
		static Categorie chene() {
			Categorie _arbre = new Categorie("chene", "feuillu", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("irregulier"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(1.0, 2.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(20.0, 50.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("fissuree"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("feuilles", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("lobe"));
			_caracteristiques.add(_c);
			_arbre.setCaracteristiques(_caracteristiques); // on ajoute le tout à la categorie
			return _arbre;
		};
		
		// hetre
		static Categorie hetre() {
			Categorie _arbre = new Categorie("hetre", "feuillu", new Caracteristique());
			_arbre.setfilles( new ArrayList<Categorie>());
			ArrayList<Caracteristique> _caracteristiques = new ArrayList<Caracteristique>();
			Caracteristique _c = new Caracteristique("forme", new EnsembleDeChaines());
			EnsembleDeChaines EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("arrondi"));
			EnsCh.addElement(new Element("conique"));
			EnsCh.addElement(new Element("iregulier"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille du tronc", new IntervalleNumerique(0.5, 1.5));
			_caracteristiques.add(_c);
			_c = new Caracteristique("taille", new IntervalleNumerique(20.0, 40.0));
			_caracteristiques.add(_c);
			_c = new Caracteristique("ecorce", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("lisse"));
			_caracteristiques.add(_c);
			_c = new Caracteristique("feuilles", new EnsembleDeChaines());
			EnsCh = (EnsembleDeChaines)_c.getDomaine();
			EnsCh.addElement(new Element("dentelee"));
			EnsCh.addElement(new Element("lobe"));
			_caracteristiques.add(_c);
			_arbre.setCaracteristiques(_caracteristiques); // on ajoute le tout à la categorie
			return _arbre;
		};
		
		
		
		public static void main(String[] args) throws ParserConfigurationException, SAXException {
			
			Classifieur classeur = new Classifieur();
			Caracteristique _c ;
			//on cree la categorie mere
			Categorie mere = new Categorie();
			mere.setNom("arbre");
			classeur.setMere(mere);
			IntervalleNumerique intNum=new IntervalleNumerique();
			EnsembleDeChaines EnsCh = new EnsembleDeChaines();
			intNum.setInf(5.0);
			intNum.setSup(50.0);	
			_c = new Caracteristique("taille", intNum);
			classeur.getMere().addCaracteristique(_c);
			EnsCh.addElement( new Element("arrondi"));
			EnsCh.addElement( new Element("conique"));
			EnsCh.addElement( new Element("irregulier"));
			
			_c = new Caracteristique("forme", EnsCh);
			classeur.getMere().addCaracteristique(_c);
			
			intNum=new IntervalleNumerique();
			intNum.setInf(0.2);
			intNum.setSup(3.0);
			
			_c = new Caracteristique("taille du tronc", intNum);
			classeur.getMere().addCaracteristique(_c);
			
			EnsCh=new EnsembleDeChaines();
			EnsCh.addElement( new Element("ecailles"));
			EnsCh.addElement( new Element("fissuree"));
			EnsCh.addElement( new Element("lisse"));
			EnsCh.addElement( new Element("plaques"));
			_c = new Caracteristique("ecorce", EnsCh);
			classeur.getMere().addCaracteristique(_c);
			

			Categorie conifere=conifere();
			Categorie feuillu=feuillu();
			Categorie epicea=epicea();
			Categorie aulne=aulne();
			
			classeur.getMere().addChild(conifere);
			classeur.addCategoryThroughMere(feuillu);
			classeur.addCategoryThroughMere(epicea);
			classeur.addCategoryThroughMere(aulne);


			// Creation d'une observation obs ( ex: obs doit se placer sous les categories arbre, conifere et feuillu )
			Observation obs=new Observation();
			ObservationItem item; 
			item = new ObservationNumerique("taille", 15.0);
			obs.addObservationItem(item);
			item = new ObservationString("forme", "conique");
			obs.addObservationItem(item);
			item = new ObservationNumerique("taille du tronc", 0.75);
			obs.addObservationItem(item);
			item = new ObservationString("ecorce", "fissuree");
			obs.addObservationItem(item);
			item = new ObservationString("feuilles", "ovale");
			obs.addObservationItem(item);
			
			// Creation d'une observation obs_1 ( ex: obs_1 qui ne se place sous aucune categorie)
			Observation obs_1=new Observation();
			item = new ObservationNumerique("taille", 40.0);
			obs_1.addObservationItem(item);
			item = new ObservationString("couleur", "bleu");
			obs_1.addObservationItem(item);
			
			// Affichage l'arbre complet
			classeur.showCategorieTree();

			// Ajoute de la premiere observation 'obs'
			classeur.setObs(obs);
			obs.showObservationCategories(classeur);
			
			// Ajoute la deuxieme observation 'obs_1
			classeur.setObs(obs_1);
			obs_1.showObservationCategories(classeur);
			
			// REcuperation des intitules des caracteristiques et affichage
			ArrayList<String> intitules = classeur.getMere().getIntitule();
			Msg.puts(" =====================================================");
			Msg.puts("	INTITULES DES CARACTERISTIQUES");
			Msg.puts(" =====================================================\n");
			Msg.putsAll(intitules);
		}
}
