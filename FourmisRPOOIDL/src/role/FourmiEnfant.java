package role;

import fourmilliere.Fourmi;
import tache.Dormir;
import tache.Manger;
import tache.Tache;

public class FourmiEnfant extends Role {

	public FourmiEnfant(Fourmi fourmi) {
		super(fourmi);
		this.tache = new Dormir(null);
	}

	@Override
	public void nouvelleTache(Tache tachePrecedente) {
		if(this.fourmi.getEtat().getFaim()) {
			this.tache = new Manger(tachePrecedente);
		}
		else {
			this.tache = new Dormir(tachePrecedente);
		}
	}

}
