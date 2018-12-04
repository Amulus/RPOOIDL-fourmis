package evolution;

import fourmilliere.Nid;

public abstract class Enfant extends Evolution {
	
	protected Nid nid;
	
	public Enfant(Nid nid) {
		this.nid = nid;
	}
	abstract void changerEtat();

}
