package etat;
import fourmilliere.Fourmi;
import fourmilliere.Reserve;
import outils.LireParametres;
import role.FourmiOuvriere;
import role.FourmiReine;
import role.FourmiSexue;
import role.FourmiSoldat;
import role.Role;

public class Adulte extends Etat {
	
	private int dureeDeVieEnMois = 0;
	private int dureeMinuteEnVie = 0;
	private Role role = null;
	protected Boolean EstEnVie;
	
	
	
	private void initialiser(Fourmi fourmi) {
		this.nombreStepExistence = 0;
		LireParametres lecturefichier = fourmi.getFourmilliere().getLireParametres();
		this.poid = GenererUnPoidDeFourmi((int) lecturefichier.ChercherParametre("PoidFourmiMinimum"),
			(int) lecturefichier.ChercherParametre("PoidFourmiMaximum"),
			(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie = true;
		this.estAdulte=true;
		this.dureeDeVieEnMois = this.GenererEntierMinMax((int)lecturefichier.ChercherParametre("dureeDeVieFourmiMin"),
			(int)lecturefichier.ChercherParametre("dureeDeVieFourmiMax"));
	}

	public Adulte(Fourmi fourmi) {
		super(fourmi);
		LireParametres lecturefichier = fourmi.getFourmilliere().getLireParametres();
		initialiser(fourmi);
		GenererUnRole((int) lecturefichier.ChercherParametre("PourcentageChanceOuvrier"),
				(int) lecturefichier.ChercherParametre("PourcentageChanceSoldat"),
				(int) lecturefichier.ChercherParametre("PourcentageChanceReproducteurs"));
	}
	
	
	private void GenererUnRole( int PourcentageChanceOuvrier, int PourcentageChanceSoldat,
			int PourcentageChanceSexue) {
		int RoleAleatoire = (int) Math
				.floor(Math.random() * PourcentageChanceOuvrier + PourcentageChanceSoldat + PourcentageChanceSexue+1);
		if (RoleAleatoire <= PourcentageChanceSexue)
			 this.role = new FourmiSexue(this.fourmi);
		else
			if (RoleAleatoire <= PourcentageChanceSoldat)
				 this.role = new FourmiSoldat(this.fourmi);
			else
				this.role = new FourmiOuvriere(this.fourmi);
	}

	public void ChangerRoleSoldatEtOuvrier(Boolean Soldat){
		if(Soldat)
			this.role =new FourmiSoldat(this.fourmi);
		else
			this.role =new FourmiOuvriere(this.fourmi);
			
	}
	public static double GenererUnPoidDeFourmi(int PoidFourmiMinimum, int PoidFourmiMaximum, double MultiplicateurDecimales) {
		// Genere un nombre entre 1.5 et 2
		return (double) Math.floor(Math.random() * (PoidFourmiMaximum - PoidFourmiMinimum) + 1 + PoidFourmiMinimum)
				* MultiplicateurDecimales;

	}
	public int GenererEntierMinMax(int dureeMini, int dureeMaxi) {
		return (int) Math.floor(Math.random() * (dureeMaxi - dureeMini) + 1 + dureeMini);
	}
	
	public Role getRole(){
		return this.role;
	}


	public void setReine() {
		LireParametres lecturefichier = this.fourmi.getFourmilliere().getLireParametres();
		this.role = new FourmiReine(this.fourmi);
		this.dureeDeVieEnMois = this.GenererEntierMinMax((int)lecturefichier.ChercherParametre("dureeDeVieReineMin"),
				(int)lecturefichier.ChercherParametre("dureeDeVieReineMax"));
		
	}
	public boolean estDehors() {
		return this.estDehors;
	}
	
	public void sortir() {
		this.estDehors = true;
		this.tempsDehorsMax = GenererEntierMinMax(10,12);
	}
	
	public void rentrer() {
		this.estDehors = false;
	}
	
	public double getPoid() {
		return this.poid;
	}
	public void mourir(){
		this.EstEnVie=false;
		if(!this.fourmi.getFourmilliere().getMorts().contains(this.fourmi))
			this.fourmi.getFourmilliere().getMorts().add(this.fourmi);
	}

	public void vie() {
		this.EstEnVie=true;
		this.tempsDehors=0;
		
	}
	/*
	public void jourSuivant() {
		if(this.VerifierAlimentation()) 
			this.mourir();
	}
	
	@Override
	void heureSuivant() {
		// TODO Auto-generated method stub
		if(this.tempsDehors > this.tempsDehorsMax ) {
			this.mourir();
		}
		
	}

	@Override
	void minuteSuivant() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void moisSuivant() {
		// TODO Auto-generated method stub
		this.dureeDeVieEnMois--;
		if(this.dureeDeVieEnMois == 0) {
			this.mourir();
		}
	}
	 */

	@Override
	public void evoluer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		if(this.estDehors){
			if(this.role.getTache().getNbStep()%100==0 && this.role.getTache().getNbStep()!=0 )
				this.tempsDehors++;
			if(this.tempsDehors>this.tempsDehorsMax) {
				this.fourmi.getFourmilliere().fourmisMorteDehors(this.fourmi);
			}
		}
		if(this.role.getTache().getNbStep()%6==0 && this.role.getTache().getNbStep()!=0 )
			this.dureeMinuteEnVie++;
		if( this.dureeMinuteEnVie >= 6*24*30*this.dureeDeVieEnMois) {
			this.fourmi.getFourmilliere().finDeVie(this.fourmi);
		}
		this.role.getTache().step(this.fourmi);
	}

	@Override
	public void manger() {
		// TODO Auto-generated method stub
		Reserve reserve = this.fourmi.getFourmilliere().getReserve();
		if(reserve.PrendreNourriture(this.poid*0.33)) {
			this.aFaim = false;
		}
	}

	public boolean estEnvie() {
		return this.EstEnVie;
	}


}
