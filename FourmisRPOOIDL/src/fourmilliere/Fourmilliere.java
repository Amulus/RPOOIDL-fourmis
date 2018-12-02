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

	}

	public Adulte getPremierAdulte() {
		return this.fourmis.firstElement();
	}

	public LireParametres getLireParametres() {
		return this.lectureFichier;
	}
}
