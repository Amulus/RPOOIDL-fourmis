package evolution;

import fourmilliere.Fourmilliere;

public abstract class Evolution {
	Fourmilliere fourmilliere;
	protected static int identifiantSuivant = 2;
	protected int identifiant;
	public Evolution(Fourmilliere fourmilliere){
		this.fourmilliere=fourmilliere;
		
	}
	public abstract void changerEtat();
	public abstract void getEtat();
	
	public int getIdentifiant() {
		return this.identifiant;
	}
}
