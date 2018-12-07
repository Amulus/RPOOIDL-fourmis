package role;

import fourmilliere.Fourmi;
import tache.Dormir;
import tache.Pondre;
import tache.Tache;

public class FourmiReine extends Role {

	public FourmiReine(Fourmi fourmi) {
		super(fourmi);
		this.tache = new Pondre(null);
	}

	@Override
	public void nouvelleTache(Tache tachePrecedente) {
		if (tachePrecedente !=null && tachePrecedente.getType() == Tache.PONDRE) {
			this.tache = new Dormir(tachePrecedente);
		} else {
			this.tache = new Pondre(tachePrecedente);
		}
	}
}
