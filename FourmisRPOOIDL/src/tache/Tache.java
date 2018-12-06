package tache;

import fourmilliere.Fourmi;

public abstract class Tache {
	protected int NbStep = 0;
	protected boolean termine = false;
	
	public abstract void step(Fourmi fourmis);
	
	public boolean estTermine() {
		return this.termine;
	}

	public int getNbStep() {
		return NbStep;
	}

	public void addStep() {
		NbStep = NbStep+1;
	}
}
