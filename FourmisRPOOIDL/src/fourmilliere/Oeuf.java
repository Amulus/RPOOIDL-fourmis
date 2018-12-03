package fourmilliere;

public class Oeuf extends Evolution {
	
	private static int identifiantSuivant = 0;
	private int identifiant;
	public Oeuf(Fourmilliere fourmilliere) {
		super(fourmilliere);
		// TODO Auto-generated constructor stub
		this.identifiant = identifiantSuivant;
		identifiantSuivant++;
	}
	@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		Larve larve = new Larve(this.fourmilliere);
		
	}
	@Override
	public void getEtat() {
		// TODO Auto-generated method stub
		
	}
	public int getIdentifiant() {
		return this.identifiant;
	}
}
