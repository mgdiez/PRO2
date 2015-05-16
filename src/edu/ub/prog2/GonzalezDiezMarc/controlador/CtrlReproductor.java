/*
 * CtrlReproductor.java
 * Marc Gonzalez Diez  47985897P
 */

package edu.ub.prog2.GonzalezDiezMarc.controlador;

import edu.ub.prog2.GonzalezDiezMarc.model.DadesReproductor;
import edu.ub.prog2.GonzalezDiezMarc.model.ExcepcioFitxerNoExisteix;
import edu.ub.prog2.GonzalezDiezMarc.model.ExcepcioFitxerRepetit;
import edu.ub.prog2.GonzalezDiezMarc.model.FitxerAudio;
import edu.ub.prog2.GonzalezDiezMarc.model.LlistaFitxers;
import edu.ub.prog2.GonzalezDiezMarc.model.LlistaReproduccio;
import edu.ub.prog2.GonzalezDiezMarc.vista.ReproductorUB4;
import edu.ub.prog2.utils.FitxerAudioErrorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc Gonzalez Diez
 */
public class CtrlReproductor {
    private DadesReproductor dades;
    private ReproductorAudio repro;
    
    /**
     * Objecte de tipus CtrlReproductor, té cm a atributs un objecte de tipus DadesReproductor i un de tipus ReproductorAudio
     */
    public CtrlReproductor(){
        this.dades = new DadesReproductor();
        this.repro = new ReproductorAudio();
    }
    
    /**
     *
     * @return LlistaFitxers Biblioteca
     */
    public LlistaFitxers getBiblioteca(){
       return dades.getBiblioteca();
    }
    
    public ArrayList<LlistaReproduccio> getLlistes(){
        return dades.getLlistesRepro();
    }
    
    /**
     * Pasa a DadesRepro el crear una llista de repro.
     * @param titol
     */
    public void afegirLlista(String titol){
        dades.crearLlistaRepro(titol);
    }

    /**
     *
     * @param fa
     * @throws edu.ub.prog2.GonzalezDiezMarc.model.ExcepcioFitxerRepetit
     * @throws edu.ub.prog2.GonzalezDiezMarc.model.ExcepcioFitxerNoExisteix
     */
    public void afegirFitxer(FitxerAudio fa) throws ExcepcioFitxerRepetit, ExcepcioFitxerNoExisteix{
        dades.afegirFitxerBiblioteca(fa);
    }
    
    /**
     * Funcio que pasa a a dadesReproductor afegir un fitxer d'audio a la llista seleccionada.
     * @param fa
     * @param llista
     */
    public void afegirFitxerLlista(int fa, int llista){
        dades.afegirFitxerLlista(fa, llista);
    }

    /**
     * Elimina un arxiu de la bilbioteca.
     * @param fa
     */
    public void eliminarFitxer(FitxerAudio fa){
        dades.eliminarFitxerBiblioteca(fa);

    }

    /**
     * Elimina un arxiu de la llista seleccionada.
     * @param fa
     * @param llista
     */
    public void eliminarFitxerLlista(int fa, int llista){
        dades.eliminarFitxerLlista(fa,llista);
    }

    /**
     * Funcio que crea una llista de reproducció.
     * @param nomLlista
     */
    public void crearLlistaReproduccio(String nomLlista){
        dades.crearLlistaRepro(nomLlista);
    }
    
    public int tamanyLlistes(){
        return dades.tamanyLlistes();
    }

    /**
     * Elimina una llista de Reproduccio
     * @param indexLlista
     */
    public void eliminarLlistaReproduccio(int indexLlista){
        dades.eliminarLlistaRepro(indexLlista);       
    }

    /**
     *  Mostre les llistes
     */
    public void mostrarLlistes(){
        dades.mostrarLlistes();
    }

    /**
     * Mostra la biblioteca
     * @return
     */
    public String mostrarBiblioteca(){
        return dades.mostrarBiblioteca();
    }
    
    /**
     * Mostra els arxius de una determinada llista de reproducció
     * @param index
     * @return
     */
    public String mostrarLlistaDeLlistes(int index){
        return dades.mostrarLlistaDeLlistes(index);
    }
    
    /**
     * Es crea una Llista de Reproducció quan tenim un arxiu, per a poder pasarli a ReproductorAudio.
     * @param index
     */
    public void playSong(int index){
        LlistaReproduccio llista = new LlistaReproduccio("");
        llista.addFitxer(dades.getBiblioteca().getAt(index));
        repro.controlReproduccio((LlistaFitxers)llista);
    }
    
    /**
     * Funcio que pasa a reproductorAudio la biblioteca per a reproduir.
     */
    public void playBiblioteca(){
        LlistaFitxers llista = dades.getBiblioteca();
        repro.controlReproduccio(llista);
    }
    
    /**
     * Funcio que pasa a reproductorAudio la llista de reproducció a reproduir.
     * @param i
     */
    public void playLlista(int i){
        LlistaFitxers llista = dades.getAt(i);
        repro.controlReproduccio(llista);
    }
    
    public LlistaReproduccio getLlista(int i){
        return dades.getAt(i);
    }

    /**
     * Funcio que ordena a reproductorAudio que començi o pausa la reproduccio.
     * @throws FitxerAudioErrorException
     */
    public void setPlayPause() throws FitxerAudioErrorException{
        repro.setPlayPause();
    }
    
    /**
     * Funcio que ordena a reproductorAudio que pari la reproduccio.
     */
    public void setStop(){
        repro.setStop();
    }
    
    /**
     * Funcio que ordena a reproductorAudio que reprodueixi el seguent arxiu.
     * @throws FitxerAudioErrorException
     */
    public void setSeguent() throws FitxerAudioErrorException{
        repro.setSeguent();
    }
    
    public void setAnterior() throws FitxerAudioErrorException{
        repro.setAnterior();
    }

    /**
     * Funcio que ordena a reproductorAudio que la reproduccio sigui ciclica
     */
    public void setCiclica(){
        repro.setCiclica();
    }
    
    /**
     * Funcio que ordena a reproductorAudio que la reproduccio sigui aleatoria.
     */
    public void setAleatoria(){
        repro.setAleatoria();
    }
    

    
    /**
     * Guarda les dades de la aplicació.
     * @param arxiu
     */
    public void guardarDades(File arxiu){
        FileOutputStream fout = null; 
        try { 
            fout = new FileOutputStream(arxiu); 
            } catch (FileNotFoundException ex) { 
                Logger.getLogger(ReproductorUB4.class.getName()).log(Level.SEVERE, null, ex); 
            } 
        try { 
            try (ObjectOutputStream oos = new ObjectOutputStream(fout)) {
                oos.writeObject(dades);
                oos.writeObject(repro);
            } 
            } catch (IOException ex) { 
                Logger.getLogger(ReproductorUB4.class.getName()).log(Level.SEVERE, null, ex); 
            } 
        }
    
    /** 
     * Recupera les dades de l'aplicacio guardades previament. 
     * @param arxiu  
     */
    public void recuperarDades(File arxiu){ 
            FileInputStream fin = null; 
            try { 
                fin = new FileInputStream(arxiu); 
  
            }catch (FileNotFoundException ex) { 
            }  
  
            try { 
                ObjectInputStream ois = new ObjectInputStream(fin); 
  
                try { 
                    dades = (DadesReproductor)ois.readObject();
                    repro = (ReproductorAudio)ois.readObject();
                    ois.close();
                } catch (ClassNotFoundException ex) { 
                    Logger.getLogger(ReproductorUB4.class.getName()).log(Level.SEVERE, null, ex); 
                } 
            }    catch (IOException ex) { 
                Logger.getLogger(ReproductorUB4.class.getName()).log(Level.SEVERE, null, ex); 
            } 
            catch (NullPointerException ex) { 
            } 
        } 

}
