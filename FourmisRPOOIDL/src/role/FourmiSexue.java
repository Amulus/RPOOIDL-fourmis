package role;

import evolution.Adulte;

public class FourmiSexue extends Role {

	public FourmiSexue(Adulte fourmi) {
		super(fourmi);
		this.setNumeroRole();
	}

	@Override
	public void setNumeroRole() {
		this.Role=3;
	}
	@Override
	public int getNumeroRole() {
		return this.Role;
	}
}
