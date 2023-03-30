package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanza;

	@Before
	public void setUp() throws Exception {
		this.stanza = new Stanza("nuovaStanza");
	}

	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzoTest = new Attrezzo("attrezzoTest", 1);

		this.stanza.addAttrezzo(attrezzoTest);
		assertEquals(attrezzoTest, this.stanza.getAttrezzo("attrezzoTest"));
	}

	@Test
	public void testAddAttrezziOltreMassimo() {
		for (int i = 0; i < 10; i++) {
			Attrezzo attrezzoSemplice = new Attrezzo("attrezzoTest" + i, 1);
			assertTrue(this.stanza.addAttrezzo(attrezzoSemplice));
		}
		Attrezzo attrezzoDiTroppo = new Attrezzo("attrezzoErrore", 1);
		assertFalse(this.stanza.addAttrezzo(attrezzoDiTroppo));
	}

	@Test
	public void testHasAttrezzoTrue() {
		Attrezzo nuovoAttrezzo = new Attrezzo("attrezzoTest", 1);
		this.stanza.addAttrezzo(nuovoAttrezzo);
		assertTrue(this.stanza.hasAttrezzo(nuovoAttrezzo.getNome()));
	}

	@Test
	public void testHasAttrezzoFalseAttrezzoInsistente() {
		Attrezzo nuovoAttrezzo = new Attrezzo("attrezzoTest", 1);
		this.stanza.addAttrezzo(nuovoAttrezzo);
		assertFalse(this.stanza.hasAttrezzo("attrezzoInesistente"));
	}

	@Test
	public void testHasAttrezzoFalseSeCapienzaMax() {
		for (int i = 0; i < 10; i++) {
			Attrezzo attrezzoTest = new Attrezzo("attrezzoTest" + i, 1);
			this.stanza.addAttrezzo(attrezzoTest);
		}
		Attrezzo attrezzoErrore = new Attrezzo("attrezzoErrore", 1);
		this.stanza.addAttrezzo(attrezzoErrore);
		assertFalse(this.stanza.hasAttrezzo(attrezzoErrore.getNome()));
	}

	@Test
	public void testRemoveAttrezzoERimosso() {
		Attrezzo nuovoAttrezzo = new Attrezzo("attrezzoTest", 1);
		this.stanza.addAttrezzo(nuovoAttrezzo);
		assertTrue(this.stanza.hasAttrezzo(nuovoAttrezzo.getNome()));

		this.stanza.removeAttrezzo(this.stanza.getAttrezzo("attrezzoTest"));
		assertFalse(this.stanza.hasAttrezzo("attrezzoTest"));
	}

	@Test
	public void testRemoveAttrezzoInesistente() {
		Attrezzo nuovoAttrezzo = new Attrezzo("attrezzoTest", 1);
		this.stanza.addAttrezzo(nuovoAttrezzo);
		assertTrue(this.stanza.hasAttrezzo(nuovoAttrezzo.getNome()));

		Attrezzo attrezzoInesistente = new Attrezzo("attrezzoInesistente", 1);

		assertFalse(this.stanza.removeAttrezzo(attrezzoInesistente));
	}

	@Test
	public void testRemoveAttrezzo() {
		Attrezzo nuovoAttrezzo = new Attrezzo("attrezzoTest", 1);
		this.stanza.addAttrezzo(nuovoAttrezzo);
		assertTrue(this.stanza.hasAttrezzo(nuovoAttrezzo.getNome()));

		assertTrue(this.stanza.removeAttrezzo(nuovoAttrezzo));
	}

}
