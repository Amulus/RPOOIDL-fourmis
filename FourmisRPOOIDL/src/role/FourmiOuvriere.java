package role;

import fourmilliere.Fourmi;
import tache.*;

public class FourmiOuvriere extends Role {

	public FourmiOuvriere(Fourmi fourmi) {
		super(fourmi);
	}


	@Override
	public void nouvelleTache(Tache tachePrecedente) {
		if(this.fourmi.getEtat().getFaim()) {
		}
		else {
			
		}
		
	}
}
