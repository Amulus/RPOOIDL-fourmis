package fourmilliere;

public class Nymphe extends Evolution {
	
	private static int identifiantSuivant = 0;
	private int identifiant;
	
	public Nymphe(Fourmilliere fourmilliere) {
		super(fourmilliere);
		// TODO Auto-generated constructor stub
		this.identifiant = identifiantSuivant;
		identifiantSuivant++;
	}

	@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEtat() {
		// TODO Auto-generated method stub
		
	}
	public int getIdentifiant() {
		return this.identifiant;
	}
}
