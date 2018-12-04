package role;

import etat.Fourmi;

public abstract class Role {
	Fourmi fourmi;
	int Role=-1;
	public Role(Fourmi fourmi2){
		this.fourmi=fourmi2;
	}
	abstract public void setNumeroRole();
	abstract public int getNumeroRole();
	
}
