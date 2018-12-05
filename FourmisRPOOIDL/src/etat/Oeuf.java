package etat;

import fourmilliere.Fourmi;
import outils.LireParametres;

public class Oeuf extends Etat {
	
	
	public Oeuf(Fourmi fourmi) {
		super(fourmi);
		this.nombreStepExistence = 0;
		LireParametres lecturefichier = this.fourmi.getFourmilliere().getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionOeufs");
		this.nombreStepAvantEvolution = 60*24*this.nombreDeJourAvantEvolution;
		// TODO Auto-generated constructor stub
	}
	//@Override
	public void evoluer() {
		this.fourmi.changerEtat(new Larve(this.fourmi));
	}
	@Override
	public void step() {
		// TODO Auto-generated method stub
		this.nombreStepExistence++;
		if(this.nombreStepExistence >= 60*24*this.nombreDeJourAvantEvolution)
			this.evoluer();
	}
	@Override
	public void manger() {
		// TODO Auto-generated method stub
		
	}
	

}
