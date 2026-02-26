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
 * Classe che rappresenta un imprevisto positivo o negativo.
 * Ogni imprevisto ha una descrizione e un effetto sulla posizione del calciatore.
 */
public class Imprevisto {

    private String descrizione;
    private int effetto;
    private boolean negativo;

    public Imprevisto(String descrizione, int effetto, boolean negativo) {
        this.descrizione = descrizione;
        this.effetto = effetto;
        this.negativo = negativo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getEffetto() {
        return effetto;
    }

    public boolean isNegativo() {
        return negativo;
    }
}


