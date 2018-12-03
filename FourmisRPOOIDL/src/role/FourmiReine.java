package role;

import evolution.Adulte;
import evolution.Oeuf;

public class FourmiReine extends Role {

	public FourmiReine(Adulte fourmi) {
		super(fourmi);
		setNumeroRole();
	}
	
	public void pondre() {
		Oeuf oeuf = new Oeuf(this.fourmi.getFourmilliere());
		this.fourmi.getFourmilliere().ajoutOeuf(oeuf);
	}
	@Override
	public void setNumeroRole() {
		this.Role=0;
	}
	@Override
	public int getNumeroRole() {
		return this.Role;
	}
}
