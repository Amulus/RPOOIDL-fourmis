package fourmilliere;

import java.awt.Dimension;
import java.awt.Point;

import coucheGraphique.CalculDeplacement;
import etat.Etat;
import etat.Oeuf;

public class Fourmi {
	protected Fourmilliere fourmilliere;
	Etat etat;
	protected boolean estDehors = false;
	private CalculDeplacement Calculdeplacement =null;

	public Fourmi(Fourmilliere fourmilliere) {
		this.fourmilliere = fourmilliere;
		this.etat = new Oeuf(this);	
		int tailleFourmie = (int) fourmilliere.getLireParametres().ChercherParametre("TailleFourmie");
		Calculdeplacement = new CalculDeplacement(new Point(0, 0),new Dimension(tailleFourmie, tailleFourmie),fourmilliere.getMonde());
	}
	public CalculDeplacement getCalculDeplacement(){
		return this.Calculdeplacement;
	}
	
	public void changerEtat(Etat etat) {
		this.etat = etat;
	}

	public Fourmilliere getFourmilliere() {
		return this.fourmilliere;
	}

	public Etat getEtat() {
		return this.etat;
	}
	
	public void step() {
		this.etat.step();
	}
}
