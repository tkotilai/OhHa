
package Kayttoliittyma;

import java.util.*;
import PeliLogiikka.*;
import Kayttoliittyma.*;
public class TestiMain {
    
    /**Testiluokka ohjelman testaamiseksi.
     * 
     * @param args 
     */

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Kentta testi = new Kentta(12);                
        Logiikka peli = new Logiikka(testi);
        System.out.println("Pelaaja, kerro nimesi.");
        Pelaaja pelaaja = new Pelaaja(lukija.nextLine());
        //peli.taytaKentta();
        
        Tekstikayttoliittyma kayttis = new Tekstikayttoliittyma (lukija, peli, pelaaja);
        kayttis.runPeli();
    
//        peli.taytaKentta();
//        System.out.println(peli.piirraKentta());
//        peli.etsiParia(1, 2);
//        System.out.println(peli.piirraKentta());
        
//        kayttis.alustaPeli();
//        kayttis.pelaaVuoro();
//        kayttis.pelaaVuoro();        
//        kayttis.pelaaVuoro();
//        kayttis.pelaaVuoro();       
    }
}
