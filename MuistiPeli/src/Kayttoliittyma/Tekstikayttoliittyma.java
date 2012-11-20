package Kayttoliittyma;
import PeliLogiikka.*;
import java.util.*;

//Lisää metodit pelin lopettamiselle kesken ja tallentamiselle/lataamiselle ja high score-listan generoinnille.
// Sitten luomaan graafista käyttistä. Dokumentaatioon sekvenssikaaviot ja UML-luonnokseen 
//osallistumisrajoitteet ja ohjelman tämänhetkinen kuvaus.


/**Tekstikäyttöliitymä mahdollistaa muistipelin pelaamisen. Se ottaa
 * vastaan syötteitä käyttäjältä, varmistaa niiden sopivuuden ja kutsuu muita luokkia pelin
 * pyörittämiseksi.
 * 
 * @author Tommi
 */
public class Tekstikayttoliittyma {
    private Scanner lukija;
    private Logiikka peli;
    private Pelaaja pelaaja;
    private int vuoro;
    
/**Luokan konstruktori.
 * 
 * @param lukija
 * @param peli
 * @param pelaaja 
 */
    public Tekstikayttoliittyma(Scanner lukija, Logiikka peli, Pelaaja pelaaja){
        this.lukija = lukija;
        this.pelaaja = pelaaja;
        this.peli = peli;
        this.vuoro = 0;
    }
    
/**Metodi valmistaa pelilaudan pelaamista varten.
 * 
 */
    public void alustaPeli(){ //<-toistaiseksi public-määreellä testausta varten, myöhemmin private
        peli.taytaKentta();
    }
    
/**Metodi, joka sisältää yhden vuoron aikana tehtävät toimenpiteet.
 * 
 * @return 
 */
    public boolean pelaaVuoro(){//<-toistaiseksi public-määreellä testausta varten, myöhemmin private
        System.out.println(peli.piirraKentta());
        
        System.out.println("Etsi pari. Anna ensimmaisen parin koordinaatit");
        int eka = otaSyote();

        peli.naytaNappula(eka);   
            
        System.out.println("Anna toisen parin koordinaatit");
        int toka = otaSyote();

        peli.naytaNappula(toka);
        
        if(peli.etsiParia(eka, toka) == false){
            peli.piilotaNappulat(eka,toka);
        } else {
            pelaaja.kasvataPisteita();
        }
        
        if(onkoPeliLoppu()==true){
            vuoro++;
            return true;
        }
        
        while(true){
            System.out.println("Paina enter vaihtaaksesi vuoroa");
            if(lukija.nextLine().isEmpty()){
                break;
            }
        }   
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
        
        System.out.println(pelaaja.getNimi() + "\n" + "Pisteet: " + pelaaja.getPisteet());
        this.vuoro++;
        return true;
    }
    
/**Metodi palauttaa vuoron numeron, voidaan käyttää pelin lopettamiseen tarvittaessa.
 * 
 * @return 
 */
    public int getVuoro(){
        return this.vuoro;
    }
    
/**Metodi vastaanottaa syötteitä käyttäjältä ja varmistaa niiden oikeellisuuden.
 * 
 * @return Palauttaa syotetyn kokonaisluvun.
 */
    public int otaSyote(){ //<-public testauksen vuoksi, myöhemmin private
        while (true){
            try{
                int syote = Integer.parseInt(lukija.nextLine());
                syote = syote - 1;
                while(true){
                    if (syoteHyvaksyttava(syote)==true){
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Syote ei ole sopiva." + "\n" + "Anna uusi koordinaatti");
                        syote = Integer.parseInt(lukija.nextLine());
                        syote = syote - 1;
                    }
                }
                return syote;
            } catch (Exception e){
                System.out.println("Syote ei ole sopiva." + "\n" + "Anna uusi koordinaatti");
            }
        }
    }
    
/**Metodi syötteiden hyväksyttävyyden tarkistamiselle. 
 * 
 * @param syote Ottaa kokonaisluvun syötteenään
 * @return Palauttaa arvon true, jos syöte on ok.
 */
    public boolean syoteHyvaksyttava(int syote){ //<-määre public testauksen vuoksi
        boolean syoteOk = false;
        
        if(syote >= 0){
            syoteOk = true;
        }
        
        if(syote >= peli.pelikentanKoko()){
            syoteOk = false;
        }
        if(peli.onkoJoLoydetty(syote) == true){
            System.out.println("Nappula on jo kaannetty.");
            syoteOk = false;
        }

        return syoteOk;
    }
    
/**Metodi, jolla peli lopetetaan kaikkien parien löydyttyä. Palauttaa arvon true, jos kaikki
 * parit on löydetty.
 * 
 * @return 
 */
    public boolean onkoPeliLoppu(){
        boolean onkoLoppu = false;
        int nappuloidenLaskuri = 0;
        
        for (int i = 0; i < peli.pelikentanKoko(); i++){
            if (peli.onkoJoLoydetty(i)==true){
                nappuloidenLaskuri++;
            }
        }
        
        if (nappuloidenLaskuri == peli.pelikentanKoko()){
            onkoLoppu = true;
        }
        
        return onkoLoppu;
    }
    
/**Metodi, jolla pelin pelaaminen käynnistetään.
 * 
 */
    public void runPeli(){
        alustaPeli();
        
        while(onkoPeliLoppu()==false){
            pelaaVuoro();
        }
        
        System.out.println("Kaikki parit loydetty!" + "\n" + pelaaja.getNimi() +
                ", pisteesi ovat: " + pelaaja.getPisteet() + "\n" + 
                "Sinulla meni siihen " + getVuoro() + " vuoroa.");
    }
    
}
