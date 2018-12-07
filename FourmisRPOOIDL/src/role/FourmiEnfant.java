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

	//La fourmie enfant ne fait que se nourrir et dormir (Larve) elles ne sont pas affiché a la simulation
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
