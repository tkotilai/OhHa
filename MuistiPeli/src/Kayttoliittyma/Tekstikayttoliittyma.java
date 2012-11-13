package Kayttoliittyma;
import PeliLogiikka.*;
import java.util.*;


public class Tekstikayttoliittyma {
    private Scanner lukija;
    private Logiikka peli;
    
    /**Luokan konstruktori... Tarvitsee työtä ja harkintaa, tämän hetkisessä tuotoksessa ei ole mitään
     * järkeä.
     * 
     */
    public Tekstikayttoliittyma(){
        this.lukija = new Scanner(System.in);
        System.out.println("Syota pelaajan nimi");
        String nimi = lukija.nextLine();
        System.out.println("Anna vaikeustaso: 1 on helppo, muut numerot vaikea");
        int vaikeustaso = lukija.nextInt();
        this.peli = new Logiikka(vaikeustaso, new Pelaaja(nimi));
    }
    
}
