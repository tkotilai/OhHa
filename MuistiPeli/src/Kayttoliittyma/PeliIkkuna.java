package Kayttoliittyma;

import PeliLogiikka.Logiikka;
import PeliLogiikka.Pelaaja;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**Pelin pääkäyttöliittymäikkunan luova luokka. Mahdollistaa pelin pelaamisen, ja 
 * näyttää käyttäjälle hänen pisteensä, nimensä, pelilaudan ja vuorot.
 * JPanel-luokan aliluokka.
 * 
 * @author Tommi
 */
public class PeliIkkuna extends JPanel{
    private JLabel vuorot;
    private JLabel pisteet;
    private Peliruutu pelikentta;
    private Pelaaja pelaaja;    
    private Logiikka logiikka;
    private int klikkaukset;
    
    /**Luokan konstruktori. Ottaa parametrinaan Pelaaja-olion ja pelin vaikeustason
     * määrittävän String-olion ("helppo" tai "vaikea") ja luo uuden pelin näiden
     * mukaan. Kutsuu yliluokan konstruktoria.
     * 
     * @param pelaaja
     * @param vaikeustaso 
     */
    public PeliIkkuna(Pelaaja pelaaja, String vaikeustaso){        
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(500, 250));
        this.pelaaja = pelaaja;
        this.logiikka = new Logiikka(vaikeustaso, pelaaja );
        this.pelikentta = new Peliruutu(logiikka, this);       
        this.klikkaukset = 0;
    }
    
    /**Metodi luo käyttöliittymäikkunan graafiset elementit, kuten nimi- ja pistekentän
     * sekä itse pelilaudan. Metodi palauttaa PeliIkkuna-luokan ilmentymän, jota
     * käsitellään JPanelina.
     * 
     * @return 
     */
    public PeliIkkuna luoKomponentit(){
        vuorot = new JLabel("Vuoro: " + logiikka.getVuoro());
        this.add(vuorot);
        JPanel peli = pelikentta.luoKomponentit();
        this.add(peli);
        pisteet = new JLabel(pelaaja.getNimi() +" Pisteet: "+ pelaaja.getPisteet());
        this.add(pisteet);
        
        return this;
    }
    
    /**Metodi päivittää ikkunassa olevat JLabel-kentät, kun pelitilanteessa tapahtuu
     * muutoksia.
     * 
     */
    public void paivitaKentat(){
        klikkaukset ++;
        pisteet.setText(pelaaja.getNimi() +" Pisteet: "+ pelaaja.getPisteet());
        
        if(klikkaukset <2){
            vuorot.setText("Vuoro: " + logiikka.getVuoro());
            klikkaukset = 0;            
        }   
    }
}
