package role;

import evolution.Fourmi;

public class FourmiSoldat extends Role {

	public FourmiSoldat(Fourmi fourmi) {
		super(fourmi);
		this.setNumeroRole();
	}

	@Override
	public void setNumeroRole() {
		this.Role=2;
	}

	@Override
	public int getNumeroRole() {
		return this.Role;
	}

}
