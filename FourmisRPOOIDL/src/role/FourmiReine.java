package role;

import fourmilliere.Fourmi;
import tache.Dormir;
import tache.Pondre;
import tache.Tache;

public class FourmiReine extends Role {

	public FourmiReine(Fourmi fourmi) {
		super(fourmi);
	}

	@Override
	public void nouvelleTache(Tache tachePrecedente) {
		if(this.tache == null || this.tache.getClass() != Pondre.class){
			this.tache = new Pondre(tachePrecedente);
		}else{
			this.tache = new Dormir(tachePrecedente);
		}
	}
}

