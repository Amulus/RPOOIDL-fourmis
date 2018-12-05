package etat;

import fourmilliere.Fourmi;

public abstract class Etat {
	protected boolean estAdulte = false;
	protected boolean estDehors = false;
	protected Fourmi fourmi;
	public Etat(Fourmi fourmi){
		this.fourmi = fourmi;
		
	}
	public boolean isAdulte() {
		return this.estAdulte;
	}
	public abstract void evoluer();
	public abstract void step();
}
