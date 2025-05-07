package it.uniroma3.diadia;

import java.util.Scanner;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class DiaDia {

    static final private String MESSAGGIO_BENVENUTO = ""
        + "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
        + "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
        + "I locali sono popolati da strani personaggi, alcuni amici, altri... chissa!\n"
        + "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
        + "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
        + "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
        + "Per conoscere le istruzioni usa il comando 'aiuto'.";

    private Partita partita;
    private IO io;

    // Costruttore aggiornato
    public DiaDia(IO io) {
        this.partita = new Partita();
        this.io = io;
    }

    public void gioca() {
        String istruzione;
        Scanner scannerDiLinee = new Scanner(System.in);

        io.mostraMessaggio(MESSAGGIO_BENVENUTO);
        do {
            istruzione = scannerDiLinee.nextLine();
        } while (!processaIstruzione(istruzione));
    }

    private boolean processaIstruzione(String istruzione) {
        Comando comandoDaEseguire;
        FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();

        comandoDaEseguire = factory.costruisciComando(istruzione);
        comandoDaEseguire.setIO(this.io);
        comandoDaEseguire.esegui(this.partita);

        this.io.mostraMessaggio("CFU: " + this.partita.getGiocatore().getCfu());
        this.io.mostraMessaggio("Contenuto borsa: " + this.partita.getGiocatore().getBorsa().toString());

        if (this.partita.vinta())
            this.io.mostraMessaggio("Hai vinto!");
        if (!this.partita.giocatoreIsVivo())
            this.io.mostraMessaggio("Hai esaurito i CFU...");

        return this.partita.isFinita();
    }

    public static void main(String[] argc) {
        IO io = new IOConsole(); // unica istanza creata qui
        DiaDia gioco = new DiaDia(io); // passata al costruttore
        gioco.gioca();
    }
}
