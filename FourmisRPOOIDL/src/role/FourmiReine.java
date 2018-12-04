package role;

import evolution.Fourmi;
import evolution.Oeuf;

public class FourmiReine extends Role {

	public FourmiReine(Fourmi fourmi) {
		super(fourmi);
		setNumeroRole();
	}
	
	public void pondre() {
		Oeuf oeuf = new Oeuf(this.fourmi.getFourmilliere().getNid());
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
