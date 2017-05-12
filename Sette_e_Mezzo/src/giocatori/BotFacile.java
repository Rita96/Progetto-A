package giocatori;


import classi_dati.Giocata;
import elementi_di_gioco.Mazzo;


public class BotFacile extends Bot{
    
    public BotFacile (String nome, int fiches, Mazzo mazzo) {
        super(nome, fiches, mazzo);
    }

    @Override
    protected int decidi_puntata() {
        double percentuale = calcola_percentuale_sballo();
        double valore = ((double)(this.getFiches())/100);
        int puntata = 0;
        if(percentuale < 50) {
            puntata = (int) (valore*30);
        }else{
            puntata = (int) (valore*10);
        }
        if(puntata == 0) {
            puntata = 10;   //questo if mi serve perchè puntata può essere, per esempio, 0.06 e castato darebbe 0.
        }
        return puntata;
    }

    @Override
    protected Giocata decidi_giocata() {
        double percentuale = calcola_percentuale_sballo();
        if (percentuale < 50) {
            return Giocata.Carta;
        }else{
            return Giocata.Sto;
        }
    }

    
    
}
