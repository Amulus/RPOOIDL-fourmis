package evolution;
import fourmilliere.Fourmilliere;
import outils.LireParametres;
import role.FourmiOuvriere;
import role.FourmiReine;
import role.FourmiSexue;
import role.FourmiSoldat;
import role.Role;

public class Fourmi extends Adulte {
	private double Poid = 0.0;
	private double NouritureMangée = 0.0;
	private Role role = null;
	Boolean EstEnVie;
	
	public Fourmi(Fourmilliere fourmilliere, Role role, int identifiant) {
		super(fourmilliere);
		initialiser(this, identifiant);
		this.role = role;
	} 
	
	private void initialiser(Fourmi adulte, int identifiant) {
		LireParametres lecturefichier = fourmilliere.getLireParametres();
		this.Poid = GenererUnPoidDeFourmi((int) lecturefichier.ChercherParametre("PoidFourmiMinimum"),
			(int) lecturefichier.ChercherParametre("PoidFourmiMaximum"),
			(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie = true;
		this.identifiant = identifiant;
	}

	public Fourmi(Fourmilliere fourmilliere, int identifiant) {
		super(fourmilliere);
		LireParametres lecturefichier = fourmilliere.getLireParametres();
		initialiser(this, identifiant);
		GenererUnRole(this, (int) lecturefichier.ChercherParametre("PourcentageChanceOuvrier"),
				(int) lecturefichier.ChercherParametre("PourcentageChanceSoldat"),
				(int) lecturefichier.ChercherParametre("PourcentageChanceReproducteurs"));
	}

	private void GenererUnRole(Fourmi fourmi, int PourcentageChanceOuvrier, int PourcentageChanceSoldat,
			int PourcentageChanceSexue) {
		int RoleAleatoire = (int) Math
				.floor(Math.random() * PourcentageChanceOuvrier + PourcentageChanceSoldat + PourcentageChanceSexue+1);
		if (RoleAleatoire <= PourcentageChanceSexue)
			 fourmi.role = new FourmiSexue(fourmi);
		else
			if (RoleAleatoire <= PourcentageChanceSoldat)
				 fourmi.role = new FourmiSoldat(fourmi);
			else
				fourmi.role = new FourmiOuvriere(fourmi);
	}

	private void ChangerRoleSoldatEtOuvrier(Fourmi fourmi,Boolean Soldat){
		if(Soldat)
			fourmi.role =new FourmiSoldat(fourmi);
		else
			fourmi.role =new FourmiOuvriere(fourmi);
			
	}
	public double GenererUnPoidDeFourmi(int PoidFourmiMinimum, int PoidFourmiMaximum, double MultiplicateurDecimales) {
		// Genere un nombre entre 1.5 et 2
		return (double) Math.floor(Math.random() * (PoidFourmiMaximum - PoidFourmiMinimum) + 1 + PoidFourmiMinimum)
				* MultiplicateurDecimales;

	}

	public void VerifierAlimentation() {
		if (this.Poid *0.333 > NouritureMangée){
			this.EstEnVie = false;
			this.fourmilliere.getMorts().putIfAbsent(this.getIdentifiant(), this);
			this.fourmilliere.getFourmis().remove(this.getIdentifiant());
		}
	}
	
	public int getIdentifiant() {
		return this.identifiant;
	}

	
	public Role getRole(){
		return this.role;
	}
	public int getNumeroRole(){
		return this.role.getNumeroRole();
	}


	public Fourmilliere getFourmilliere() {
		return this.fourmilliere;
	}

	public void setReine() {
		this.role = new FourmiReine(this);
		
	}

	public double getPoid() {
		return this.Poid;
	}

	@Override
	public void changerEtat() {
	}

}
