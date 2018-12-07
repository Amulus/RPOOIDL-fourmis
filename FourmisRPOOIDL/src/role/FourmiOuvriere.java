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
			this.tache = new Manger(tachePrecedente);
		}
		else {
			if(tachePrecedente!= null &&tachePrecedente.getType() == Tache.MANGER) {
				this.tache = new Nettoyer(tachePrecedente);
			}
			else if(tachePrecedente!= null &&tachePrecedente.getType() == Tache.NETTOYER) {
				this.tache = new Chasser(tachePrecedente,this.fourmi.getFourmilliere().getMonde().getProies());
			}
			else if(tachePrecedente== null || tachePrecedente.getType() == Tache.CHASSER) {
				this.tache = new Nettoyer(tachePrecedente);
			}
		}
		
	}
}
