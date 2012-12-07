package Kayttoliittyma;

import PeliLogiikka.Pelaaja;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**Graafisen käyttöliittymän luokka, joka alustaa pelin pelaajan valitseman 
 * vaikeustason mukaan ja kutsuu sitten sen mukaan käyttöliittymän seuraavaa
 * ikkunaa. Luokka on JFrame-luokan aliluokka ja implementoi ActionListener-
 * rajapinnan.
 * 
 * @author Tommi
 */
public class PelinAlustaja extends JFrame implements ActionListener{    
    private JPanel nappularuutu;
    private String pelaajanNimi;
    
    /**Luokan konstruktori. Ottaa parametrinaan pelaajan, jonka avulla se välittää
     * käyttöliittymän seuraavalle ikkunalle. Kutsuu yliluokan konstruktoria.
     * 
     * @param pelaajanNimi 
     */    
    public PelinAlustaja(String pelaajanNimi){
        super("Muistipeli"); 
        this.pelaajanNimi = pelaajanNimi;
    }
    
    /**Metodi luo ikkunan graafiset elementit, eli vaikeustason valinnassa
     * käytettävät napit ja liittää niihin tapahtumankuuntelijan.
     * 
     * @return Metodi palauttaa PelinAlustaja-olion, joka on JFramen aliluokka.
     */
    public PelinAlustaja luoKomponentit(){
        nappularuutu = new JPanel();
        nappularuutu.setLayout(new GridLayout(2,1));
        JButton helppo = new JButton("Helppo");
        helppo.addActionListener(this);
        JButton vaikea = new JButton("Vaikea");
        vaikea.addActionListener(this);
        nappularuutu.add(helppo);
        nappularuutu.add(vaikea);
        this.add(nappularuutu);
        
        return this;
    }
    
    /**Metodi määrittää kumpaa ikkunan kahdesta napista on painettu. Palauttaa
     * 1 mikäli painettu nappula on "helppo" ja 2 mikäli se on "vaikea".
     * Käytetään parametrien syöttämisessä seuraavan ikkunan konstruktorille.
     * 
     * @param e
     * @return 
     */
    private int kumpiNappi(ActionEvent e){
        JButton painettu = (JButton) e.getSource();
        if (painettu.getText().equalsIgnoreCase("helppo")){
            return 1;
        } else {
            return 2;
        }
    }
    
    /**Tapahtumankuuntelija-metodi, joka käynnistää seuraavan käyttöliittymän 
     * ikkunan napin painalluksen yhteydessä ja alustaa siihen liitettävän 
     * pelikentän valitun vaikeusasteen mukaan.
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        JFrame seuraava = new JFrame();
        seuraava.setLocationRelativeTo( null );
        seuraava.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        if (kumpiNappi(e)==1){
            PeliIkkuna ruutu = new PeliIkkuna(new Pelaaja(pelaajanNimi), "helppo");                
            seuraava.add(ruutu.luoKomponentit());
            seuraava.pack();
            seuraava.setVisible(true);
        } else {
            PeliIkkuna ruutu = new PeliIkkuna(new Pelaaja(pelaajanNimi), "vaikea");                
            seuraava.add(ruutu.luoKomponentit());
            seuraava.pack();
            seuraava.setVisible(true);            
        }        
    }        
}
