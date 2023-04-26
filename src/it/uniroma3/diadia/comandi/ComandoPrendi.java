package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private static final String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
//		if (!partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {
//			this.io.mostraMessaggio("Attrezzo " + this.nomeAttrezzo + " non presente nella stanza");
//			return;
//		}
//		Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
//		boolean attrezzoPreso = partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
//		if (!attrezzoPreso) {
//			this.io.mostraMessaggio("Non c'è più spazio per nuovi attrezzi nella borsa");
//			return;
//		}
//		partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
//		this.io.mostraMessaggio("Attrezzo " + this.nomeAttrezzo + " preso!");

		if (nomeAttrezzo == null) {
			this.io.mostraMessaggio("inserisci nome attrezzo");
			return;
		}
		if (!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			this.io.mostraMessaggio("questa stanza non ha questo attrezzo");
			return;
		}
		Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere) == false) {
			this.io.mostraMessaggio(
					"borsa è piena, non e' stato possibile prendere l'oggetto e inserirlo nella stanza");
			return;
		}
		partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
		this.io.mostraMessaggio("attrezzo preso e inserito in borsa ");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}