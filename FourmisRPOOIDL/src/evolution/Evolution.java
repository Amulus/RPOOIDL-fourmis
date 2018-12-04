package evolution;

import fourmilliere.*;

public abstract class Evolution {
	
	protected static int identifiantSuivant = 2;
	protected int identifiant;
	public Evolution(){

		
	}
	
	public int getIdentifiant() {
		return this.identifiant;
	}
}
