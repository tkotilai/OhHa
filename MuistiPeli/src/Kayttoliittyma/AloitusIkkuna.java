package Kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import PeliLogiikka.*;

/**Graafisen käyttöliittymän luokka, joka aloittaa pelin pelaamisen. Kysyy käyttäjältä tämän nimen.
 * 
 * @author Tommi
 */

public class AloitusIkkuna extends JFrame{
    private JFrame frame;
    private JFrame seuraava;
    private PeliIkkuna ruutu;
    private KayttajanKuuntelija kuuntelija;
    private JTextField syote;
    private boolean syottoOnnistui;    
    
    /**Luokan konstruktori, parametriton. Kutsuu yliluokan (JFrame) konstruktoria.
     * 
     */
    public AloitusIkkuna(){
        super("Muistipeli");
        this.syottoOnnistui = false;
    }
    /**Metodi, joka luo ikkunan graafiset elementit, kuten tekstikentän nimen syöttämistä varten ja
     * nappulan syötteen hyväksymiselle, johon se liittää tapahtumankuuntelijan (KayttajanKuuntelija).
     * 
     * @return Metodi palauttaa AloitusIkkuna luokan ilmentymän, jota käyttöliittymä käsittelee
     * JFrame-yliluokan metodeilla.
     */
    public AloitusIkkuna luoKomponentit(){
        
        this.setPreferredSize(new Dimension(400, 200));
        this.setLayout(new GridLayout(3,1));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo( null );
        
        JLabel kehote = new JLabel("Nimesi?");
        this.add(kehote);
        syote = new JTextField();
        
        this.add(syote);
        JButton hyvaksy = new JButton("Ok");
        this.add(hyvaksy);
        
        hyvaksy.addActionListener(new KayttajanKuuntelija(syote, this));
        
        return this;        
    }
    /**Metodi, muuttaa syottoOnnistui-muuttujan "true"-arvoiseksi, mikäli syötteen tallennus onnistui 
     * tapahtumankuuntelijaa kutsuttaessa.
     * 
     */
    public void syottoOnnistui(){
        syottoOnnistui = true;
    }
    /**Metodi palauttaa muuttujan syottoOnnistui arvon. Käytetään tapahtumankuuntelijassa.
     * 
     * @return 
     */
    public boolean onnistuikoSyotto(){
        return syottoOnnistui;
    }
    /**Metodi palauttaa tekstikentän sisällön, joka annetaan seuraavalle käyttöliittymän ikkunalle
     * pelaajan nimenä.
     * 
     * @return 
     */
    public String syotteenPalauttaja(){
        return syote.getText();
    }
}    
