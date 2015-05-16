/*
 * DadesReproductor.java
 * Marc Gonzalez Diez  47985897P
 */
package edu.ub.prog2.GonzalezDiezMarc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Marc Gonzalez Diez
 */
public class DadesReproductor implements Serializable {
    private final LlistaFitxers biblioteca;
    private final ArrayList<LlistaReproduccio> llistesRepro;
    
    /**
     * Crea l'atribut llista biblioteca, i una llista de llistes de reproduccio.
     */
    public DadesReproductor(){
        this.biblioteca = new LlistaFitxers();
        this.llistesRepro = new ArrayList<>();
    }
    
    /**
     * Afegeix l'arxiu a la biblioteca.
     * @param fitxer
     * @throws edu.ub.prog2.GonzalezDiezMarc.model.ExcepcioFitxerRepetit
     * @throws edu.ub.prog2.GonzalezDiezMarc.model.ExcepcioFitxerNoExisteix
     */
    public void afegirFitxerBiblioteca(FitxerAudio fitxer) throws ExcepcioFitxerRepetit, ExcepcioFitxerNoExisteix{
        biblioteca.afegirFitxer(fitxer);
    }

    /**
     * Elimina el fitxer de la biblioteca
     * @param fitxer
     */
    public void eliminarFitxerBiblioteca(FitxerAudio fitxer){
        biblioteca.eliminarFitxer(fitxer);
    }
    
    /**
     * Afegeix l'arxiu de musica a la llsita seleccionada.
     * @param indexLlista
     * @param indexCanco
     */
    public void afegirFitxerLlista(int indexLlista, int indexCanco){ 
        try{ 
            this.getAt(indexCanco).addFitxer(biblioteca.getAt(indexLlista));
        }
        
        catch (IndexOutOfBoundsException ex){ 
            System.out.println("L'index donat no te conte cap canco!"); 
        } 
    }
    
    /**
     * Retorna la llista seleccionada.
     * @param i
     * @return
     */
    public LlistaReproduccio getAt(int i){
        return llistesRepro.get(i);
    }

    /**
     * Elimina el fitxer de la llista seleccionada.
     * @param fitxer
     * @param lista
     */
    public void eliminarFitxerLlista(int fitxer, int lista){
         try{             
            //this.getAt(lista).deleteFitxer(biblioteca.getAt(fitxer));
            //this.getAt(lista).eliminarFitxer(this.getAt(lista).getAt(fitxer));
             this.getAt(lista).eliminarPrueba(fitxer);
         }
        
        catch (IndexOutOfBoundsException ex){ 
            System.out.println("L'index donat no te conte cap canco!"); 
        } 
    }
    
    /**
     * Crea una nova llista de Reproduccio buida amb el nom o tituol seleccionat.
     * @param titulo
     */
    public void crearLlistaRepro(String titulo){
        llistesRepro.add(new LlistaReproduccio(titulo));
    }
    
    /**
     * Elimina la llista de reproduccio i el seu contingut.
     * @param indexLlista
     */
    public void eliminarLlistaRepro(int indexLlista){
        llistesRepro.remove(indexLlista);
    }
    
    /**
     * Imprimeix una llista seleccionada
     * @param index
     * @return
     */
    public String mostrarLlistaDeLlistes(int index){
        return this.getAt(index).imprimirLlista();
    }
    

    /**
     * @return the biblioteca
     */
    public LlistaFitxers getBiblioteca() {
        return biblioteca;
    }

    /**
     *
     * @return biblioteca en forma de string
     */
    public String mostrarBiblioteca(){
        return biblioteca.toString();
    }
    

    /**
     * @return the llistesRepro
     */
    public ArrayList<LlistaReproduccio> getLlistesRepro() {
        return llistesRepro;
    }
    
    public int tamanyLlistes(){
        return llistesRepro.size();
    }
    
    /**
     * Per a imprimir totes les llistes de repro.
     */
    public void mostrarLlistes(){
        if (llistesRepro.size()>0){ 
            Iterator itrLlista = llistesRepro.iterator(); 
            int i= 1; 
            while (itrLlista.hasNext()){ 
                System.out.println(i+". " + (LlistaReproduccio)itrLlista.next()); 
                i++; 
            } 
        } 
        else System.out.println("No hi ha cap llista!"); 
    } 
     
    
}
