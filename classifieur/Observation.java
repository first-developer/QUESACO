package classifieur;

import java.util.TreeSet;

public class Observation {

	TreeSet<ObservationItem> items;
	

	public Observation(ObservationItem o) {
		this.items = new TreeSet<ObservationItem>();
		this.items.add(o);
	}
	
	public boolean hasCharact(Caracteristique c){
		boolean b = true;
		for (ObservationItem oi : items)
		{
			b=b && (oi.getCaractName().equals(c.getIntitule()));
		}
		return b;
	}

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
	
	public boolean verifObservationValue(Caracteristique ca){
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
}
