/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dangelogregoriogarathread;

import java.util.Random;

/**
 * genera imprevisti casuali durante la gara.
 * imprevisti positivi (avanzano il calciatore) o negativi (lo rallentano o lo fanno cadere).
 */
public class GestioneImprevisti {

    private static Random generatore = new Random();

    // probabilità su 100 per ogni tipo di imprevisto
    private static final int probInfortunio = 2;
    private static final int probAmmonizione = 4;
    private static final int probBevanda = 6;
    private static final int probDoping = 8;

    /**
     * logica per far generare un imprevisto random
     * @return il messaggio, quantio torna in dietro(effetto) , se negativo o no
     */
    public static Imprevisto generaImprevistoCasuale() {

        int probabilita = generatore.nextInt(100);

        if (probabilita < probInfortunio) {
            return new Imprevisto("Infortunio!", -2, true);
        }

        if (probabilita < probAmmonizione) {
            return new Imprevisto("Ammonizione!", -1, true);
        }

        if (probabilita < probBevanda) {
            return new Imprevisto("Bevanda energetica!", +4, false);
        }

        if (probabilita < probDoping) {
            boolean scoperto = generatore.nextBoolean();
            if (scoperto) {
                return new Imprevisto("Doping scoperto!", -7, true);
            } else {
                return new Imprevisto("Doping non scoperto!", +7, false);
            }
        }

        // nessun imprevisto
        return null;
    }
}
