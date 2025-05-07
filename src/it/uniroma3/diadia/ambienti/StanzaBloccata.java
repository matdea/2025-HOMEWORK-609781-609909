package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
    private String direzioneBloccata;
    private String nomeAttrezzoSbloccante;

    public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSbloccante) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.nomeAttrezzoSbloccante = nomeAttrezzoSbloccante;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
            return this; // stanza bloccata → non ti muovi
        }
        return super.getStanzaAdiacente(direzione); // comportamento normale
    }

    @Override
    public String getDescrizione() {
        if (!this.hasAttrezzo(this.nomeAttrezzoSbloccante))
            return super.getDescrizione() + "\nDirezione bloccata: " + this.direzioneBloccata +
                   " (serve '" + this.nomeAttrezzoSbloccante + "')";
        return super.getDescrizione(); // normale
    }
}

