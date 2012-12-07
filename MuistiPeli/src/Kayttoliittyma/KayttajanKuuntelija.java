package Kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import PeliLogiikka.*;

/**Tapahtumankuuntelija-luokka, jonka tehtävänä on ottaa siihen kytketyltä 
 * AloitusIkkuna-oliolta syötteenä pelaajan nimi, se siirtää se eteenpäin muulle
 * käyttöliittymälle ja käynnistää sitten käyttöliittymän seuraava ikkuna. Lisäksi
 * luokan kuuluisi tallentaa käyttäjän tiedot käyttäjälistaan, mutta ikävä kyllä
 * TiedostonHallinta-koodini ei jostain mystisestä syystä toimi.
 *
 * @author Tommi
 */

public class KayttajanKuuntelija implements ActionListener{
    //private PeliIkkuna ruutu;
    private PelinAlustaja seuraava;
    private JTextField kentta;    
    private TiedostonHallinta hallinta;
    private File tiedosto;
    private AloitusIkkuna ikkuna;

    /**Luokan konstruktori. Ottaa parametrinaan AloitusIkkuna-olion ja siinä sijaitsevan 
     * JTextField-tekstikenttäolion. 
     * 
     * @param kentta
     * @param ikkuna 
     */
    public KayttajanKuuntelija(JTextField kentta, AloitusIkkuna ikkuna){
        this.kentta = kentta;        
        this.ikkuna = ikkuna;
        try{
            this.tiedosto = new File("kayttajalista.txt");
            this.hallinta = new TiedostonHallinta(tiedosto);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
    
    /**Tapahtumankuuntelun toteuttava metodi. Painettaessa AloitusIkkunassa olevaa 
     * "Ok"-nappia, metodi kirjoittaa käyttäjän nimen käyttäjälista-tiedostoon (jos sitä ei
     * ole siellä vielä) ja käynnistää seuraavan käyttöliittymän ikkunan.
     * 
     * Ei valitettavasti toimi oikein, koska TiedostonHallinta ei jostain syystä toimi
     * ( lueTiedostosta()-metodi palauttaa aina tyhjän String-olion?!).
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae){
        String kayttajalista = hallinta.lueTiedostosta();
        if(!kayttajalista.contains(kentta.getText())){
            hallinta.kirjoitaTiedostoon(kentta.getText());
            ikkuna.syottoOnnistui();
        } else {
            ikkuna.syottoOnnistui(); //<- tähän pitäisi luoda optio vanhan käyttäjän lataamiselle.
        }
        if(ikkuna.onnistuikoSyotto()==true){
            ikkuna.dispose();
            seuraava = new PelinAlustaja(ikkuna.syotteenPalauttaja());
            seuraava.setLocationRelativeTo( null );
            seuraava.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);                                
            seuraava.luoKomponentit();
            seuraava.pack();
            seuraava.setVisible(true);                        
        }
            
    }            
}
