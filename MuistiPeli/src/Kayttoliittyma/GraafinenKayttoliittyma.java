package Kayttoliittyma;

import java.awt.*;
import javax.swing.*;

/**Luonnos graafiselle käyttöliittymälle, toistaiseksi sisältää lähinnä Swing-harjoittelua ja 
 * kertausta.
 * 
 * @author Tommi
 */

public class GraafinenKayttoliittyma implements Runnable{
    
    private JFrame frame;
    private Peliruutu ruutu;
    private AloitusIkkuna alku;
    
    
    public GraafinenKayttoliittyma(){
        
    }
    
    @Override
    public void run(){
        alku = new AloitusIkkuna();
        ruutu = new Peliruutu(16);
//        frame = alku.luoKomponentit();
//        frame.pack();
//        frame.setVisible(true);
//        frame.dispose();
//        
        frame = ruutu.luoKomponentit();

        frame.pack();
        frame.setVisible(true);
        

    }

    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        JLabel teksti = new JLabel("Pelaaja, anna nimesi.");
        JTextField nimi = new JTextField();
        JButton nappi = new JButton("Hyvaksy");
        
        container.add(teksti, BorderLayout.NORTH);
        container.add(nimi, BorderLayout.CENTER);
        container.add(nappi, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
