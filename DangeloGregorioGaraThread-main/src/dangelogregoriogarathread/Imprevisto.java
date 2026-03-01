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
 * classe che rappresenta un imprevisto positivo o negativo.
 * ogni imprevisto ha una descrizione e un effetto sulla posizione del calciatore.
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

    /**
     * 
     * @return descrizione,messaggio del imprevisto
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * 
     * @return l'effetto sulla posizione
     */
    public int getEffetto() {
        return effetto;
    }

    /**
     * 
     * @return se imprevisto è neg
     */
    public boolean isNegativo() {
        return negativo;
    }
}


