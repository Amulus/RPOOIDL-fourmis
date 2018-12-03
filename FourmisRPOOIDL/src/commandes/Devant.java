package commandes;

import coucheGraphique.Transformateur;

public class Devant extends Commandes {

	public Devant(Transformateur target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.moveUp(80);
		
	}

}
