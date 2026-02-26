package dangelogregoriogarathread;

/**
 * Classe che rappresenta un calciatore che corre in una gara.
 * Ogni calciatore è un thread e avanza finché non arriva al traguardo.
 */
public class Calciatore extends Thread {

    private String nome; //nome
    private int posizione;
    private FrameGara finestra;
    private static final int passiArrivo = 70;
    private boolean caduto = false;

    public Calciatore(String nome, FrameGara finestra) {
        this.nome = nome;
        this.finestra = finestra;
        this.posizione = 0;
    }

    public synchronized void rialzati() {
        caduto = false;
        notify();
    }
    
    @Override
   public void run() {

        while (posizione < passiArrivo) {

            // se è caduto aspetta finché non viene rialzato
            synchronized (this) {
                while (caduto) {
                    try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException eccezione) {
                Thread.currentThread().interrupt();
            }

            posizione++;
            finestra.aggiornaPosizioneCalciatore(nome, posizione);

            Imprevisto imprevisto = GestioneImprevisti.generaImprevistoCasuale();

            if (imprevisto != null) {
                finestra.mostraMessaggio(nome + ": " + imprevisto.getDescrizione());

                if (imprevisto.isNegativo()) {
                    caduto = true;
                    finestra.calciatoreCaduto(this);
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

    
