package etat;

import fourmilliere.Fourmi;

public abstract class Etat {
	protected boolean estAdulte = false;
	protected boolean estDehors = false;
	protected int nombreDeJourAvantEvolution;
	protected int nombreStepAvantEvolution;
	public int nombreStepExistence;
	
	protected Fourmi fourmi;
	public Etat(Fourmi fourmi){
		this.fourmi = fourmi;
		
	}
	public boolean isAdulte() {
		return this.estAdulte;
	}
	
	public int getStep() {
		// TODO Auto-generated method stub
		return this.nombreStepExistence;
	}
	public int getNombreStepAvantEvolution() {
		return this.nombreStepAvantEvolution;
	}
	public abstract void evoluer();
	public abstract void step();
	
}
