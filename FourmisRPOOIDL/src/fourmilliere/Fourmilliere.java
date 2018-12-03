package fourmilliere;

import java.util.Hashtable;
import java.util.Vector;

import outils.LireParametres;

public class Fourmilliere {

	private Hashtable<Integer,Adulte> fourmis;
	private Hashtable<Integer,Oeuf> oeufs;
	private Hashtable<Integer,Nymphe> nymphes;
	private Hashtable<Integer,Larve> larves;
	
	
	private LireParametres lectureFichier = new LireParametres();

	public Fourmilliere() {
		Adulte fourmi = new Adulte(this);
		FourmiReine reine = new FourmiReine(fourmi);
		Nymphe nymphe = new Nymphe(this);
		
		this.fourmis.put(fourmi.getIdentifiant(), fourmi);
		this.nymphes.put(nymphe.getIdentifiant(),nymphe);
	}

	public Adulte getPremierAdulte() {
		return this.fourmis.firstElement();
	}

	public LireParametres getLireParametres() {
		return this.lectureFichier;
	}
	
	public void ajoutOeuf(Oeuf oeuf) {
		this.oeufs.add(oeuf);
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
