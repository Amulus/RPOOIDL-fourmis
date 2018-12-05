package role;

import fourmilliere.Fourmi;
import tache.*;

public class FourmiOuvriere extends Role {

	public FourmiOuvriere(Fourmi fourmi) {
		super(fourmi);
	}

	public void nourrirLarve() {
		this.tache = new NourirLarves();
	}
	
	public void chasser() {
		this.tache = new Chasser();
	}
	
	public void nettoyer() {
		this.tache = new Nettoyer();
	}

	@Override
	public void nouvelleTache() {
		if(this.fourmi.getEtat().getFaim()) {
			this.seNourir();
		}
		else {
			this.chasser();
		}
		
	}
}
