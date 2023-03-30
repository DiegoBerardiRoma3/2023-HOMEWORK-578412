package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {

	private Giocatore giocatore;

	@Before
	public void setUp() throws Exception {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testGetInitalCfu() {
		assertEquals(20, this.giocatore.getCfu());
	}

}
