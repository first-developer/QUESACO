package parser;

import org.xml.sax.helpers.*;
import org.xml.sax.*;
import tools.*;

public class myXMLHandler extends DefaultHandler {

	public myXMLHandler( ) 
		throws org.xml.sax.SAXException {
		
	}
	
	
	public void startElement( String uri, String localName, String qname, Attributes attributes ) {
		Msg.puts(" Begining of Element: " + qname);
	}
	
	public void endElement( String uri, String localName, String qname, Attributes attributes ) {
		Msg.puts(" End of Element: " + qname);
	}
	
	public void characters( char[] ch, int start, int length) {
		Msg.puts(" => content: \n\t");
		for	( int i=0; i< length; i++ ) {
			Msg.puts(ch[start + i]);
		}
		Msg.putsLine();
	}

	
}
