package parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import tools.Msg;

public class MyParser {

	// Attributes
	// ------------------------------------------------------
	private String uri = "";
	
	// Constructor
	// ------------------------------------------------------
	public MyParser( String uri) {
		this.uri = uri;
	}
	
	// Main 
	// ------------------------------------------------------
	public static void main(String[] args) throws Exception {
		Msg.puts("Analyse du fichier 'Cpoints.xml' ");

		String uri = "/home/fd/.jdownloader/jd/captcha/methods/dckld/CPoints.xml";
		
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
