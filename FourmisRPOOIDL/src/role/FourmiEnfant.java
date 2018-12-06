package role;

import fourmilliere.Fourmi;
import tache.Dormir;
import tache.Manger;

public class FourmiEnfant extends Role {

	public FourmiEnfant(Fourmi fourmi) {
		super(fourmi);
	}

	@Override
	public void nouvelleTache() {
		if(this.fourmi.getEtat().getFaim()) {
			this.tache = new Manger();
		}
		else {
			this.tache = new Dormir();
		}
	}

}
