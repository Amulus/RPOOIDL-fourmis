package test;

import org.junit.Test;

import coucheGraphique.Monde;
import etat.Adulte;
import fourmilliere.Depot;
import fourmilliere.Fourmi;
import fourmilliere.Fourmilliere;
import role.FourmiOuvriere;

public class FourmiOuvriereTest {
	
	Fourmilliere fourmilliere;
	@Test
	public void test() {
		fourmilliere = new Fourmilliere(new Monde("test"));
		
		Fourmi ouvriere = new Fourmi(fourmilliere);
		ouvriere.changerEtat(new Adulte(ouvriere));
		ouvriere.getEtat().setRole(new FourmiOuvriere(ouvriere));
		
		
	}
}
