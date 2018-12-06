package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import etat.*;
import fourmilliere.*;

public class EvolutionTest {
	
	Fourmilliere fourmilliere;
	
	@Before
	public void setUp() throws Exception {
	}
	/*
	@Test
	public void testEvolution() {
		fourmilliere = new Fourmilliere();
		Fourmi fourmi = new Fourmi(fourmilliere);
		assertTrue(fourmi.getEtat().getClass() == Oeuf.class);
		fourmi.getEtat().evoluer();
		assertTrue(fourmi.getEtat().getClass() == Larve.class);
		fourmi.getEtat().evoluer();
		assertTrue(fourmi.getEtat().getClass() == Nymphe.class);
		fourmi.getEtat().evoluer();
		assertTrue(fourmi.getEtat().getClass() == Adulte.class);
		fourmi.getEtat().evoluer();
		assertTrue(fourmi.getEtat().getClass() == Adulte.class);
*/
		/*int identifiantDepart = 2;
		Oeuf oeuf = new Oeuf(fourmilliere.getNid());
		assertTrue(oeuf.getIdentifiant()==identifiantDepart);
		fourmilliere.ajoutOeuf(oeuf);
		assert(fourmilliere.getLarves().size()==0);
		oeuf.changerEtat();
		assert(fourmilliere.getLarves().size()>0);
		assertTrue(fourmilliere.getOeufs().get(identifiantDepart)==null);
		Larve larve = fourmilliere.getLarves().get(identifiantDepart);
		System.out.println(larve);
		assertTrue(larve != null);
		
		assertTrue(larve.getIdentifiant() == identifiantDepart);
		larve.changerEtat();
		assertTrue(fourmilliere.getLarves().get(identifiantDepart)==null);
		Nymphe nymphe = fourmilliere.getNymphes().get(identifiantDepart);
		assertTrue(nymphe != null);
		assertTrue(nymphe.getIdentifiant()==identifiantDepart);
		
		nymphe.changerEtat();
		assertTrue(fourmilliere.getNymphes().get(identifiantDepart)==null);
		Adulte fourmi = fourmilliere.getFourmis().get(identifiantDepart);
		assertTrue(fourmi != null);
		assertTrue(fourmi.getIdentifiant()==identifiantDepart);
	}*/
	/*
	@Test
	public void testEvolution2() {
		fourmilliere = new Fourmilliere();
		Fourmi fourmi = new Fourmi(fourmilliere);
		fourmi.step();
		fourmi.step();
		assertTrue(fourmi.getEtat().getStep()==2);
		
		Fourmi fourmi2 = new Fourmi(fourmilliere);
		for(int i=0;i<4319;i++) {
			fourmi2.step();
			assertTrue(fourmi2.getEtat().getClass() == Oeuf.class);
			
		}
		fourmi2.step();
		assertTrue(fourmi2.getEtat().getStep()==0);
		assertTrue(fourmi2.getEtat().getClass() == Larve.class);
		
	}*/
	@Test
	public void testGetEtat() {
		List<String> test = new ArrayList<String>();
		test.add("test");
		test.add("test2");
		
		test.remove("test");
		System.out.println(test.get(0));
	}

	@Test
	public void testGetIdentifiant() {
		fail("Not yet implemented");
	}
}
