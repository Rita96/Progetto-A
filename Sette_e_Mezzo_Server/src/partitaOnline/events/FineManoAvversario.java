package partitaOnline.events;

import dominio.classi_dati.Stato;
import dominio.elementi_di_gioco.Carta;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author xXEgoOneXx
 */
public class FineManoAvversario implements Serializable{
    
    private String nome;
    private ArrayList<Carta> carteScoperte;
    private Stato stato;
    private int puntata;

    /**
     * 
     * @param nome nome giocatore
     * @param carteScoperte carte scoperte del giocatore
     * @param stato stato del giocatore
     * @param puntata puntata del giocatore
     */
    public FineManoAvversario(String nome, ArrayList<Carta> carteScoperte, Stato stato, int puntata) {
        this.nome = nome;
        this.carteScoperte = carteScoperte;
        this.stato = stato;
        this.puntata = puntata;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Carta> getCarteScoperte() {
        return carteScoperte;
    }

    public Stato getStato() {
        return stato;
    }

    public int getPuntata() {
        return puntata;
    }

    /**
     *
     * @return "evento FineManoAvversario " + nome + " "+tutteLeCarteSeparateDaSpazio+" "+"fineCarte " + stato + " " + puntata;
     */
    @Override
    public String toString() {
        String ritorno="evento\tFineManoAvversario\t" + nome + " ";
        for(Carta carta : carteScoperte){
            ritorno+=carta.toString()+" ";
        }
        ritorno+="fineCarte " + stato + " " + puntata;
        return ritorno;
    }
    
    
    
}
