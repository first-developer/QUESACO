package parser;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;

import org.xml.sax.helpers.*;
import org.xml.sax.*;
import tools.*;

public class myXMLHandler extends DefaultHandler {


	// Attributes
	// ===========
	
	private boolean _inDocbase,			// trigger the docbase tag 
					_inCategorie, 		// triffer the categorie tag
					_inCaracteristic, 	// triffer the Caracteristique tag
					_inInterval, 		// triffer the Interval tag
					_inEnsemble;		// triffer the Ensemble tag
	boolean isElement = false;
	Object data; 						// Glogal data
	
		
	// Methods 
	// ========
	
	/**
	 * myXMLHandler :Constructor
	 * @throws org.xml.sax.SAXException
	 */
	public myXMLHandler( ) 
		throws org.xml.sax.SAXException {
		this._inDocbase		  = false; 
		this._inCategorie 	  = false; 
		this._inCaracteristic = false; 
		this._inInterval 	  = false; 
		this._inEnsemble	  = false;
		
		this.data = null;
	}
	
	// startElement
	public void startElement( String uri, String localName, String qname, Attributes attributes ) {
		
		
		// set tag's flag according to the 'qname'
		_checkAndSetFlags(qname);
		
		// Init data related to tag where we are 
		//_checkAndinitData(qname);
		
		Msg.puts("{"+qname+"}");
	}
	
	// endElement
	public void endElement( String uri, String localName, String qname ) {
		Msg.puts("{/"+qname+"}");
		// Set flag to false according to he tags closed
		_checkAndSetFlags(qname);

	}
	
	// characters
	public void characters( char[] ch, int start, int length) {
		_setDataContent(ch, start, length);
		if (!((String) data).isEmpty()) {
			Msg.puts(" -: " + data  );
		}
	}
	
	// ignorableWhitesapce
	public void ignorableWhitespace(char[] ch, int start, int length) 
		throws SAXException { 
	}
	
	
	// Private functions
	// ==================
	
	/**
	 * _setDataContent: to set data content with the characters get
	 * @param ch
	 * @param start
	 * @param length
	 */
	private void _setDataContent( char[] ch, int start, int length) {
		String content =  new String (ch, start, length);
		content = content.trim();	// to avoid getting empty content		
		data = content;
	}
	
	
	/**
	 * _isDocbase: to target the 'docbase' xml tag
	 * @param qname
	 * @return
	 */
	private static boolean _isDocbase(String qname) {
		return qname.equalsIgnoreCase("docbase");
	}
	
	/**
	 * _isCategorie: to target the 'categorie' xml tag
	 * @param qname
	 * @return
	 */
	private static boolean _isCategorie(String qname) {
		return qname.equalsIgnoreCase("categorie");
	}
	
	/**
	 * _isCaracteristic: to target the 'Caracteristique' xml tag
	 * @param qname
	 * @return
	 */
	private static boolean _isCaracteristic(String qname) {
		return qname.equalsIgnoreCase("caracteristique");
	}
	
	/**
	 * _isInterval: to target the 'Interval' xml tag
	 * @param qname
	 * @return
	 */
	private static boolean _isInterval(String qname) {
		return qname.equalsIgnoreCase("interval");
	}
	
	/**
	 * _isInterval: to target the 'Interval' xml tag
	 * @param qname 
	 * @return
	 */
	private static boolean _isEnsemble(String qname) {
		return qname.equalsIgnoreCase("ensemble");
	}
	
	/**
	 * _checkAndSetFlags
	 * @param qname
	 */
	private void _checkAndSetFlags(String qname) {
		_inDocbase  	 = (_isDocbase(qname)) 		 ? true : false;
		_inCategorie  	 = (_isCategorie(qname)) 	 ? true : false;
		_inCaracteristic = (_isCaracteristic(qname)) ? true : false;
		_inInterval 	 = (_isInterval(qname)) 	 ? true : false;
		_inEnsemble 	 = (_isEnsemble(qname)) 	 ? true : false;
	}

	/**
	 * _checkAndinitData
	 * @param qname
	 */
//	private void _checkAndinitData(String qname) {
//		if (_inDocbase) 		data = new String();
//		if (_inCategorie)		data = new String();
//		if (_inCaracteristic) 	data = new String();
//		if (_inInterval) 	 	data = new String();
//		if (_inEnsemble) 	 	data = new String();
//	}
	

	
}
