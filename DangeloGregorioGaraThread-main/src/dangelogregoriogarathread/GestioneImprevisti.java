/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dangelogregoriogarathread;

import java.util.Random;

/**
 *
 * @author dange
 */

/**
 * genera imprevisti casuali durante la gara.
 * imprevisti positivi (avanzano il calciatore) o negativi (lo rallentano o lo fanno cadere).
 * 
 */
public class GestioneImprevisti {

    private static Random generatore = new Random();

    // probabilità su 100 per ogni tipo di imprevisto
    private static final int probInfortunio = 2; //prob 2
    private static final int probAmmonizione = 4; //prob 2
    private static final int probBevanda = 6; //prob 2
    private static final int probDoping = 7; //prob 1

    /**
     * logica per far generare un imprevisto random
     * @return il messaggio, quantio torna in dietro(effetto) , se negativo o no
     */
    public static Imprevisto generaImprevistoCasuale() {

        int probabilita = generatore.nextInt(10);

        if (probabilita < probInfortunio) {
            return new Imprevisto("Infortunio", -2, true);
        }

        if (probabilita < probAmmonizione) {
            return new Imprevisto("Ammonizione", -1, true);
        }

        if (probabilita < probBevanda) {
            return new Imprevisto("Sali minerali", +4, false);
        }

        if (probabilita < probDoping) {
            boolean scoperto = generatore.nextBoolean(); //50 e 50
            if (scoperto) {
                return new Imprevisto("Doping ma viene scoperto", -7, true);
            } else {
                return new Imprevisto("Doping non scoperto", +7, false);
            }
        }

        // nessun imprevisto
        return null;
    }
}
