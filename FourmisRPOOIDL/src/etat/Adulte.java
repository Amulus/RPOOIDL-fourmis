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
	
	//fonction qui génère un entier dans une fourchette de 2 entier
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
		this.fourmi.getFourmilliere().fourmisDedans--;
		this.fourmi.getFourmilliere().fourmisDehors++;
	}
	
	public void rentrer() {
		this.estDehors = false;
		this.fourmi.getFourmilliere().fourmisDedans++;
		this.fourmi.getFourmilliere().fourmisDehors--;
	}
	
	public double getPoid() {
		return this.poid;
	}
	public void mourir(){
		this.EstEnVie=false;
		if(!this.fourmi.getFourmilliere().getMorts().contains(this.fourmi))
			this.fourmi.getFourmilliere().getMorts().add(this.fourmi);
		if(this.fourmi.getFourmilliere().getFourmis().contains(this.fourmi))
			this.fourmi.getFourmilliere().getFourmis().remove(this.fourmi);
	}

	public void vie() {
		this.EstEnVie=true;
		this.tempsDehors=0;
		
	}
	
	//cette fonction ne fait rien car la fourmi est Adulte
	@Override
	public void evoluer() {
		
	}
	//on vérifie le temps passé dehors à chaque étape pour savoir si la fourmi meurt d'épuisement
	@Override
	public void step() {
		if(this.estDehors){
			if(this.role.getTache().getNbStep()%500==0 && this.role.getTache().getNbStep()>1 )
				this.tempsDehors+=1;
			if(this.tempsDehors>this.tempsDehorsMax) {
				this.fourmi.getFourmilliere().fourmisMorteDehors(this.fourmi);
			}
		}else
			this.tempsDehors=0;
		if(this.role.getTache().getNbStep()%6==0 && this.role.getTache().getNbStep()!=0 )
			this.dureeMinuteEnVie++;
		if( this.dureeMinuteEnVie >= 6*24*30*this.dureeDeVieEnMois) {
			this.fourmi.getFourmilliere().finDeVie(this.fourmi);
		}
		this.role.step();
	}

	@Override
	public void manger() {
		Reserve reserve = this.fourmi.getFourmilliere().getReserve();
		if(reserve.PrendreNourriture(this.poid*0.33)) {
			this.nouritureMangée=this.poid*0.33;
			this.aFaim = false;
		}
	}

	public boolean estEnvie() {
		return this.EstEnVie;
	}


}
