package test;

import org.junit.Test;

import evolution.Adulte;
import evolution.Larve;
import fourmilliere.Fourmilliere;
import tache.Manger;
import tache.Tache;

public class MangerTest {

	@Test
	public void test() {
		Fourmilliere fourmilliere = new Fourmilliere();
		assert(fourmilliere!=null);
		Adulte fourmi = new Adulte(fourmilliere,1);
		fourmilliere.getFourmis().put(1, fourmi);
		assert(fourmi!=null);
		Tache manger = new Manger();
		assert(manger!=null);
		Adulte fourmiMorte = new Adulte(fourmilliere,2);
		fourmilliere.getFourmis().put(2, fourmiMorte);
		Adulte fourmiMorte2 = new Adulte(fourmilliere,3);
		fourmilliere.getFourmis().put(3, fourmiMorte2);
		Adulte fourmiMorte3 = new Adulte(fourmilliere,4);
		fourmilliere.getFourmis().put(4, fourmiMorte3);
		assert(fourmiMorte!=null);
		Larve LarveMorte = new Larve(fourmilliere,0);
		assert(LarveMorte!=null);
		fourmilliere.getLarves().put(0, LarveMorte);
		fourmilliere.getLarves().get(0).VerifierAlimentation();
		fourmilliere.getFourmis().get(2).VerifierAlimentation();
		fourmilliere.getFourmis().get(3).VerifierAlimentation();
		fourmilliere.getFourmis().get(4).VerifierAlimentation();
		assert(fourmilliere.getMorts().size()==4);
		manger.execute(fourmi);
	}

}
