package test;

import org.junit.Test;

import coucheGraphique.Monde;
import fourmilliere.Fourmi;
import fourmilliere.Fourmilliere;

public class FourmiReineTest {
	Fourmilliere fourmilliere;
	
	@Test
	public void test() {
		fourmilliere = new Fourmilliere(new Monde("test"));
		
		Fourmi reine = fourmilliere.getFourmis().get(0);
		
	}
}
