package gioco;

import classi_dati.Giocata;
import eccezioni.GiocataNonValidaException;
import eccezioni.PuntataTroppoAltaException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GiocatoreUmano extends Giocatore {
    private final InputStream in;
    private final PrintStream out;
    
    public GiocatoreUmano(String nome, int posizione, int fiches, InputStream in, PrintStream out) {
        super(nome, posizione, fiches);
        this.in = in;
        this.out = out;
    }

    @Override
    public Mazzo gioca_mano(Mazzo mazzo) {
        Giocata giocata;
        while(true){
            try {
                giocata = seleziona_giocata(richiedi_giocata());
                break;
            } catch (GiocataNonValidaException ex) {
                out.println("Errore: La giocata non é stata riconosciuta.");
                out.println("I valori possibili sono: carta, punta, sto.");
            }
        }
        switch(giocata){
            case Carta: this.chiedi_carta();
            case Sto: this.stai();
            case Punta: {
                while(true){
                    try {
                        this.punta(this.getPuntata());
                        break;
                        } 
                    catch (PuntataTroppoAltaException ex) {
                        out.println("Errore: il valore inserito é troppo alto.");
                        out.println("Il massimo valore che puoi puntare é: " + this.getFiches());
                    }
                    catch(InputMismatchException ex){
                        out.println("Errore: Il valore inserito non é corretto.");
                    }
                }
            }
        }
        return mazzo;
    }
    
    public int richiedi_puntata() throws InputMismatchException{
        int puntata;
        Scanner scan = new Scanner(in);
        puntata = scan.nextInt();
        return puntata;
    }

    public String richiedi_giocata() {
        Scanner scan = new Scanner(in);
        String giocata = scan.next();
        return giocata;
    }
    
    public Giocata seleziona_giocata(String giocata) throws GiocataNonValidaException{
        if(giocata.toLowerCase().equals("carta")){
            return Giocata.Carta;
        } 
        else if(giocata.toLowerCase().equals("sto")){
        return Giocata.Sto;
        }
        else if(giocata.toLowerCase().equals("punta")){
            return Giocata.Punta;
        }
        else{
            throw new GiocataNonValidaException();
        }   
    }
    
    
}
