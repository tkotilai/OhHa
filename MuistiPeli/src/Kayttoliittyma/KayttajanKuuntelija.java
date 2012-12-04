package Kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import PeliLogiikka.*;

public class KayttajanKuuntelija implements ActionListener{
    private JTextField kentta;
    private TiedostonHallinta hallinta;
    private File tiedosto;
    
    public KayttajanKuuntelija(JTextField kentta){
        this.kentta = kentta;        
        try{
            this.tiedosto = new File("kayttajalista.txt");
            this.hallinta = new TiedostonHallinta(tiedosto.getName());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String kayttajalista = hallinta.lueTiedostosta(tiedosto);
        if(!kayttajalista.contains(kentta.getText())){
            hallinta.kirjoitaTiedostoon(kentta.getText(),tiedosto);
        }
    }
}
