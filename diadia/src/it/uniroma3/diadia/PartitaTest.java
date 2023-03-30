package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
	}

	@Test
	public void testVintaSeStanzaCorrenteStanzaVincente() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}

	@Test
	public void testNonVintaSeStanzaCorrenteEQuellaIniziale() {
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testNonVintaSeStanzaCorrenteNonVincente() {
		this.partita.setStanzaCorrente(new Stanza("nuovaStanza"));
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testNonFinitaSeAppenaIniziata() {
		assertFalse(this.partita.isFinita());
	}

	@Test
	public void testFinitaSeFinita() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testFinitaSeCfu0() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}

}
