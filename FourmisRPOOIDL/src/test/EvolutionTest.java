package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import etat.*;
import fourmilliere.*;

public class EvolutionTest {
	
	Fourmilliere fourmilliere = new Fourmilliere();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEvolution() {
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
		assertTrue(fourmi.getIdentifiant()==identifiantDepart);*/
	}

	@Test
	public void testChangerEtat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEtat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdentifiant() {
		fail("Not yet implemented");
	}

}
