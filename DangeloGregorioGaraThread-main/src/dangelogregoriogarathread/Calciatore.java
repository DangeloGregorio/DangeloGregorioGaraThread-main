/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dangelogregoriogarathread;

/**
 *
 * @author dange
 */

/**
 * ogni calciatore è un thread separato che avanza in modo indipendente
 * gestisce da solo il movimento, gli imprevisti e la caduta
 *
 */
public class Calciatore extends Thread {

    private String nome; 
    private int posizione;
    private FrameGara finestra;
    // deve essere uguale a quello di framegara per sapere quando fermarsi
    private static final int passiArrivo = 100;
    //blocca il thread quando il calciatore e caduto
    private boolean caduto = false;

    /**
     * Costruttore,crea il calciatore con nome e riferimento alla finestra
     * parte sempre dalla posizione 0
     *
     * @param nome il nome del calciatore
     * @param finestra la finestra principale da aggiornare durante la gara
     */
    public Calciatore(String nome, FrameGara finestra) {
        this.nome = nome;
        this.finestra = finestra;
        this.posizione = 0;
    }

    /**
     * viene chiamato dalla finestra dopo 1,5 secondi di caduta
     * rimette caduto a false e sveglia il thread che era in wait
     */
    public synchronized void rialzati() {
        caduto = false;
        notify();
    }
    
    /**
     * contiene la logica della corsa, viene eseguito quando si chiama start()
     * il ciclo va avanti finche il calciatore non raggiunge il traguardo
     */
    @Override
   public void run() {

        while (posizione < passiArrivo) {

             // se e caduto il thread si blocca qui e aspetta che rialzati() lo svegli
            synchronized (this) {
                while (caduto) {
                    try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
            }

            // aspetta 200 millisecondi tra un passo e l'altro 
            try {
                Thread.sleep(200);
            } catch (InterruptedException eccezione) {
                Thread.currentThread().interrupt();
            }

            posizione++;
            finestra.aggiornaPosizioneCalciatore(nome, posizione);

            // ogni passo c'è una possibilita che capiti un imprevisto
            Imprevisto imprevisto = GestioneImprevisti.generaImprevistoCasuale();

            if (imprevisto != null) {
                finestra.mostraMessaggio(nome + ": " + imprevisto.getDescrizione());

                // se neg il calciatore cade e si blocca
                if (imprevisto.isNegativo()) {
                    caduto = true;
                    finestra.calciatoreCaduto(this);
                }

                // l'effetto puo essere pos o neg, modifica la posizione
                posizione += imprevisto.getEffetto();
                if (posizione < 0) posizione = 0;
            }
        }

        finestra.calciatoreArrivato(nome);
    }


   /**
     * @return il nome del calciatore
     */
   public String getNome() {
        return nome;
    }

   /**
     * @return la posizione attuale del calciatore
     */
    public int getPosizione() {
        return posizione;
    }
}

    
