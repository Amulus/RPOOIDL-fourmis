package fourmilliere;

import java.util.Vector;

import outils.LireParametres;

public class Fourmilliere {

	private Vector<Adulte> fourmis;
	private Vector<Oeuf> oeufs;
	private Vector<Nymphe> nymphes;
	private Vector<Larve> larves;
	

	private LireParametres lectureFichier = new LireParametres();

	public Fourmilliere() {
		Adulte fourmi = new Adulte(this);
		FourmiReine reine = new FourmiReine(fourmi);
		Nymphe nymphe = new Nymphe(this);
		
		this.fourmis.addElement(fourmi);
		this.nymphes.addElement(nymphe);
	}

	public Adulte getPremierAdulte() {
		return this.fourmis.firstElement();
	}

	public LireParametres getLireParametres() {
		return this.lectureFichier;
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
