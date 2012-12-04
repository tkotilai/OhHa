package Kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import PeliLogiikka.*;

public class AloitusIkkuna {
    private JFrame ikkuna;
    private ActionListener kuuntelija;
    
    public AloitusIkkuna(){
        this.ikkuna = new JFrame("Muistipeli");
    
    }
    
    public JFrame luoKomponentit(){
        
        ikkuna.setPreferredSize(new Dimension(400, 200));
        ikkuna.setLayout(new GridLayout(3,1));
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel kehote = new JLabel("Nimesi?");
        ikkuna.add(kehote);
        JTextField syote = new JTextField();
        
        ikkuna.add(syote);
        JButton hyvaksy = new JButton("Ok");
        ikkuna.add(hyvaksy);
        this.kuuntelija = new KayttajanKuuntelija(syote);
        hyvaksy.addActionListener(kuuntelija);
        
        return ikkuna;        
    }
}
