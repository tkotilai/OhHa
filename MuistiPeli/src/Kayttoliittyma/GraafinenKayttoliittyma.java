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
    
    
    public GraafinenKayttoliittyma(){
        
    }
    
    @Override
    public void run(){
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

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
