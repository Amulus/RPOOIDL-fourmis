package evolution;

import fourmilliere.Nid;

public abstract class Enfant extends Evolution {
	
	protected Nid nid;
	protected int nombreDeJourAvantEvolution;
	
	public Enfant(Nid nid) {
		this.nid = nid;
	}
	abstract void changerEtat();
	
	protected void jourSuivant() {
		this.nombreDeJourAvantEvolution--;
		if(this.nombreDeJourAvantEvolution == 0) {
			this.changerEtat();
		}
	}
}
