package commandes;

import coucheGraphique.Transformateur;

public class Gauche extends Commandes {

	public Gauche(Transformateur target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.moveLeft(80);
		
	}

}
