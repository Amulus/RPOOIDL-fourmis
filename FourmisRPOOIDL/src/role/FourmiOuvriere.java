package role;

import evolution.Adulte;

public class FourmiOuvriere extends Role {

	public FourmiOuvriere(Adulte fourmi) {
		super(fourmi);
		this.setNumeroRole();
	}

	@Override
	public void setNumeroRole() {
		this.Role=1;
	}
	@Override
	public int getNumeroRole() {
		return this.Role;
	}
}
