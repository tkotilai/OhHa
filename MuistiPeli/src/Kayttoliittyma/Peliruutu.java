package Kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import PeliLogiikka.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Peliruutu implements ActionListener{

    private JFrame ikkuna;
    private Kentta kentta;    
    private Logiikka logiikka;
    private JButton nappi;
    private JButton []nappitaulukko;
    private Timer ajastin;
    private int montakoKaannetty;
    private int eka;
    private int toka;
    //int[] hakutaulukko;
    
    public Peliruutu(int i){
        this.ikkuna = new JFrame("Muistipeli");
        this.kentta = new Kentta(i);
        this.logiikka = new Logiikka(kentta);
        this.nappitaulukko = new JButton[i];
        this.montakoKaannetty = 0;
        //this.hakutaulukko = new int[2];
        this.ajastin = new Timer(1000,this);
        this.eka = 0;
        this.toka = 0;
    }
    
    public JFrame luoKomponentit() {
        int i = 0;
//        int j = 0;
        logiikka.taytaKentta();//<-jos sijoittelu ei toimi, muunna toimintaa!
        ikkuna.setLayout(new GridLayout(4,4));
        ikkuna.setPreferredSize(new Dimension(400, 200));
        nappi = new JButton("?");
                
        while(i < kentta.kentanKoko()){
//            for(int j = 0; j < 4; j++){
            nappi = new JButton("?");
            nappi.setBackground(Color.CYAN);
            nappi.addActionListener(this);
            this.nappitaulukko[i] = nappi; 
//            nappi.addActionListener(new NappulanKuuntelija(kentta, logiikka, i, ikkuna, nappi));
            ikkuna.add(nappi);                        
//            }
            i++;
        }
        
        
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return ikkuna;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int []hakutaulukko = new int [] {-1, -1};               
                
        JButton valittu = (JButton) e.getSource();   
        valittu.setBackground(Color.red);
       
        for(int i = 0; i < kentta.kentanKoko(); i++){
            if(nappitaulukko[i].equals(valittu)){
                hakutaulukko[0] = i;                
                valittu.setText(kentta.palautaNappula(i).toString());
                kentta.naytaNappula(i);        
            }             
        }

        for(int i = 0; i < kentta.kentanKoko(); i++){
            if(kentta.palautaNappula(i).aukiVaiKiinni()==false){
                nappitaulukko[i].setBackground(Color.CYAN);
                nappitaulukko[i].setText("?");
            }
        }        
        
        montakoKaannetty++;       
        
        if(montakoKaannetty ==2){
            
            for(int i = 0; i < kentta.kentanKoko(); i++){            
                if(kentta.palautaNappula(i).aukiVaiKiinni()==true && i != hakutaulukko[0]
                        && kentta.palautaNappula(i).onkoLoydetty()== false){
                    eka = i;
                    hakutaulukko[1] = i;                    
                }
            }
            if(hakutaulukko[0]<0 || hakutaulukko[1] < 0){ //<-estää kaatumisen taulukon
                hakutaulukko = new int []{0,0};         //ulos viittamalla, aiheuttaa bugin
            }
  
            if(kentta.onPari(hakutaulukko[0], hakutaulukko[1]) && hakutaulukko[0] != hakutaulukko[1]){
                //System.out.println("Pari!");
                nappitaulukko[hakutaulukko[0]].setEnabled(false);
                nappitaulukko[hakutaulukko[1]].setEnabled(false);
                kentta.palautaNappula(hakutaulukko[0]).loydetty();
                kentta.palautaNappula(hakutaulukko[1]).loydetty();                

                ikkuna.validate();
          
            } else {
                kentta.piilotaNappula(hakutaulukko[0]);
                kentta.piilotaNappula(hakutaulukko[1]);
            }                                           
            montakoKaannetty = 0;
        }        
    }
}
