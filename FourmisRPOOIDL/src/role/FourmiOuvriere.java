package role;

import fourmilliere.Fourmi;
import tache.*;

public class FourmiOuvriere extends Role {

	public FourmiOuvriere(Fourmi fourmi) {
		super(fourmi);
		this.tache = new Chasser(null, fourmi.getFourmilliere().getMonde().getProies());
	}


	@Override
	public void nouvelleTache(Tache tachePrecedente) {
		if(this.fourmi.getEtat().getFaim()) {
		}
		else {
			
		}
		
	}
}
