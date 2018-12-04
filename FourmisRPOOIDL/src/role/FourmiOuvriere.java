package role;

import etat.Fourmi;

public class FourmiOuvriere extends Role {

	public FourmiOuvriere(Fourmi fourmi) {
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
