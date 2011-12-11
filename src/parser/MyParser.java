package parser;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import tools.Msg;

public class MyParser {

	// Attributes
	// ------------------------------------------------------
	private static String uri = "./arbres.xml";
	
	// Constructor
	// ------------------------------------------------------
	public MyParser() {
	}
	
	// Main 
	// ------------------------------------------------------
	public static void main(String[] args) throws Exception {
		Msg.puts("Analyse du fichier 'Cpoints.xml' ");

		JFileChooser chooser = new JFileChooser();
	    
	    int retVal = chooser.showOpenDialog(chooser);
	    if(retVal == JFileChooser.APPROVE_OPTION) {
	    	uri = chooser.getSelectedFile().getAbsolutePath();
	    	System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }
		
		
		// Configure tand set the parser
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		// parser handler
		myXMLHandler handler = new myXMLHandler();
		
		try {
			parser.parse(uri, handler);
		}
		catch ( Exception e) {
			Msg.puts(" Parsing error: " + e.getMessage());
		}
		Msg.puts("Parsing finished successfully");
	}

}
