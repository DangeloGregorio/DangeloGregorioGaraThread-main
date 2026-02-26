package dangelogregoriogarathread;

import java.util.Random;

/**
 * Classe che genera imprevisti casuali durante la gara.
 * Alcuni imprevisti sono positivi (avanzano il calciatore),
 * altri negativi (lo rallentano o lo fanno cadere).
 */
public class GestioneImprevisti {

    private static Random generatore = new Random();

    // probabilità su 100 per ogni tipo di imprevisto
    private static final int probInfortunio= 10;
    private static final int probAmmonizione= 20;
    private static final int probBevanda= 30;
    private static final int probDoping= 35;

    public static Imprevisto generaImprevistoCasuale() {

        int probabilita = generatore.nextInt(100);

        if (probabilita < probInfortunio) {
            return new Imprevisto("Infortunio!", -5, true);
        }

        if (probabilita < probAmmonizione) {
            return new Imprevisto("Ammonizione!", -2, true);
        }

        if (probabilita < probBevanda) {
            return new Imprevisto("Bevanda energetica!", +4, false);
        }

        if (probabilita < probDoping) {
            boolean scoperto = generatore.nextBoolean();
            if (scoperto) {
                return new Imprevisto("Doping scoperto!", -20, true);
            } else {
                return new Imprevisto("Doping non scoperto!", +10, false);
            }
        }

        // nessun imprevisto
        return null;
    }
}