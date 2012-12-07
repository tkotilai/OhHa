package Kayttoliittyma;

import PeliLogiikka.Logiikka;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**Graafisen käyttöliittymän viimeisen ikkunan toteuttava luokka, jota kutsutaan
 * kun pelaaja läpäisee pelin. Tarjoaa mahdollisuuden uuden pelin aloittamiseen, 
 * HighScore-listan tarkastelemiseen (ei toimi) ja pelin lopettamiseen. 
 * Luokka on JFrame-luokan aliluokka ja se implementoi ActionListener-rajapinnan
 * nappuloiden käyttöä varten.
 * 
 * @author Tommi
 */
public class LoppuIkkuna extends JFrame implements ActionListener{
    private JFrame peliLoppu;
    private Logiikka logiikka;
    
    /**Luokan konstruktori, ottaa parametrinaan pelin Logiikka-olion, jolta se
     * kysyy pelaajan tiedot, jotta ne voitaisiin tallettaa Highscore-listalle.
     * Kutsuu JFrame-luokan konstruktoria.
     * 
     * @param logiikka 
     */
    public LoppuIkkuna(Logiikka logiikka){
        super("Peli loppui!");
        this.logiikka = logiikka;
    }
    
    /**Metodi, jossa luodaan ja asetellaan luokan graafiset elementit. Luo 
     * tiedotteen edellisen pelin tuloksista ja tarjoaa käyttäjälle mahdollisuuden
     * uuden pelin pelaamiseen, HighScore-listan tarkastelemiseen ja pelin 
     * lopettamiseen.
     * 
     * @return Palauttaa luokan ilmentymän, JFramen aliluokka.
     */
    public LoppuIkkuna luoKomponentit(){
        this.setLocationRelativeTo( null );        
        JTextArea onnittelu = new JTextArea("Onnea, " + logiikka.pelaajanNimi() + 
         " ,voitit pelin!" + "\n" + "Pisteesi ovat: " + logiikka.annaPisteet());
        JPanel napit = new JPanel();
        napit.setLayout(new GridLayout(4,1));
        JButton uusiPeli = new JButton("Uusi peli?");
        JButton highScore = new JButton("HighScore-lista");
        JButton lopetus = new JButton("Lopeta");
        uusiPeli.addActionListener(this);
        highScore.addActionListener(this);
        lopetus.addActionListener(this);
        napit.add(onnittelu);        
        napit.add(uusiPeli);
        napit.add(highScore);
        napit.add(lopetus);                       
        this.add(napit);
        
        return this;
    }
    
    /**Metodi, jolla käyttäjä voi aloittaa uuden pelin. Piilottaa nykyisen ikkunan 
     * ja avaa uuden AloitusIkkunan.
     * 
     */
    public void uusiPeli(){
        this.dispose();
        AloitusIkkuna alkuun = new AloitusIkkuna();
        alkuun.luoKomponentit();
        alkuun.pack();
        alkuun.setVisible(true);
    }

    /**Tapahtumankuuntelija-metodi, joka reagoi käyttöliittymän nappien painamiseen.
     * Metodi määrittää mitä nappia on painettu ja toimii sen mukaan. Uusi peli-
     * nappi kutsuu uusiPeli-metodia ja Lopetus-nappi sulkee sovelluksen. 
     * HighScore-lista ei toimi vielä, joten nappulaa ei ole kytketty mihinkään.
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton painettu = (JButton) e.getSource();
        if(painettu.getText().equalsIgnoreCase("Uusi peli?")){
            uusiPeli();
        }
        if(painettu.getText().equalsIgnoreCase("Lopeta")){
            System.exit(0);
        } else {
            
        }
    }
}
