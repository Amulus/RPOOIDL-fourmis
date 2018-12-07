package etat;

import fourmilliere.Fourmi;
import outils.LireParametres;

public class Nymphe extends Etat {
	
	
	public Nymphe(Fourmi fourmi) {
		super(fourmi);
		this.nombreStepExistence = 0;
		LireParametres lecturefichier = fourmi.getFourmilliere().getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionNymphes");
	}

	public void evoluer() {
		this.fourmi.changerEtat(new Adulte(this.fourmi));
		this.estAdulte = true;
	}

	//Attend a chaque step de pouvoir evoluer
	@Override
	public void step() {
		this.nombreStepExistence++;
		if(this.nombreStepExistence == 388*this.nombreDeJourAvantEvolution);
			this.evoluer();
	}

	@Override
	public void manger() {
	}
}