package role;

import fourmilliere.Fourmi;
import tache.Dormir;
import tache.Manger;
import tache.Tache;

public class FourmiSexue extends Role {

	public FourmiSexue(Fourmi fourmi) {
		super(fourmi);
		this.tache = new Dormir(null);
	}

	//Le sexue ne fait que manger et dormir et n'est pas affiché a la simulation
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
