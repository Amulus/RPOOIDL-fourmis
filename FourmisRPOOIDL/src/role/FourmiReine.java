package role;

import evolution.Adulte;
import evolution.Oeuf;
import fourmilliere.Fourmilliere;

public class FourmiReine extends FourmiSexue {

	public FourmiReine(Adulte fourmi) {
		super(fourmi);
	}
	private Fourmilliere getFourmilliere(){
		return this.fourmi.getFourmilliere();
	}
	public void pondre() {
		Oeuf oeuf = new Oeuf(getFourmilliere());
		getFourmilliere().ajoutOeuf(oeuf);
	}
}
