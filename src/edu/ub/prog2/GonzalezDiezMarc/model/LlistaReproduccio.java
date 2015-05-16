/*
 * LlistaReproduccio.java
 * Marc Gonzalez Diez  47985897P
 */
package edu.ub.prog2.GonzalezDiezMarc.model;

/**
 *Clase llista de Reproduccio, hereta de LlistaFitxers.
 * @author Marc Gonzalez Diez
 */
public class LlistaReproduccio extends LlistaFitxers {
    public final String titol;
    private int maxFitxers;
    
    /**
     * Crea una llista de reproduccio amb els atributs titol i max fitxers.
     * @param titol
     */
    public LlistaReproduccio(String titol){
        this.titol = titol;
        this.maxFitxers = 10;
    }
    
    /**
     * Afegeix fitxer a la llista, si no esta plena.
     * @param i
     */
    public void addFitxer(FitxerAudio i) { 
        if (super.tamany() >= maxFitxers){
            System.out.println("Llista Completa! Modifica el tamany maxim per anyadir mes cansons.");
        }
        else{
            super.afegirFitxerLlista(i);
            System.out.println("Fitxer afegit a la llista de reproducció. ");
                    }

    }
    
    /**
     * Elimina el fitxer seleccionat de la llista
     * @param i
     */
    public void deleteFitxer(FitxerAudio i) {
        super.eliminarFitxer(i);
    }
    
    /**
     * @return the titol
     */
    public String getTitol() {
        return titol;
    }
    

    /**
     * @return the MAX_FITXERS
     */
    public int getMaxFitxers() {
        return maxFitxers;
    }
    
    /**
     *
     * @return Llista de Reproduccio
     */
    public String imprimirLlista(){
        return super.toString();
    }

    /**
     * @param maxFitxers the MAX_FITXERS to set
     */
    public void setMaxFixers(int maxFitxers) {
        this.maxFitxers = maxFitxers;
    }
    
    /**
     *
     * @return titol de la llista.
     */
    @Override
    public String toString(){
        return this.getTitol();
    }
  

    
}
