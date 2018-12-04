package role;

import fourmilliere.Fourmi;
import tache.*;

public abstract class Role {
	Fourmi fourmi;
	Tache tache;
	int Role=-1;
	public Role(Fourmi fourmi2){
		this.fourmi=fourmi2;
	}
	abstract public void setNumeroRole();
	abstract public int getNumeroRole();
	public void step() {
		tache.step(this.fourmi);
	}
	
	public void seNourir() {
		this.tache = new Manger();
	}
	
}
