/*
 * ExcepcioFitxerNoExisteix.java
 * Marc Gonzalez Diez  47985897P
 */

package edu.ub.prog2.GonzalezDiezMarc.model;

import edu.ub.prog2.utils.FitxerAudioErrorException;

/**
 *
 * @author Marc
 */
public class ExcepcioFitxerNoExisteix extends FitxerAudioErrorException {

    /**
     * message Harcoded.
     */
    public static String myMessage = "Fitxer no existeix.";

    /**
     * Constructor sense message.
     */
    public ExcepcioFitxerNoExisteix(){
        super();
    }

    /**
     * Constructor amb message
     * @param message
     */
    public ExcepcioFitxerNoExisteix(String message){
        super(message);
    }

    /**
     *geter de Message
     * @return
     */
    @Override
    public String getMessage(){
        return myMessage;
    }
}
