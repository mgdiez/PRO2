/*
 * FitxerAudio.java
 * Marc Gonzalez Diez  47985897P
 */
package edu.ub.prog2.GonzalezDiezMarc.model;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Marc Gonzalez Diez
 * Clase creadora del fitxer d'audio.
 */

public class FitxerAudio extends File implements Serializable{
    private String nom_canco, autor, disc, discografica;
    private int any, num_canco;
    private float duracio_canco;

    /**
     * Creador de la clase FitxerAudio, crea un objecte definit pel seu path
     * @param path
     */
    
    public FitxerAudio(String path) {
        super(path); 
        boolean exit;
        /*do{
            exit = demanaDadesTeclat();
            if (!exit) System.out.println("Error en la lectura de dades. Introdueix les dades correctament.");
        }
        while (!exit);*/
    }
    
    /**
     *
     * @param i
     * @return Bolea segons si existeix l'arxiu o no.
     */
    public boolean existeix(FitxerAudio i){
        File fichero = new File(i.getPath());
        return fichero.exists();
    }
    /**
     * Metode auxiliar del creador, per a demanar les dades per pantalla i guardarles
     * al objecte que estem creant.
     */
    private boolean demanaDadesTeclat(){
        Scanner in;
        in = new Scanner(System.in);
        
        boolean repeat;
        do{
            repeat = false;
            System.out.println("Introdueix el nom de la canció");
            this.nom_canco = in.nextLine(); 
            System.out.println("Introdueix l'autor de la canció");
            this.autor = in.nextLine();
            System.out.println("Introdueix el nom del disc");
            this.disc = in.nextLine();
            System.out.println("Introdueix la discográfica");
            this.discografica = in.nextLine();
            if(nom_canco.equals("") || autor.equals("") || disc.equals("") || discografica.equals("")){
                System.out.println("ERROR: No s'accepten camps buits");
                repeat = true;
            }
        }while(repeat);
                
        
        
        try{
            System.out.println("Introdueix l'any d'edició");
            this.any = (int)in.nextInt();      
            System.out.println("Introdueix el numero de la cansó");
            this.num_canco = (int)in.nextInt();        
            System.out.println("Introdueix la duració de la cançó (format: MM,SS): ");
            this.duracio_canco = in.nextFloat();
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
    
    
    /*Cada arxiu te com a ID unica el seu path, per tant si tenen el mateix path, sera el mateix
    arxiu */

    /**
     *
     * @param fitxer
     * @return Bolea si es o no igual al que li hem pasat.
     */
    
    public boolean equals(FitxerAudio fitxer){
        return (this.getPath().equals(fitxer.getPath()));
    }
    
    /* Mètode per mostrar cada arxiu com es demana */

    /**
     *
     * @return Informacio del arxiu
     */
    public void setNom(String nom){
        nom_canco = nom;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    @Override
    public String toString(){
        return ( nom_canco + " - " + autor);
    }

    
    }

    
    
  
