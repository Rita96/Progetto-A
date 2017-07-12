package dominio.events;

import partitaOffline.events.*;
import dominio.classi_dati.StatoMano;
import dominio.elementi_di_gioco.Carta;
import java.util.ArrayList;

/**
 *
 * @author xXEgoOneXx
 */
public class FineManoAvversario {
    
    private String nome;
    private ArrayList<Carta> carteScoperte;
    private StatoMano stato;
    private int puntata;

    public FineManoAvversario(String nome, ArrayList<Carta> carteScoperte, StatoMano stato, int puntata) {
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

    public StatoMano getStato() {
        return stato;
    }

    public int getPuntata() {
        return puntata;
    }
    
}