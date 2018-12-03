package fourmilliere;

public class Nymphe extends Evolution {
	
	public Nymphe(Fourmilliere fourmilliere, int identifiant) {
		super(fourmilliere);
		// TODO Auto-generated constructor stub
		this.identifiant = identifiant;
	}

	@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		Adulte fourmi = new Adulte(this.fourmilliere,this.identifiant);
		this.fourmilliere.getFourmis().put(fourmi.getIdentifiant(), fourmi);
		this.fourmilliere.getNymphes().remove(this.identifiant);
	}

	@Override
	public void getEtat() {
		// TODO Auto-generated method stub
		
	}
	public int getIdentifiant() {
		return this.identifiant;
	}
}
