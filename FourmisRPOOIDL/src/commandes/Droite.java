package commandes;

import coucheGraphique.Transformateur;

public class Droite extends Commandes {

	public Droite(Transformateur target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.moveRight(80);
		
	}

	
}
