package role;

import fourmilliere.Fourmi;
import tache.*;

public abstract class Role {
	Fourmi fourmi;
	Tache tache;
	public Role(Fourmi fourmi){
		this.fourmi=fourmi;
	}
	abstract public void nouvelleTache(Tache tache);
	
	public void step() {
		if(tache.estTermine()) {
			this.nouvelleTache(this.getTache().getTachePrecedente());
		}
		tache.step(this.fourmi);
	}
	
	public Tache getTache() {
		return this.tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
}
