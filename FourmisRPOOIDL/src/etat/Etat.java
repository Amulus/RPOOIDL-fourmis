package etat;

import fourmilliere.Fourmi;
import role.Role;

public abstract class Etat {
	
	protected double poid = 0.0;
	protected double nouritureMangée = 0.0;
	protected double stockage = 0.0;
	protected int tempsDehors = 0;
	protected int tempsDehorsMax = 0;
	Role role;
	protected boolean aFaim = false;
	protected boolean estAdulte = false;
	protected boolean estDehors = false;
	protected int nombreDeJourAvantEvolution;
	protected int nombreStepAvantEvolution;
	public int nombreStepExistence;
	
	protected Fourmi fourmi;
	public Etat(Fourmi fourmi){
		this.fourmi = fourmi;
		
	}
	public boolean VerifierAlimentation(){
		boolean retour = (this.poid*0.333>nouritureMangée);
		this.nouritureMangée = 0.0;
		this.aFaim = true;
		return retour;

	}
	
	public boolean estAdulte() {
		return this.estAdulte;
	}
	
	public int getStep() {
		// TODO Auto-generated method stub
		return this.nombreStepExistence;
	}
	public int getNombreStepAvantEvolution() {
		return this.nombreStepAvantEvolution;
	}
	
	public boolean getFaim() {
		return this.aFaim;
	}
	public double getPoid(){
		return this.poid;
	}
	
	public double getStockage() {
		return this.stockage;
	}
	
	public boolean estDehors() {
		return this.estDehors;
		
	}
	public int tempsDehorsMax(){
		return this.tempsDehorsMax;
	}
	public int tempsPasseDehors() {
		return this.tempsDehors;
	}

	public void ajoutTempPasseDehors() {
		this.tempsDehors = this.tempsDehors+1;
	}
	
	public void setStockage(double value) {
		this.stockage = value;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setRole(Role nouveauRole) {
		this.role = nouveauRole;
	}
	
	public abstract void evoluer();
	public abstract void step();
	public abstract void manger();
	
}
