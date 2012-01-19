//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

import java.util.ArrayList;

//Class: EnsembleDeChaines 
//========================================================
public class EnsembleDeChaines extends Domaine {

	// Attributes
	// ========================================================
	ArrayList<Element> el;

	// Constructor
	// ========================================================
	public EnsembleDeChaines() {
		el = new ArrayList<Element>();
	}
	
	// Methods
	// ========================================================
	// addElement
	public void addElement(Element e){
		el.add(e);
	}
	
	// contains
	public boolean contains(String s){
		boolean b = true;
		for (Element e : el)
		{
			b =b && (e.getNom().equals(s));		
		}
		return b;
	}
	
	// inclus
	public boolean inclus (Domaine d) throws BadDomainException {
		// test si je suis inclus dans d
		boolean b;
		if(d instanceof EnsembleDeChaines)
		{
			b=true;
			for (Element e: el)
			{
				b=b && ((EnsembleDeChaines) d).contains(e.getNom());
			}
			return b;
		}
		else
		{
			throw new BadDomainException();
		}
	}
	
	// toString
	public String toString(){
		String result;
		result = "Ensemble : {";
		for (Element e: el)
		{
			result=result+e.toString()+", ";
		}
		result = result.substring(0, (result.length()-2));
		result=result+"}";
		return result;
	}

}
