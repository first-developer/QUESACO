package parser;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import tools.Msg;
import classifieur.Caracteristique;
import classifieur.Categorie;
import classifieur.Element;
import classifieur.EnsembleDeChaines;
import classifieur.IntervalleNumerique;

public class myXMLHandler extends DefaultHandler {
	

	// Attributes
	// ===========
	Categorie fille;
	Caracteristique c;
	EnsembleDeChaines e;
	IntervalleNumerique intNum;
	Element el;
	String node;
	public boolean _inDocbase,			// trigger the docbase tag 
					_inCategorie, 		// triffer the categorie tag
					_inCaracteristic, 	// triffer the Caracteristique tag
					_inInterval, 		// triffer the Interval tag
					_inEnsemble,		// triffer the Ensemble tag
					_inElement,		  
					_inNom,			
					_inIntitule,	  
					_inInf,			
					_inSup,			
					_inMere;		  
	
	Object dataAdapter; 					// Glogal data
	public Categorie rootCategory;
	private boolean _isTopCategory;
		
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
		this._inElement		  = false;
		this._inNom			  = false;
		this._inIntitule	  = false;
		this._inInf			  = false;
		this._inSup			  = false;
		this._inMere		  = false;
	}
	
	// startElement
	public void startElement( String uri, String localName, String qname, Attributes attributes ) {
		
		
		// set tag's flag according to the 'qname'
		_checkAndSetFlags(qname);
		
		// Init data related to tag where we are 
		_checkAndinitData(qname);
		node = qname;
		// @log: Msg.puts("{"+qname+"}");
	}
	
	// endElement
	public void endElement( String uri, String localName, String qname ) {
		
		if (this._isElement(qname)) {
			//this._inElement = false;
		}
		if (this._isEnsemble(qname)) {
			//this._inEnsemble = false;
		}
		if (this._isInf(qname)) {
			//this._inInf = false;	
		}
		if (this._isSup(qname)) {
			//this._inSup = false;
		}
		if (this._isInterval(qname)) {
			//this._inInterval= false;
		}		
		if (this._isIntitule(qname)) {
			//this._inIntitule = false;
		}
		if (this._isCaracteristic(qname)) {
			fille.getCaracteristiques().add(c);
			//this._inCaracteristic = false;
		}
		if (this._isMere(qname)) {
			//this._inMere = false;
		}
		if (this._isNom(qname)) {
			//this._inNom = false;
		}
		if (this._isCategorie(qname)) {
			// checking if we have already set the root category	
			if (_isTopCategory) {
				rootCategory = fille;
				_isTopCategory = false;
			}
			else {
				Categorie f = rootCategory.find_fille_by_name(fille.getMere());
				// @log: Msg.puts(fille.getMere());
				f.addChild(fille);
			}
		}
		if (this._isDocbase(qname)) {
			Msg.puts(rootCategory.toString());
		}
	}
	
	// characters
	public void characters( char[] ch, int start, int length) {
		String content = _setDataContent(ch, start, length);
		if (!content.isEmpty()) {
			// @log: Msg.puts("- "+content);
			if (this._inNom) {
				fille.setNom(content);
			}
			if (this._inMere) {
				if ((content).equalsIgnoreCase("TOP")) {
					_isTopCategory = true;
				}
				else {
					fille.setMere(content);
				}
			}
			if (this._inIntitule) {
				c.setIntitule(content);
			}
			if (this._inElement) {
				el.setNom(content);
				e.addElement(el);
				c.setDomaine(e);
			}
			if (this._inInf) {
				intNum.setInf(Double.parseDouble(content));
			}
			
			if (this._inSup) {
				intNum.setSup(Double.parseDouble(content));
				c.setDomaine(intNum);
			}
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
	private String _setDataContent( char[] ch, int start, int length) {
		String content =  new String (ch, start, length);
		content = content.trim();	// to avoid getting empty content		
		return content;
	}
	
	
	/**
	 * _isDocbase: to target the 'docbase' xml tag
	 * @param qname
	 * @return
	 */
	private boolean _isDocbase(String qname) {
		return qname.equalsIgnoreCase("docbase");
	}
	
	/**
	 * _isCategorie: to target the 'categorie' xml tag
	 * @param qname
	 * @return
	 */
	private boolean _isCategorie(String qname) {
		return qname.equalsIgnoreCase("categorie");
	}
	
	/**
	 * _isCaracteristic: to target the 'Caracteristique' xml tag
	 * @param qname
	 * @return
	 */
	private boolean _isCaracteristic(String qname) {
		return qname.equalsIgnoreCase("caracteristique");
	}
	
	/**
	 * _isInterval: to target the 'Interval' xml tag
	 * @param qname
	 * @return
	 */
	private boolean _isInterval(String qname) {
		return qname.equalsIgnoreCase("intervalle");
	}
	
	/**
	 * _isInterval: to target the 'Interval' xml tag
	 * @param qname 
	 * @return
	 */
	private boolean _isEnsemble(String qname) {
		return qname.equalsIgnoreCase("ensemble");
	}
	
	private boolean _isElement(String qname){
		return qname.equalsIgnoreCase("element");
	}
	
	private boolean _isNom(String qname){
		return qname.equalsIgnoreCase("nom");
	}
	
	private boolean _isIntitule(String qname){
		return qname.equalsIgnoreCase("intitule");
	}
	
	private boolean _isInf(String qname){
		return qname.equalsIgnoreCase("inf");
	}
	
	private boolean _isSup(String qname){
		return qname.equalsIgnoreCase("sup");
	}
	
	private boolean _isMere(String qname){
		return qname.equalsIgnoreCase("mere");
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
		_inElement  	 = (_isElement(qname)) 		 ? true : false;
		_inNom  		 = (_isNom(qname)) 	 		 ? true : false;
		_inIntitule 	 = (_isIntitule(qname))      ? true : false;
		_inMere 	 	 = (_isMere(qname)) 	 	 ? true : false;
		_inInf 	 		 = (_isInf(qname)) 	 		 ? true : false;
		_inSup 	 		 = (_isSup(qname)) 	 		 ? true : false;
	}


	// _checkAndinitData
	private void _checkAndinitData(String qname) {
		if (_inCategorie) { fille = new Categorie(); }
		if (_inCaracteristic) 	{ c = new Caracteristique();}
		if (_inInterval) 	 	{ intNum = new IntervalleNumerique(); }
		if (_inEnsemble) 	 	{ e = new EnsembleDeChaines();}
		if (_inElement)			{ el = new Element();}
	}
	
	// getRootCategory()
	public Categorie getRootCategory() {
		return this.rootCategory;
	}
}
