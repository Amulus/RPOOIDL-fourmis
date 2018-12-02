package fourmilliere;

public class FourmiSoldat extends Role {

	public FourmiSoldat(Adulte fourmi) {
		super(fourmi);
	}

	@Override
	public void setRole() {
		this.Role=2;
	}

}
