package dangelogregoriogarathread;

/**
 * Classe che rappresenta un calciatore che corre in una gara.
 * Ogni calciatore è un thread e avanza finché non arriva al traguardo.
 */
public class Calciatore extends Thread {

    private String nome;
    private int posizione;
    private FrameGara finestra;
    private static final int PASSI_ARRIVO = 70;

    public Calciatore(String nome, FrameGara finestra) {
        this.nome = nome;
        this.finestra = finestra;
        this.posizione = 0;
    }

    @Override
    public void run() {

        while (posizione < PASSI_ARRIVO) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException eccezione) {
                Thread.currentThread().interrupt();
            }

            posizione++;

            // aggiorna la posizione nella finestra
            finestra.aggiornaPosizioneCalciatore(nome, posizione);

            // controlla se capita un imprevisto
            Imprevisto imprevisto = GestioneImprevisti.generaImprevistoCasuale();

            if (imprevisto != null) {

                finestra.mostraMessaggio(nome + ": " + imprevisto.getDescrizione());

                if (imprevisto.isNegativo()) {
                    finestra.calciatoreCaduto(nome);
                }

                posizione += imprevisto.getEffetto();

                if (posizione < 0) posizione = 0;
            }
        }

        finestra.calciatoreArrivato(nome);
    }

    public String getNome() {
        return nome;
    }

    public int getPosizione() {
        return posizione;
    }
}