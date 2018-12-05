package role;

import fourmilliere.Fourmi;
import tache.Dormir;
import tache.Manger;

public class FourmiEnfant extends Role {

	public FourmiEnfant(Fourmi fourmi) {
		super(fourmi);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void nouvelleTache() {
		// TODO Auto-generated method stub
		if(this.fourmi.getEtat().getFaim()) {
			this.tache = new Manger();
		}
		else {
			this.tache = new Dormir();
		}
	}

}
