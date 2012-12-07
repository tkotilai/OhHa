package Kayttoliittyma;
import PeliLogiikka.*;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**Tekstikäyttöliittymä mahdollistaa muistipelin pelaamisen. Se ottaa
 * vastaan syötteitä käyttäjältä, varmistaa niiden sopivuuden ja kutsuu muita luokkia pelin
 * pyörittämiseksi.
 * 
 * @author Tommi
 */
public class Tekstikayttoliittyma {
    private Scanner lukija;
    private Logiikka peli;
//    private File highscore;
//    private File kayttajat;
//    private File salasanat;
//    private TiedostonHallinta tiedostot;
//    
/**Luokan konstruktori.
 * 
 * @param lukija
 * @param peli
 * @param pelaaja 
 */
    public Tekstikayttoliittyma(Scanner lukija, Logiikka peli){
        this.lukija = lukija;
        this.peli = peli;
//        this.kayttajat = new File("testi.txt");
//        this.highscore = new File("highscore.txt");        
    }
    
/**Metodi valmistaa pelilaudan pelaamista varten.
 * 
 */
    public void alustaPeli(){ //<-toistaiseksi public-määreellä testausta varten, myöhemmin private
        peli.taytaKentta();
    }
    
/**Metodi, joka sisältää yhden vuoron aikana tehtävät toimenpiteet. <-Pitäisi varmaan siirtää
 * logiikan puolelle?
 * 
 * @return 
 */
    public boolean pelaaVuoro(){//<-toistaiseksi public-määreellä testausta varten, myöhemmin private
        System.out.println(peli.piirraKentta());
        
        System.out.println("Etsi pari. Anna ensimmaisen parin koordinaatit." + "\n" +
                "0 lopettaa pelin.");
        int eka = otaSyote();
        
        if (eka < 0){
            return true;
        }

        peli.naytaNappula(eka);   
            
        System.out.println("Anna toisen parin koordinaatit"+ "\n" +
                "0 lopettaa pelin.");
        int toka = otaSyote();
        
        if (toka < 0){
            return true;
        }

        peli.naytaNappula(toka);
        
        if(peli.etsiParia(eka, toka) == false){
            peli.piilotaNappulat(eka,toka);
            System.out.println("Ei pari.");
        } else {
            System.out.println("Loysit parin!");
            peli.kasvataPisteita(eka, toka);
        }
        
        if(peli.onkoPeliLoppu()==true){
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
        
        System.out.println(peli.pelaajanNimi() + "\n" + "Pisteet: " + peli.annaPisteet());
        peli.pelaaVuoro();
        return false;
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
                
                if(syote<=0){
                    syote = 0;
                    return syote;
                }
                
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
    
/**Metodi, jolla pelin pelaaminen käynnistetään.
 * 
 */
    public void runPeli(){
        boolean loppu = false;
        alustaPeli();        

        while(loppu == false){
            loppu = pelaaVuoro();
            if(loppu==true){
                break;
            }
            if(peli.onkoPeliLoppu()==true){
                break;
            }
        }
        
        System.out.println("Peli loppu!" + "\n" + peli.pelaajanNimi() +
                ", pisteesi ovat: " + peli.annaPisteet() + "\n" + 
                "Sinulla meni siihen " + peli.getVuoro() + " vuoroa.");
    }   
}
