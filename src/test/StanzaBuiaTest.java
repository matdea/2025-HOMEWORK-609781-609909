package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;

public class StanzaBuiaTest {
    private StanzaBuia stanzaBuia;

    @BeforeEach
    public void setUp() {
        stanzaBuia = new StanzaBuia("Cantina", "candela");
    }

    @Test
    public void testDescrizioneConAttrezzoLuminoso() {
        stanzaBuia.addAttrezzo(new Attrezzo("candela", 1));
        assertFalse(stanzaBuia.getDescrizione().contains("buio pesto"));
    }

    @Test
    public void testDescrizioneSenzaAttrezzoLuminoso() {
        stanzaBuia.addAttrezzo(new Attrezzo("chiave", 1));
        assertEquals("Qui c'è un buio pesto", stanzaBuia.getDescrizione());
    }
}
