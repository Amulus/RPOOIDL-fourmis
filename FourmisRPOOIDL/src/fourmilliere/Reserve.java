package fourmilliere;

public class Reserve {
	private long ReserveNouriture=0;
	Fourmilliere fourmilliere=null;
	
	public Reserve(Fourmilliere fourmilliere){
		this.fourmilliere=fourmilliere;
	}
	
	public void AjouterNourriture(int nourriture){
		this.ReserveNouriture+=nourriture;
	}
	public boolean PrendreNourriture(double nourriture){
		if(this.ReserveNouriture-nourriture>=0)
			this.ReserveNouriture-=nourriture;
		else
			return false;
		return true;
	}
	public boolean EstVide(){
		if(this.ReserveNouriture==0) return true;
		return false;
	}
	public long getReserveNouriture(){
		return this.ReserveNouriture;
	}
}
