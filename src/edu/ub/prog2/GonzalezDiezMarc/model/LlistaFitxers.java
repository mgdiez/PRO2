/*
 * LlistaFitxers.java
 * Marc Gonzalez Diez  47985897P
 */
package edu.ub.prog2.GonzalezDiezMarc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que implementa un array de Fitxers d'Audio.
 * @author Marc Gonzalez Diez
 */
public class LlistaFitxers extends ArrayList implements Serializable, Cloneable {
    private ArrayList<FitxerAudio> BibliotecaMusica;
    
    /**
     * Constructor de LlistaFitxers()
     */
    public LlistaFitxers(){
        this.BibliotecaMusica = new ArrayList<>();
    }

    /**
     * 
     * @return tamany de la biblioteca
     */
    public int tamany() {       
        return BibliotecaMusica.size();
    }

    /**
     *
     * @param i
     * @return FitxerAudio a la posicio demanada
     */
    public FitxerAudio getAt(int i){
        return BibliotecaMusica.get(i);
    }

    /**
     *
     * @return false
     */
    protected boolean isFull() { 
        return false; 
    }
    
    /**
     * Funció que desordena l'array de Fitxers d'Audio utilizant Collections.shuffle.
     */
    public void desordena(){
        Collections.shuffle(BibliotecaMusica);
    }

    /**
     * Funcion que añade archivo a la biblioteca, solo si no existe previamente.
     * @param fitxer
     * @throws edu.ub.prog2.GonzalezDiezMarc.model.ExcepcioFitxerRepetit
     * @throws edu.ub.prog2.GonzalezDiezMarc.model.ExcepcioFitxerNoExisteix
     */
    public void afegirFitxer(FitxerAudio fitxer) throws ExcepcioFitxerRepetit, ExcepcioFitxerNoExisteix {
        try{    
        int i = 0;
            boolean encontrada_igual = false; //Supondremos que no existe previamente.
            while((!encontrada_igual) && (i < BibliotecaMusica.size())){ //Condicion de salida, y un limite.
                if (fitxer.equals(BibliotecaMusica.get(i))){
                    encontrada_igual = true; //Si son iguales, ponemos el bool a true para salir de la busqueda.
                    if (encontrada_igual){
                        throw new ExcepcioFitxerRepetit();                   
                    }
                }
                i++;
            }
            if (!fitxer.existeix(fitxer)){
                throw new ExcepcioFitxerNoExisteix();

            }
            if (!encontrada_igual && fitxer.existeix(fitxer)) BibliotecaMusica.add(fitxer);
        }catch(ExcepcioFitxerRepetit ex){
            System.out.println(ex.getMessage());
        }catch(ExcepcioFitxerNoExisteix ex1){
            System.out.println(ex1.getMessage());
        }
        }
    
    
    /**
     * Afegeix fitxer a la llista.
     * @param fitxer
     */
    public void afegirFitxerLlista(FitxerAudio fitxer){
        BibliotecaMusica.add(fitxer);
    }

    /**
     * Elimina fitxer de la llista
     * @param fitxer
     */
    public void eliminarFitxer(FitxerAudio fitxer) { 
        BibliotecaMusica.remove(fitxer);

    }
    public void eliminarPrueba(int indice){
        BibliotecaMusica.remove(indice);
    }

    /**
     * Elimina tota la bibiloteca de musica.
     */
    @Override
    public void clear(){
        BibliotecaMusica.clear();
    }
    

    //Override de clone de Object, per a poder clonar una LlistaFitxers.

    /**
     * Override de clone per a fer copies de LlistaFitxers
     * @return objecte de tipus LlistaFitxers clonat.
     */
        @Override
    public Object clone(){
        LlistaFitxers obj = null;
        obj = (LlistaFitxers) super.clone();
        obj.BibliotecaMusica = (ArrayList<FitxerAudio>) obj.BibliotecaMusica.clone();
        return obj;
        
        
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){ 
    String aux = ""; 
    for (int i=0; i<= (this.tamany())-1; i++){ 
        aux +=((i+1)+ ". " + this.getAt(i).toString()+"\n"); 
    } 
        return aux; 
    }  
    
}
