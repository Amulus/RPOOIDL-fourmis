package role;

import fourmilliere.Fourmi;
import tache.*;

//classe qui représente le role de la fourmi, elle est stroké dans son état

public abstract class Role {
	Fourmi fourmi;
	Tache tache;
	public Role(Fourmi fourmi){
		this.fourmi=fourmi;
	}
	
	//fonction qui attribue une nouvelle tache à la fourmi lorsque la précèdente se termine
	abstract public void nouvelleTache(Tache tache);
	
	public void step() {
		if(tache.estTermine()) {
			this.nouvelleTache(this.getTache());
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
