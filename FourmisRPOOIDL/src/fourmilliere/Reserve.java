package fourmilliere;

public class Reserve {
	private double ReserveNouriture=0.0;
	Fourmilliere fourmilliere=null;
	
	public Reserve(Fourmilliere fourmilliere){
		this.fourmilliere=fourmilliere;
	}
	
	public void AjouterNourriture(double nourriture){
		this.ReserveNouriture+=nourriture;
	}
	public boolean PrendreNourriture(double nourriture){
		if(this.ReserveNouriture-nourriture>=0.0)
			this.ReserveNouriture-=nourriture;
		else
			return false;
		return true;
	}
	public boolean EstVide(){
		if(this.ReserveNouriture==0.0) return true;
		return false;
	}
	public double getReserveNouriture(){
		return this.ReserveNouriture;
	}
}
