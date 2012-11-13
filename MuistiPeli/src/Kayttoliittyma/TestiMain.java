
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
        int n = 0;
        Pelaaja pelaaja = new Pelaaja("Tahvo");
        Logiikka peli = new Logiikka(1, pelaaja);
        Scanner lukija = new Scanner(System.in);
        //Tekstikayttoliittyma kayttis = new Tekstikayttoliittyma();
        

        peli.taytaKentta();
        System.out.println(peli.piirraKentta());
        while (n < 4){

            System.out.println("Etsi pareja, valitse paikat."+ "\n" + "Anna ensimmäinen syöte.");
            int ensimmainen = lukija.nextInt();
            System.out.println("Anna toinen syöte.");
            int toinen = lukija.nextInt();

            peli.etsiParia(ensimmainen, toinen);
            System.out.println(peli.piirraKentta());
            n++;
        }
        //System.out.println(peli.toString());

     
    }
}
