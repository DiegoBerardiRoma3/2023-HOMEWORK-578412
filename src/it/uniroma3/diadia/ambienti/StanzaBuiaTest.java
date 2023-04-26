package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	private static final String DESCRIZIONE_STANZA = "StanzaBuia\n" + "Uscite: \n"
			+ "Attrezzi nella stanza: attrezzoLuceTest (1kg) ";

	@Before
	public void setUp() {
		this.stanzaBuia = new StanzaBuia("StanzaBuia", "attrezzoTest");
	}

	@Test
	public void testGetDescrizione() {
		assertEquals(StanzaBuia.DESCRIZIONE_STANZA_BUIA, this.stanzaBuia.getDescrizione());
	}

}