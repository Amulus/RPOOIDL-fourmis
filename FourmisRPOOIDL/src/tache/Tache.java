package tache;


import fourmilliere.Fourmi;

public abstract class Tache {
	public static int PONDRE = 0;
	public static int MANGER = 1;
	public static int NETTOYER = 2;
	public static int DORMIR = 3;
	public static int CHASSER = 4;
	int typeTache;
	Tache tachePrecedente;
	protected int NbStep = 0;
	protected boolean termine = false;
	
	//Classe qui ajoute une tache a une fourmie
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
