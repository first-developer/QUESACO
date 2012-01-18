package classifieur;

public abstract class ObservationItem {


	private String caractName;
	

	public ObservationItem() {
		
	}
	
	abstract public boolean hasValueIn (Domaine d);

	public String getCaractName() {
		return this.caractName;
	}

}
