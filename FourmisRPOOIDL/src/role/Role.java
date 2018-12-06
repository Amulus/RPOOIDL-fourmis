package role;

import fourmilliere.Fourmi;
import tache.*;

public abstract class Role {
	Fourmi fourmi;
	Tache tache;
	public Role(Fourmi fourmi){
		this.fourmi=fourmi;
		nouvelleTache();
	}
	abstract public void nouvelleTache();
	
	public void step() {
		if(tache.estTermine()) {
			this.nouvelleTache();
		}
		tache.step(this.fourmi);
	}
	
	public void seNourir() {
		this.tache = new Manger();
	}
	public Tache getTache() {
		return this.tache;
	}
}
