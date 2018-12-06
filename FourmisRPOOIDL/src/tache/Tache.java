package tache;

import java.util.ArrayList;
import java.util.List;

import fourmilliere.Fourmi;

public abstract class Tache {
	protected static int PONDRE = 0;
	protected static int MANGER = 1;
	protected static int NETTOYER = 2;
	protected static int DORMIR = 3;
	protected static int CHASSER = 4;
	int typeTache;
	Tache tachePrecedente;
	protected int NbStep = 0;
	protected boolean termine = false;
	
	
	public abstract void step(Fourmi fourmis);
	
	Tache(Tache tachePrecedente){
		this.tachePrecedente = tachePrecedente;
	}
	
	public boolean estTermine() {
		return this.termine;
	}

	public int getNbStep() {
		return NbStep;
	}

	public void addStep() {
		NbStep = NbStep+1;
	}
	
	public Tache getTachePrecedente() {
		return tachePrecedente;
		
	}
	
	public int getType() {
		return this.typeTache;
	}
}
