package Kayttoliittyma;

import PeliLogiikka.Pelaaja;
import java.awt.*;
import javax.swing.*;

/**Graafisen käyttöliittymän käynnistysluokka. Sisältää pääohjelmasta kutsuttavan run()-metodin,
 * jonka avulla käyttöliittymä käynnistetään sen ensimmäistä ikkunaa kutsumalla.
 * @author Tommi
 */

public class GraafinenKayttoliittyma implements Runnable{
    
    private JFrame frame;
    private JPanel peli;
    private PeliIkkuna ruutu;
    private AloitusIkkuna alku;
    
    /**Luokan konstruktori, parametriton, valmistelee pelin luomalla AloitusIkkuna-luokan 
     * ilmentymän.
     * 
     */
    public GraafinenKayttoliittyma(){        
        this.alku = new AloitusIkkuna();
    }
    
    /**Runnable-rajapinnan toteuttamiseen vaadittava metodi, joka mahdollistaa käyttöliittymän
     * ajamisen. Luo käyttöliittymän ensimmäisen ikkunan, valmistelee sen graafisen elementit, 
     * pakkaa ne JFrame-olioon, jonka se asettaa näkyväksi.
     * 
     */
    @Override
    public void run(){        
        frame = alku.luoKomponentit();       
        frame.pack();
        frame.setVisible(true);
   }    
}
