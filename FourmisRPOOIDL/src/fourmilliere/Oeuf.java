package fourmilliere;

public class Oeuf extends Evolution {
	
	
	
	public Oeuf(Fourmilliere fourmilliere) {
		super(fourmilliere);
		this.identifiant = identifiantSuivant;
		identifiantSuivant++;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		Larve larve = new Larve(this.fourmilliere,this.identifiant);
		this.fourmilliere.ajoutLarve(larve);
		this.fourmilliere.getOeufs().remove(this.identifiant);
		
	}
	@Override
	public void getEtat() {
		// TODO Auto-generated method stub
		
	}

}
