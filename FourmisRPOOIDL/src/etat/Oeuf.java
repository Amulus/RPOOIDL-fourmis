package etat;

import fourmilliere.Fourmi;
import outils.LireParametres;

public class Oeuf extends Etat {
	
	
	public Oeuf(Fourmi fourmi) {
		super(fourmi);
		this.nombreStepExistence = 0;
		LireParametres lecturefichier = this.fourmi.getFourmilliere().getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionOeufs");
		this.nombreStepAvantEvolution = 388*this.nombreDeJourAvantEvolution;
	}
	public void evoluer() {
		this.fourmi.changerEtat(new Larve(this.fourmi));
	}
	//Meme chose que nymphe
	@Override
	public void step() {
		this.nombreStepExistence++;
		if(this.nombreStepExistence >= 388*this.nombreDeJourAvantEvolution)
			this.evoluer();
	}
	@Override
	public void manger() {
	}
	

}
