package dominio.classi_dati;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Banners {
    private ArrayList<String> banners;
    
    private String big = 
"                    _   _                                            \n" +
"                   | | | |                                           \n" +
"           ___  ___| |_| |_ ___    ___   _ __ ___   ___ ___________  \n" +
"          / __|/ _ \\ __| __/ _ \\  / _ \\ | '_ ` _ \\ / _ \\_  /_  / _ \\ \n" +
"          \\__ \\  __/ |_| ||  __/ |  __/ | | | | | |  __// / / / (_) |\n" +
"          |___/\\___|\\__|\\__\\___|  \\___| |_| |_| |_|\\___/___/___\\___/ \n" +
"                                                                     \n" +
"";    
    
    private String banner = 
"                                             \n" +
"                   ####  ###### ##### ##### ######    ###### \n" +
"                  #      #        #     #   #         #      \n" +
"                   ####  #####    #     #   #####     #####  \n" +
"                       # #        #     #   #         #      \n" +
"                  #    # #        #     #   #         #      \n" +
"                   ####  ######   #     #   ######    ###### \n" +
"                                                             \n" +
"                                                         \n" +
"                      #    # ###### ###### ######  ####  \n" +
"                      ##  ## #          #      #  #    # \n" +
"                      # ## # #####     #      #   #    # \n" +
"                      #    # #        #      #    #    # \n" +
"                      #    # #       #      #     #    # \n" +
"                      #    # ###### ###### ######  ####  \n" +
" ";      
    
    private String block = 
"                                                                       \n" +
"                               _|      _|                              \n" +
"           _|_|_|    _|_|    _|_|_|_|_|_|_|_|    _|_|          _|_|    \n" +
"         _|_|      _|_|_|_|    _|      _|      _|_|_|_|      _|_|_|_|  \n" +
"             _|_|  _|          _|      _|      _|            _|        \n" +
"         _|_|_|      _|_|_|      _|_|    _|_|    _|_|_|        _|_|_|  \n" +
"                                                                       \n" +
"                                                                       \n" +
"                                                                    \n" +
"                                                                    \n" +
"            _|_|_|  _|_|      _|_|    _|_|_|_|  _|_|_|_|    _|_|    \n" +
"            _|    _|    _|  _|_|_|_|      _|        _|    _|    _|  \n" +
"            _|    _|    _|  _|          _|        _|      _|    _|  \n" +
"            _|    _|    _|    _|_|_|  _|_|_|_|  _|_|_|_|    _|_|    \n" +
"                                                                    \n" +
"";
    
    private String lean =
"                                                                        \n" +
"                                 _/      _/                             \n" +
"            _/_/_/    _/_/    _/_/_/_/_/_/_/_/    _/_/          _/_/    \n" +
"         _/_/      _/_/_/_/    _/      _/      _/_/_/_/      _/_/_/_/   \n" +
"            _/_/  _/          _/      _/      _/            _/          \n" +
"       _/_/_/      _/_/_/      _/_/    _/_/    _/_/_/        _/_/_/     \n" +
"                                                                        \n" +
"                                                                        \n" +
"                                                                     \n" +
"                                                                     \n" +
"             _/_/_/  _/_/      _/_/    _/_/_/_/  _/_/_/_/    _/_/    \n" +
"            _/    _/    _/  _/_/_/_/      _/        _/    _/    _/   \n" +
"           _/    _/    _/  _/          _/        _/      _/    _/    \n" +
"          _/    _/    _/    _/_/_/  _/_/_/_/  _/_/_/_/    _/_/       \n" +
"                                                                     \n" +
"                                                                     ";
    
    private String shadow = 
"                     |   |                                            \n" +
"            __|  _ \\ __| __|  _ \\   _ \\  __ `__ \\   _ \\_  /_  /  _ \\  \n" +
"          \\__ \\  __/ |   |    __/   __/  |   |   |  __/  /   /  (   | \n" +
"          ____/\\___|\\__|\\__|\\___| \\___| _|  _|  _|\\___|___|___|\\___/  \n" +
"                                                                      ";
    
    private String slant = 
"                    __  __                                               \n" +
"         ________  / /_/ /____     ___     ____ ___  ___  ________  ____ \n" +
"        / ___/ _ \\/ __/ __/ _ \\   / _ \\   / __ `__ \\/ _ \\/_  /_  / / __ \\\n" +
"       (__  )  __/ /_/ /_/  __/  /  __/  / / / / / /  __/ / /_/ /_/ /_/ /\n" +
"      /____/\\___/\\__/\\__/\\___/   \\___/  /_/ /_/ /_/\\___/ /___/___/\\____/ \n" +
"                                                                         ";
    /**
     * inizzializza arraylist
     */
    public Banners(){
        banners = new ArrayList<>(Arrays.asList(big, banner, block, lean, shadow, slant));
        inizializza();
    }
    
    /**
     * 
     */
    private void inizializza(){

    }
    
    /**
     * questo meroto seleziona un banners in modo causale
     * 
     * @return ritorna un banner 
     */
    public String randomBanner(){
        Collections.shuffle(banners);
        return banners.get(0);
    }
}
