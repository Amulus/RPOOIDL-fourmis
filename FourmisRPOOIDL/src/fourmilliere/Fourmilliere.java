package fourmilliere;

import java.util.Hashtable;

import outils.LireParametres;

public class Fourmilliere {

	private Hashtable<Integer,Adulte> fourmis = new Hashtable<Integer,Adulte>();
	private Hashtable<Integer,Oeuf> oeufs = new Hashtable<Integer,Oeuf>();
	private Hashtable<Integer,Nymphe> nymphes = new Hashtable<Integer,Nymphe>();
	private Hashtable<Integer,Larve> larves = new Hashtable<Integer,Larve>();
	
	
	private LireParametres lectureFichier = new LireParametres();

	public Fourmilliere() {
		Adulte fourmi = new Adulte(this);
		FourmiReine reine = new FourmiReine(fourmi);
		Nymphe nymphe = new Nymphe(this);
		
		this.fourmis.put(fourmi.getIdentifiant(), fourmi);
		this.nymphes.put(nymphe.getIdentifiant(),nymphe);
	}

	public Adulte getPremierAdulte() {
		return this.fourmis.get(0);
	}

	public LireParametres getLireParametres() {
		return this.lectureFichier;
	}
	
	public void ajoutOeuf(Oeuf oeuf) {
		this.oeufs.put(oeuf.getIdentifiant(),oeuf);
	}
	
	public void ajoutLarve(Larve larve) {
		this.larves.put(larve.getIdentifiant(), larve);
	}
	
	public void ajoutNymphe(Nymphe nymphe) {
		this.nymphes.put(nymphe.getIdentifiant(), nymphe);
	}
	
	public Hashtable<Integer, Adulte> getFourmis() {
		return fourmis;
	}

	public Hashtable<Integer, Oeuf> getOeufs() {
		return oeufs;
	}

	public Hashtable<Integer, Nymphe> getNymphes() {
		return nymphes;
	}

	public Hashtable<Integer, Larve> getLarves() {
		return larves;
	}

	public int nombreDeLarve() {
		return this.larves.size();
	}
	
	public int nombreDeFourmis() {
		return this.fourmis.size();
	}
	
	public int nombreDeNymphe() {
		return this.nymphes.size();
	}
	
	public int nombreOeuf() {
		return this.oeufs.size();
	}
	
}
