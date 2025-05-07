package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;

public class StanzaBloccataTest {
    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaNord;

    @BeforeEach
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("Magazzino", "nord", "piedeDiPorco");
        stanzaNord = new Stanza("Deposito");
        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaNord);
    }

    @Test
    public void testGetStanzaAdiacenteSbloccataConAttrezzo() {
        stanzaBloccata.addAttrezzo(new Attrezzo("piedeDiPorco", 1));
        assertEquals(stanzaNord, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteBloccataSenzaAttrezzo() {
        assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testDescrizioneConDirezioneBloccata() {
        String descrizione = stanzaBloccata.getDescrizione();
        assertTrue(descrizione.contains("bloccata"));
    }
}

