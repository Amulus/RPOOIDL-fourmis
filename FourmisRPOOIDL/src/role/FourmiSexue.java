package role;

import fourmilliere.Fourmi;

public class FourmiSexue extends Role {

	public FourmiSexue(Fourmi fourmi) {
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
