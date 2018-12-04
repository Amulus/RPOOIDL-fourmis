package role;

import fourmilliere.Fourmi;
public class FourmiReine extends Role {

	public FourmiReine(Fourmi fourmi) {
		super(fourmi);
		setNumeroRole();
	}
	
	public void pondre() {
		Fourmi nouvelleFourmi = new Fourmi(this.fourmi.getFourmilliere());
		this.fourmi.getFourmilliere().ajoutFourmi(nouvelleFourmi);
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
