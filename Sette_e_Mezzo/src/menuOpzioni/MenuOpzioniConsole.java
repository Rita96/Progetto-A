/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuOpzioni;

import dominio.classi_dati.ImpostazioniMenu;
import dominio.eccezioni.CanzoneNonTrovataException;
import dominio.eccezioni.CaricamentoCanzoneException;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;


public class MenuOpzioniConsole {
    
    ImpostazioniMenu impostazioni;

    public MenuOpzioniConsole() {
    }
    
    /**
     * Stampa le impostazioni da scegliere, inizializza a null il valore di impostazioni (enum) e poi lo setta in base al valore inserito da terminale
     * 
     * @throws InterruptedException
     * @throws CanzoneNonTrovataException
     * @throws CaricamentoCanzoneException 
     */
    
    public void selezionaImpostazione() throws InterruptedException, CanzoneNonTrovataException, CaricamentoCanzoneException {
        while(true) {
            printImpostazioni();
            ImpostazioniMenu impostazioni = null;
            impostazioni = richiediImpostazione();
        
            try {
                
                switch(impostazioni) {
                
                    case Musica: 
                        Musica music = new Musica();
                        music.selezionaImpostazione();
                        break;
                    case Profilo:
                        Profilo profilo = new Profilo();
                        profilo.selezionaProfilo();
                        break;
                    case Riconoscimenti:
                        Riconoscimenti riconoscimenti = new Riconoscimenti();
                        riconoscimenti.printRiconoscimenti();
                        break;
                }
            } catch (NullPointerException e) {    
          }
        }
    }
    
    private void printImpostazioni() {
        
        out.println("\n");
        out.println("SELEZIONA UN'IMPOSTAZIONE:");
        out.println("1. Musica\n");
        out.println("2. Profilo\n");
        out.println("3. Riconoscimenti\n");
    }
    
    private ImpostazioniMenu richiediImpostazione() {
        ImpostazioniMenu impostazioni_prov = null;
        Scanner scanner = new Scanner(in);        
        String input = scanner.next();
            
        try { 
                if(input.equals("1") || input.toLowerCase().equals("musica")) {
                    impostazioni_prov=ImpostazioniMenu.Musica;
                }
                if (input.equals("2") || input.toLowerCase().equals("profilo")) {
                    impostazioni_prov=ImpostazioniMenu.Profilo;
                }
                if (input.equals("3") || input.toLowerCase().equals("riconoscimenti")) {
                impostazioni_prov=ImpostazioniMenu.Riconoscimenti;
                } 
            }   
                catch (IllegalArgumentException ex){
                System.out.println("IMPOSTAZIONE NON VALIDA\n");
                }

//                if(impostazioni_prov == null) {
//                    System.out.println("IMPOSTAZIONE NON VALIDA");
        return impostazioni_prov;
    }
}
