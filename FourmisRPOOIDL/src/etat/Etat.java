package etat;

import fourmilliere.Fourmi;
import role.Role;

public abstract class Etat {
	Role role;
	protected boolean aFaim = false;
	protected boolean estAdulte = false;
	protected boolean estDehors = false;
	protected int nombreDeJourAvantEvolution;
	protected int nombreStepAvantEvolution;
	public int nombreStepExistence;
	
	protected Fourmi fourmi;
	public Etat(Fourmi fourmi){
		this.fourmi = fourmi;
		
	}
	public boolean estAdulte() {
		return this.estAdulte;
	}
	
	public int getStep() {
		// TODO Auto-generated method stub
		return this.nombreStepExistence;
	}
	public int getNombreStepAvantEvolution() {
		return this.nombreStepAvantEvolution;
	}
	
	public boolean getFaim() {
		return this.aFaim;
	}
	
	public boolean estDehors() {
		return this.estDehors;
		
	}
	public abstract void evoluer();
	public abstract void step();
	
}
