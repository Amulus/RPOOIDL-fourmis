package commandes;

import java.awt.Color;

import coucheGraphique.Transformateur;

public class Couleur extends Commandes {

	public Couleur(Transformateur target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.setColor(new Color ((int) (Math.random() * 0x1000000)));
	}

}
