package fourmilliere;

public class FourmiOuvriere extends Role {

	public FourmiOuvriere(Adulte fourmi) {
		super(fourmi);
	}

	@Override
	public void setRole() {
		this.Role=1;
	}

}
