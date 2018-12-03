package fourmilliere;

public class FourmiReine extends FourmiSexue {

	public FourmiReine(Adulte fourmi) {
		super(fourmi);
	}
	public void pondre() {
		Oeuf oeuf = new Oeuf(this.fourmi.fourmilliere);
		this.fourmi.fourmilliere.ajoutOeuf(oeuf);
	}
}
