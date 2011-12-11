package parser;

import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import tools.Msg;

public class MyParser {

	// Attributes
	// ===========
	private  String uri;
	public  SAXParser parser;
	
	// Methods 
	// ========
	
	/**
	 * MyParser: constructor
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public MyParser() 
			throws ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		this.parser = factory.newSAXParser();
	}
	
	/**
	 * parse: to parse the XML file
	 * @throws SAXException
	 */
	public void parse() 
			throws SAXException {
		// open dialog to choose your XML file
		_openDialogTochooseXMLFile();
		
		// set the parser handler
		myXMLHandler handler = new myXMLHandler();
		
		try {
			Msg.puts(":: Start parsing file at << "+ this.uri +" >>");
			parser.parse(this.uri, handler);
		}
		catch ( Exception e) {
			Msg.puts(" Parsing error: " + e.getMessage());
		}
	}
	
	// Main 
	// ------------------------------------------------------
	public static void main(String[] args) throws Exception {
		Msg.puts(" =====================================================\n" +
				 " ==          MyXMLParser : XML file parser          ==\n" +
				 " =====================================================\n");
		Msg.putsLine();
		MyParser parser = new MyParser();
		parser.parse();
		Msg.putsLine();
		Msg.puts(":: File parsed successfully !!!");
		
	}

	
	private void _openDialogTochooseXMLFile() {
		JFileChooser chooser = new JFileChooser();
	    
	    int retVal = chooser.showOpenDialog(chooser);
	    if(retVal == JFileChooser.APPROVE_OPTION) {
	    	this.uri = chooser.getSelectedFile().getAbsolutePath();
	    	System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }
	}
}
