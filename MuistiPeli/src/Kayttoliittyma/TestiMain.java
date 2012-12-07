
package Kayttoliittyma;

import java.util.*;
import PeliLogiikka.*;
import Kayttoliittyma.*;
import java.io.*;
import javax.swing.SwingUtilities;
public class TestiMain {
    
    /**Main-luokka ohjelman testaamiseksi.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        GraafinenKayttoliittyma graafis = new GraafinenKayttoliittyma();
        graafis.run();
//        try{
//            File tiedosto = new File("lukijantestausta.txt");
//            TiedostonHallinta tiedostot = new TiedostonHallinta(tiedosto);
//            System.out.println(tiedostot.lueTiedostosta());
//        } catch (Exception e){
//            System.out.println("virhe");
//        }

//        return rivi;

//        // tiedosto mistä luetaan
//        Scanner lukija = null;
//            
//        try {
//            File tiedosto = new File("lukijantestausta.txt");
//            lukija = new Scanner(tiedosto);
//        } catch (Exception e) {
//            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
//            return; // poistutaan metodista
//        }
//
//        while (lukija.hasNextLine()) {
//            String rivi = lukija.nextLine();
//            System.out.println(rivi);
//        }
//
//        lukija.close();
//    }   
        

//        GraafinenKayttoliittyma graafis = new GraafinenKayttoliittyma();
//        SwingUtilities.invokeLater(graafis);
    }
}

        

        
//        Pelaaja pelaaja = new Pelaaja(lukija.nextLine());  
//        Logiikka peli = new Logiikka("helppo", pelaaja);
//        peli.taytaKentta();
//        
//        Tekstikayttoliittyma kayttis = new Tekstikayttoliittyma (lukija, peli, pelaaja);

        
//        kayttis.runPeli();
//    
//        peli.taytaKentta();
//        System.out.println(peli.piirraKentta());
//        peli.etsiParia(1, 2);
//        System.out.println(peli.piirraKentta());
        
//        kayttis.alustaPeli();
//        kayttis.pelaaVuoro();
//        kayttis.pelaaVuoro();        
//        kayttis.pelaaVuoro();
//        kayttis.pelaaVuoro();       
//    }
//}
