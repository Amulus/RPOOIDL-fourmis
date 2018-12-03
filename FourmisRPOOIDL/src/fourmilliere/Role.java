package fourmilliere;

public abstract class Role {
	Adulte fourmi;
	int Role=-1;
	public Role(Adulte fourmi){
		this.fourmi=fourmi;
	}
	abstract public void setRole();
	
}
