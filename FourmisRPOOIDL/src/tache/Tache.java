package tache;

import java.util.ArrayList;
import java.util.List;

import fourmilliere.Fourmi;

public abstract class Tache {
	protected int NbStep = 0;
	protected boolean termine = false;
	List<Couple<Integer,Object>> listAction = new ArrayList<Couple<Integer,Object>>();
	
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
