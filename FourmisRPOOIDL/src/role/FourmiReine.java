package role;

import fourmilliere.Fourmi;
import tache.Dormir;
import tache.Pondre;

public class FourmiReine extends Role {

	public FourmiReine(Fourmi fourmi) {
		super(fourmi);
	}
	public void pondre() {
		this.tache = new Pondre();
	}

	@Override
	public void nouvelleTache() {
		if(this.tache == null || this.tache.getClass() != Pondre.class){
			this.pondre();
		}else{
			this.tache = new Dormir();
		}
	}
}

