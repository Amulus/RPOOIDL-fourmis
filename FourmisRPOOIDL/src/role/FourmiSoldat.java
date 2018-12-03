package role;

import evolution.Adulte;

public class FourmiSoldat extends Role {

	public FourmiSoldat(Adulte fourmi) {
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
