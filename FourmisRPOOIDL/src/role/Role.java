package role;

import evolution.Fourmi;

public abstract class Role {
	Fourmi fourmi;
	int Role=-1;
	public Role(Fourmi fourmi){
		this.fourmi=fourmi;
	}
	abstract public void setNumeroRole();
	abstract public int getNumeroRole();
	
}
