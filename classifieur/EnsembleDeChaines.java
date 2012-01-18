//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

import java.util.ArrayList;

public class EnsembleDeChaines extends Domaine {

	ArrayList<Element> el;

	public EnsembleDeChaines() {
		el = new ArrayList<Element>();
	}
	
	public void addElement(Element e){
		el.add(e);
	}
	
	public boolean contains(String s){
		boolean b = true;
		for (Element e : el)
		{
			b =b && (e.getNom().equals(s));		
		}
		return b;
	}
	
	public boolean Inclus (Domaine d) throws BadDomainException {
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
	
	public String toString(){
		String result;
		result = "Ensemble : {";
		for (Element e: el)
		{
			result=result+e.toString()+", ";
		}
		result = result.substring(0, (result.length()-2));
		result=result+"}\n";
		return result;
	}

}
