//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package application;

//Imports
//========================================================
import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import parser.myXMLHandler;
import tools.Msg;
import org.xml.sax.SAXException;

import classifieur.Classifieur;
import classifieur.Observation;
import classifieur.ObservationItem;
import classifieur.ObservationNumerique;
import classifieur.ObservationString;



public class TestXML {

	// Attributes
	// ========================================================
	public static  String uri;
	  	   static  myXMLHandler handler;
	
	
	// Methods
	// ========================================================
	  		 

	// getParser 	  		 
	public static SAXParser getParser() 
			throws ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		return (SAXParser) factory.newSAXParser();
	}
	/**
	 * parse: to parse the XML file
	 * @throws SAXException
	 */
	public static void parse() throws SAXException {
		// open dialog to choose your XML file
		_openDialogTochooseXMLFile();
		
		// set the parser handler
		handler = new myXMLHandler();
		
		try {
			Msg.puts(":: Start parsing file at << "+ uri +" >>");
			TestXML.getParser().parse(uri, handler);
		}
		catch ( Exception e) {
			Msg.puts(" Parsing error: " + e.getMessage() );
		}
	}
	
	// Main 
	// ------------------------------------------------------
	public static void main(String[] args) throws Exception {
		Msg.puts(" =====================================================\n" +
				 " ==          MyXMLParser : XML file parser          ==\n" +
				 " =====================================================\n");
		Msg.putsLine();
		TestXML.parse();
		Msg.putsLine();
		Msg.puts(":: File parsed successfully !!!");
		
		// Sauvegarde la typologie
		// -----------------------
		Classifieur classeur = new Classifieur();
		classeur.save("arbres.bin");
		
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
		
		// Visuel de l'arborescence de l'arbre
		classeur.load("arbres.bin");
		classeur.show("arbres",".png");
		classeur.showClassification(obs, "arbres_obs", ".png");
		
	}

	
	public static void _openDialogTochooseXMLFile() {
		JFileChooser chooser = new JFileChooser();
	    
	    int retVal = chooser.showOpenDialog(chooser);
	    if(retVal == JFileChooser.APPROVE_OPTION) {
	    	TestXML.uri = chooser.getSelectedFile().getAbsolutePath();
	    	System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }
	}
}


