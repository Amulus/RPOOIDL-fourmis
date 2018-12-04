package test;

import org.junit.Test;

import evolution.Fourmi;
import evolution.Larve;
import fourmilliere.Fourmilliere;
import tache.Manger;
import tache.Tache;

public class MangerTest {

	@Test
	public void test() {
		Fourmilliere fourmilliere = new Fourmilliere();
		assert(fourmilliere!=null);
		Fourmi fourmi = new Fourmi(fourmilliere,1);
		fourmilliere.getFourmis().put(1, fourmi);
		assert(fourmi!=null);
		Tache manger = new Manger();
		assert(manger!=null);
		Fourmi fourmiMorte = new Fourmi(fourmilliere,2);
		fourmilliere.getFourmis().put(2, fourmiMorte);
		Fourmi fourmiMorte2 = new Fourmi(fourmilliere,3);
		fourmilliere.getFourmis().put(3, fourmiMorte2);
		Fourmi fourmiMorte3 = new Fourmi(fourmilliere,4);
		fourmilliere.getFourmis().put(4, fourmiMorte3);
		assert(fourmiMorte!=null);
		Larve LarveMorte = new Larve(fourmilliere.getNid(),0);
		assert(LarveMorte!=null);
		fourmilliere.getLarves().put(0, LarveMorte);
		fourmilliere.getLarves().get(0).mourir();
		fourmilliere.getFourmis().get(2).mourir();
		fourmilliere.getFourmis().get(3).mourir();
		fourmilliere.getFourmis().get(4).mourir();
		assert(fourmilliere.getMorts().size()==4);
		manger.execute(fourmi);
	}

}
