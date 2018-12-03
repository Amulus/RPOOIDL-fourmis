package fourmilliere;

public abstract class Evolution {
	Fourmilliere fourmilliere;
	public Evolution(Fourmilliere fourmilliere){
		this.fourmilliere=fourmilliere;
	}
	public abstract void changerEtat();
	public abstract void getEtat();
}
