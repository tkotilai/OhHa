
package Kayttoliittyma;

import java.util.*;
import PeliLogiikka.*;
public class TestiMain {

    public static void main(String[] args) {
        Pelaaja pelaaja = new Pelaaja("Tahvo");
        Logiikka peli = new Logiikka(1, pelaaja);
        Kentta kentta = new Kentta(1500);
        
        kentta.lisaaNappulaKentalle(new Nappula(0));
        kentta.lisaaNappulaKentalle(new Nappula(1));
       


    }
}
