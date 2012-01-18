//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;

// Import
// ========================================================
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import tools.Msg;

public class Observation {

	// Attributes
	// ========================================================
	ArrayList<ObservationItem> items;
	
	// Constructor
	// ========================================================
	public Observation(ObservationItem o) {
		this.items = new ArrayList<ObservationItem>();
		this.items.add(o);
	}
	
	public Observation() {
		this.items = new ArrayList<ObservationItem>();
	}


	// Methods
	// ========================================================
	// hasCharact
	public boolean hasCharact(Caracteristique c){
		boolean b = true;
		for (ObservationItem oi : items)
		{
			b=b && (oi.getCaractName().equals(c.getIntitule()));
		}
		return b;
	}

	// verifObservation
	public boolean verifObservation(Caracteristique ca) {
		// on verifie d'abord si les intitules de caracteristiques correspondent
		// bi : booleen intitule
		boolean bi = true;
		for (ObservationItem oi : items)
		{
			bi=bi && oi.getCaractName().equals(ca.getIntitule());
		}
		return bi;
	}
	
	// veriObservationValue
	public boolean verifObservationValue(Caracteristique ca) throws BadDomainException{
		// on verifie maintenant si les valeurs correspondent
		// bi : booleen intitule
		boolean bi = true;
		for (ObservationItem oi : items)
		{
			bi=bi && oi.getCaractName().equals(ca.getIntitule());
			if(bi){
				bi=oi.hasValueIn(ca.getDomaine());
			}
		}
		return bi;
	}
	
	// addObservationItem
	public void addObservationItem(ObservationItem o) {
		this.items.add(o);
	}
	
	// setItems
	public void setItems(ArrayList<ObservationItem> o) {
		this.items = o;
	}
	
	// showObservationCategories
	public void showObservationCategories() {
		Classifieur classeur = null;
		try {
			classeur = new Classifieur();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		for ( Categorie cat : classeur.classer(this)) {
			Msg.puts(cat.getNom());
		}
	}
}
