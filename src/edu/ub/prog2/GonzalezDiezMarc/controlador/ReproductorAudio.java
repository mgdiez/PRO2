/*
 * ReproductorAudio.java
 * Marc Gonzalez Diez  47985897P
 */

package edu.ub.prog2.GonzalezDiezMarc.controlador;

import edu.ub.prog2.GonzalezDiezMarc.model.LlistaFitxers;
import edu.ub.prog2.utils.FitxerAudioErrorException;
import edu.ub.prog2.utils.ReproductorBasic;
import edu.ub.prog2.utils.ReproductorEvent;
import java.io.Serializable;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc
 */
public class ReproductorAudio extends ReproductorBasic implements Serializable {
    private LlistaFitxers llista;
    private boolean estatRepro;
    private boolean loopPlay = false;
    private boolean randomPlay = false;
    private int contador;
    private boolean first = true;

    /**
     * Funció que afegeix la llista a reproduir, i posa el contador a 0.
     * @param llista
     */
    public void controlReproduccio(LlistaFitxers llista){      
        this.llista = llista;
        contador = 0;
    }
    
    /**
     * Funcio que inicia la reproduccio. Controla si el tipus es loop, i si es loop i random,
     * a cada final de llista es torna a desordenar.
     * @throws FitxerAudioErrorException
     */
    public void playMusic() throws FitxerAudioErrorException{
            try{
            String ruta = llista.getAt(contador).getPath();
            obrirFitxer(ruta);
            System.out.println("Reproduint: " + llista.getAt(contador));
            }catch(Exception IndexOutOfBounds){
                if(loopPlay){
                    if (randomPlay){
                        llista.desordena();
                    }
                    contador = 0;
                    playMusic();
                }
                else{
                    setStop();
                }
            }
            play();
            setEstatReproduccio(true);
    
    }
    
    /**
     * Seter de estatReproduccio
     * @param bol
     */
    public void setEstatReproduccio(boolean bol){
        estatRepro = bol;
    }
    
    /**
     * geter de estatReproduccio
     * @return
     */
    public boolean getEstatReproduccio(){
        return estatRepro;
    } 
    /**
     * Funcio play/pausa. Si donem al play per primer cop (bool first), es controla si es random, 
     * si ho es, es copia la llista sobre la que treballem per a no modificar res, i es desordena, i fem playMusic();
     * si pausem o donem play mentres reproduim, es mira com està la reproduccio i es fa el contrari.
     * @throws FitxerAudioErrorException
     */
    public void setPlayPause() throws FitxerAudioErrorException{
        if (first){
            if(randomPlay){
                llista = (LlistaFitxers) llista.clone();
                llista.desordena();
            }
            playMusic();
            first = false;
        }
        else{
            if(getEstatReproduccio()){
                 pause();
                 setEstatReproduccio(!getEstatReproduccio());
            }
            else{
                play();
                setEstatReproduccio(!getEstatReproduccio());
            }
        }
    }
    
    /**
     * Cada vegada que acabi un arxiu de música, es truca a setSeguent();
     * @param event
     */
    @Override
    public void onEndFile(ReproductorEvent event){
        try {
            setSeguent();
        } catch (FitxerAudioErrorException ex) {
            Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Funcio que fa stop(), posa el contador a 0, estatRepro a false, i posem el bolea de first a true, ja que
     * iniciarem un altre cop un altre reproduccio.
     */
    public void setStop(){
        stop(); 
        contador = 0;
        setEstatReproduccio(false);
        first = true;
    }
    
    /**
     * Fem stop(); estatRepro a false, inrementem a contador, i truquem a playMusic();
     * @throws FitxerAudioErrorException
     */
    public void setSeguent() throws FitxerAudioErrorException{
        stop();
        contador++;
        setEstatReproduccio(false);
        playMusic();
    }
    
    public void setAnterior() throws FitxerAudioErrorException{
        stop();
        contador = contador-1;
        setEstatReproduccio(false);
        playMusic();
    }
    
    /**
     * Si esta activat, es desactiva i al reves.
     */
    public void setCiclica(){
        if(loopPlay){
            loopPlay = false;
            System.out.println("Desactivat");
        }
        else{
            loopPlay = true;
            System.out.println("Activat");
        }
    }
    
    /**
     * Si esta activat, es desactiva i al reves.
     */
    public void setAleatoria(){
        if(randomPlay){
            randomPlay = false;
            System.out.println("Desactivat");
        }
        else{
            randomPlay = true;
            System.out.println("Activat");
        }
    }
    /**
     * Fitxer que truca a openAudioFile amb el path del arxiu.
     * @param ruta 
     */
    private void obrirFitxer(String ruta){
        try {
            openAudioFile(ruta);
        } catch (FitxerAudioErrorException ex) {
            Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
