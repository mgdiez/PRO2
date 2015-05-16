/*
 * ExcepcioFitxerRepetit.java
 * Marc Gonzalez Diez  47985897P
 */

package edu.ub.prog2.GonzalezDiezMarc.model;

import edu.ub.prog2.utils.FitxerAudioErrorException;

/**
 *
 * @author Marc
 */
public class ExcepcioFitxerRepetit extends FitxerAudioErrorException {

    /**
     * Misatge harcoded.
     */
    public static String myMessage = "El fitxer ja existeix.";

    /**
     * Constructor sense missatge.
     */
    public ExcepcioFitxerRepetit(){
        super();
    }

    /**
     * Contructor amb missatge.
     * @param message
     */
    public ExcepcioFitxerRepetit(String message){
        super(message);
    }

    /**
     * Getter de message.
     * @return
     */
    @Override
    public String getMessage(){
        return myMessage;
    }
}
