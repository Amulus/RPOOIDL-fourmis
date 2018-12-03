package commandes;

import coucheGraphique.Transformateur;

public abstract class Commandes {
	Transformateur target;
	
	public Commandes (Transformateur target) {
		this.target = target;
	}
	Transformateur getTarget() { return target; }
	abstract public void run();
}