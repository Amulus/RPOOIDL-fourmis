package fourmilliere;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coucheGraphique.Monde;
import etat.Adulte;
import etat.Nymphe;
import outils.LireParametres;

public class Fourmilliere {

	private int nombreEtapeAvantRepas = 388*23;
	private List<Fourmi> morts = new ArrayList<Fourmi>();
	private List<Fourmi> fourmis = new ArrayList<Fourmi>();
	private List<Fourmi> fourmisEtapeAvant = new ArrayList<Fourmi>();
	private Depot Depot;
	private Monde monde =null;
	private Reserve Reserve;
	
	private LireParametres lectureFichier = new LireParametres();//Parametre de lecture du fichier de configuration

	//Initialise la fourmilliere avec:
	//un depot pour poser les morts
	//une reserve de nourriture a 9999, permet de faire vivre la fourmilliere pour la simulation
	//une nymphe et une reine
	public Fourmilliere(Monde monde) {
		this.fourmis = new ArrayList<Fourmi>();
		this.Depot = new Depot(this);
		this.Reserve = new Reserve(this);
		this.monde= monde;
		Fourmi fourmiReine = new Fourmi(this);
		Adulte adulte = new Adulte(fourmiReine);
		adulte.setReine();
		fourmiReine.changerEtat(adulte);
		Fourmi premiereNymphe = new Fourmi(this);
		Nymphe nymphe = new Nymphe(premiereNymphe);
		this.Reserve.AjouterNourriture(9999);
		premiereNymphe.changerEtat(nymphe);
		this.ajoutFourmi(fourmiReine);
		this.ajoutFourmi(premiereNymphe);
		
	}
	
	//Permet de faire les pas de toutes les fourmies
	//Verifie pour chaque fourmie si elle as manger a une certaine etape de la journee
	//fourmisEtapeAvant est un tableau pour eviter les exeptions
	public void step() {
		for(int i=0; i<fourmis.size();i++)
			fourmisEtapeAvant.add(fourmis.get(i));
		Iterator<Fourmi> it = this.fourmisEtapeAvant.iterator();
		while(it.hasNext()) {
			this.nombreEtapeAvantRepas-=1;
			Fourmi fourmi = it.next();
			if(this.nombreEtapeAvantRepas <= 0){
				if(verificationFaim(fourmi)) 
					fourmi.step();
			}else 
				fourmi.step();
		}
		if(this.nombreEtapeAvantRepas<=0)
			this.nombreEtapeAvantRepas=388*23;
		fourmisEtapeAvant.clear();
	}
	
	//Test si une fourmie a mangé ou sinon la tue
	public boolean verificationFaim(Fourmi fourmi) {
		boolean retour = true;
		if(this.nombreEtapeAvantRepas <= 0 && fourmi.getEtat().estAdulte()) 
			if(fourmi.getEtat().VerifierAlimentation()) {
				this.finDeVie(fourmi);
				retour = false;
			}
		return retour;
	}
	
	//Tue une fourmie
	public void finDeVie(Fourmi fourmi) {
		if(fourmi.etat.estAdulte())
			((Adulte)fourmi.etat).mourir();
	}

	public LireParametres getLireParametres() {
		return this.lectureFichier;
	}
	
	public List<Fourmi> getMorts() {
		return this.morts;
	}
	
	public List<Fourmi> getFourmis() {
		return fourmis;
	}


	public int nombreDeFourmis() {
		return this.getFourmis().size();
	}
	public Depot getDepot(){
		return this.Depot;
	}

	public Reserve getReserve(){
		return this.Reserve;
	}
	
	
	public void ajoutFourmi(Fourmi fourmi) {
		this.fourmis.add(fourmi);
	}

	public Monde getMonde() {	
		return this.monde;
	}

}
