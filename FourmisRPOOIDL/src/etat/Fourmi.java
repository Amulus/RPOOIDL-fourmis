package etat;

import fourmilliere.Fourmilliere;

public class Fourmi {
	protected Fourmilliere fourmilliere;
	Etat etat;
	public Fourmi(Fourmilliere fourmilliere){
		this.fourmilliere = fourmilliere;
		this.etat = new Oeuf(this);
	}
	
	public void changerEtat(Etat etat) {
		this.etat = etat;
	}
	
	public Fourmilliere getFourmilliere() {
		return this.fourmilliere;
	}
	
	void step() {
		
	}

}
