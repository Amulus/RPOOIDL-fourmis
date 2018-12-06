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

	@Override
	public void nouvelleTache(Tache tachePrecedente) {
		// TODO Auto-generated method stub
		if(this.fourmi.getEtat().getFaim()) {
			this.tache = new Manger(tachePrecedente);
		}
		else {
			this.tache = new Dormir(tachePrecedente);
		}
	}


}
