package commandes;

import coucheGraphique.Transformateur;

public class Arriere extends Commandes {

	public Arriere(Transformateur target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.moveDown(80);
		
	}

}
