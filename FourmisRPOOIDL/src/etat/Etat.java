package etat;

import fourmilliere.Fourmi;

public abstract class Etat {
	
	protected Fourmi fourmi;
	public Etat(Fourmi fourmi){
		this.fourmi = fourmi;
		
	}
	
	public abstract void evoluer();
}
