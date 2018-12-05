package fourmilliere;

import etat.Etat;
import etat.Oeuf;

public class Fourmi {
	protected Fourmilliere fourmilliere;
	Etat etat;
	protected boolean estDehors = false;
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
	
	
	public Etat getEtat() {
		return this.etat;
	}

	public void step() {
		this.etat.step();
	}

}
