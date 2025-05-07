package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
    private String nomeAttrezzoLuminoso;

    public StanzaBuia(String nome, String nomeAttrezzoLuminoso) {
        super(nome);
        this.nomeAttrezzoLuminoso = nomeAttrezzoLuminoso;
    }

    @Override
    public String getDescrizione() {
        if (!this.hasAttrezzo(nomeAttrezzoLuminoso))
            return "Qui c'è un buio pesto";
        return super.getDescrizione(); // chiama il toString della stanza
    }
}

