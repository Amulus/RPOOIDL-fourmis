package fourmilliere;

import java.util.ArrayList;
import java.util.List;

import etat.Adulte;
import etat.Nymphe;
import outils.LireParametres;

public class Fourmilliere {

	private List<Fourmi> morts = new ArrayList<Fourmi>();
	private List<Fourmi> fourmis = new ArrayList<Fourmi>();
	private Depot Depot;
	private Reserve Reserve;
	
	private LireParametres lectureFichier = new LireParametres();

	public Fourmilliere() {
		this.fourmis = new ArrayList<Fourmi>();
		this.Depot = new Depot(this);
		this.Reserve = new Reserve(this);
		Fourmi fourmiReine = new Fourmi(this);
		Adulte adulte = new Adulte(fourmiReine);
		adulte.setReine();
		fourmiReine.changerEtat(adulte);
		Fourmi premiereNymphe = new Fourmi(this);
		Nymphe nymphe = new Nymphe(premiereNymphe);
		premiereNymphe.changerEtat(nymphe);
		
		this.ajoutFourmi(fourmiReine);
		this.ajoutFourmi(premiereNymphe);
		
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
	/*
	public void affichage(){
		System.out.println("Nombre d'ouefs: "+this.nid.nombreOeuf());
		System.out.println("Nombre de larves: "+this.nid.nombreDeLarve());
		System.out.println("Nombre de Nymphes: "+this.nid.nombreDeNymphe());
		System.out.println("Nombre de Fourmies: "+this.nombreDeFourmis());
		int NombreOuvrieres = 0,NombreSoldats = 0,NombreReproducteurs = 0,NombreReine=0;
		for(int i=0; i< this.fourmis.size();i++){
			if(this.fourmis.get(i).getNumeroRole()==0){NombreReine++; break;}	
			if(this.fourmis.get(i).getNumeroRole()==1){NombreOuvrieres++; break;}
			if(this.fourmis.get(i).getNumeroRole()==2){NombreSoldats++; break;}
			if(this.fourmis.get(i).getNumeroRole()==3){NombreReproducteurs++; break;}	
		}
		System.out.println("Nombre de Fourmies Reine: "+NombreReine);
		System.out.println("Nombre de Fourmies Ouvrieres: "+NombreOuvrieres);
		System.out.println("Nombre de Fourmies Soldats: "+NombreSoldats);
		System.out.println("Nombre de Fourmies Reproducteurs: "+NombreReproducteurs);
		System.out.println("Nourriture dans la Reserve: "+this.Reserve.getReserveNouriture());
		System.out.println("Nombre de Morts: "+this.Depot.getNombreDeMorts());
		
	}
*/

}
