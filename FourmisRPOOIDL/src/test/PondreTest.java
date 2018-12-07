package test;

import org.junit.Test;

import coucheGraphique.Monde;
import fourmilliere.Fourmilliere;

public class PondreTest {

	Fourmilliere fourmilliere;
	
	@Test
	public void test() {
		
		this.fourmilliere = new Fourmilliere(new Monde("test"));
		System.out.println(this.fourmilliere.getFourmis().size());
		for(int i=0; i<100;i++) {
			this.fourmilliere.getFourmis().get(0).step();
		}
		System.out.println(this.fourmilliere.getFourmis().size());
	}
	
}


