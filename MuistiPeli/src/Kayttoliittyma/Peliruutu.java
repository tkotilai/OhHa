package Kayttoliittyma;

import PeliLogiikka.Logiikka;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**Luokka toteuttaa graafisen pelilaudan, jolla peliä pelataan. Luokka implementoi
 * ActionListener-rajapinnan, jonka avulla pelinappuloita käsitellään.
 * 
 * @author Tommi
 */
public class Peliruutu implements ActionListener{

    private JPanel ikkuna;   
    private Logiikka logiikka;
    private JButton nappi;
    private JButton []nappitaulukko;
    private PeliIkkuna peli;
    private int montakoKaannetty;

/** Luokan konstruktori, ottaa parametrinaan pelilogiikkaa edustavan Logiikka-luokan
 * ilmentymän ja PeliIkkunan, johon luokan ilmentymä liitetään (<-käytetään pisteiden
 * päivittämiseen).
 * 
 * @param logiikka 
 * @param peli 
 */    
    public Peliruutu(Logiikka logiikka, PeliIkkuna peli){
        this.ikkuna = new JPanel();
        this.logiikka = logiikka;
        this.nappitaulukko = new JButton[logiikka.pelikentanKoko()];
        this.montakoKaannetty = 0;
        this.peli = peli;
//        this.eka = 0;
//        this.toka = 0;
    }
    
    /**Metodi luo pelilaudan graafiset elementit, eli napit joihin pelinappulat 
     * liitetään, sekä asettaa nämä GridLayoutin mukaisesti pelilaudalle, sekä
     * nappulataulukkoon. Layoutin ja ruudun
     * koko määräytyy vaikeusasteen mukaan.
     * 
     * @return Palauttaa JPanel-luokan ilmentymän.
     */
    public JPanel luoKomponentit() {
        int i = 0;
        logiikka.taytaKentta();
        if(logiikka.getVaikeus().equalsIgnoreCase("helppo")){
            ikkuna.setLayout(new GridLayout(4,4));
            ikkuna.setPreferredSize(new Dimension(400, 200));
        }
        if(logiikka.getVaikeus().equalsIgnoreCase("vaikea")){
            ikkuna.setLayout(new GridLayout(4,8));
            ikkuna.setPreferredSize(new Dimension(400, 300));            
        }
                
        while(i < logiikka.pelikentanKoko()){
            nappi = new JButton("?");
            nappi.setBackground(Color.CYAN);
            nappi.addActionListener(this);
            this.nappitaulukko[i] = nappi; 
            ikkuna.add(nappi);                        
            i++;
        }
                      
        return ikkuna;
    }
    
    /**Metodi lopettaa pelin, mikäli  nappulat on löydetty. Tällöin se avaa
     * LoppuIkkunan, josta pelin voi aloittaa uudelleen halutessaan.
     * 
     */
    public void peliLoppui(){
        for(int i = 0; i < logiikka.pelikentanKoko(); i++){
            nappitaulukko[i].setText("Voitit!");
            nappitaulukko[i].setBackground(Color.YELLOW);          
        }
//        this.ikkuna.setVisible(false);
        LoppuIkkuna lopetus = new LoppuIkkuna(logiikka);
        lopetus.luoKomponentit();
        lopetus.pack();
        lopetus.setVisible(true);               
    }
    
    /**Tapahtumankuuntelija-metodi, jota kutsutaan pelilaudan nappia klikattaessa.
     * Suorittaa pelaamisen yhdistämällä napin painalluksen logiikan kautta 
     * nappuloihin ja etsii näistä pareja.
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) { //<-- Pitäisi kai pilkkoa metodeihin?
        int []hakutaulukko = new int [] {-1, -1}; 
        peli.paivitaKentat();
             
        JButton valittu = (JButton) e.getSource();   
        valittu.setBackground(Color.red);
       
        for(int i = 0; i < logiikka.pelikentanKoko(); i++){
            if(nappitaulukko[i].equals(valittu)){
                hakutaulukko[0] = i;                
                valittu.setText(logiikka.nappulanTunniste(i));
                logiikka.avaaNappula(i);        
            }             
        }

        for(int i = 0; i < logiikka.pelikentanKoko(); i++){
            if(logiikka.onkoAuki(i)==false){
                nappitaulukko[i].setBackground(Color.CYAN);
                nappitaulukko[i].setText("?");
            }
        }        
        
        montakoKaannetty++;       
        
        if(montakoKaannetty ==2){
                        
            
            for(int i = 0; i < logiikka.pelikentanKoko(); i++){            
                if(logiikka.onkoAuki(i) ==true && i != hakutaulukko[0]
                        && logiikka.onkoJoLoydetty(i) == false){
                    hakutaulukko[1] = i;                    
                }
            }
            if(hakutaulukko[0]<0 || hakutaulukko[1] < 0){ //<-estää kaatumisen taulukon
                hakutaulukko = new int []{0,0};         //ulos viittamalla, aiheuttaa bugin
            }
  
            if(logiikka.etsiParia(hakutaulukko[0], hakutaulukko[1]) && hakutaulukko[0] != hakutaulukko[1]){
                logiikka.kasvataPisteita(hakutaulukko[0], hakutaulukko[1]);
                nappitaulukko[hakutaulukko[0]].setEnabled(false);                
                nappitaulukko[hakutaulukko[1]].setEnabled(false);
                logiikka.asetaLoydetyiksi(hakutaulukko[0], hakutaulukko[1]); 
                peli.paivitaKentat();

                ikkuna.validate();
          
            } else {
                logiikka.piilotaNappulat(hakutaulukko[0], hakutaulukko[1]);
            }                                           
            
            if(logiikka.onkoPeliLoppu()==true){
                peliLoppui();
            }
            montakoKaannetty = 0;
            logiikka.pelaaVuoro();
        }        
    }
}