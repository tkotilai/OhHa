package PeliLogiikka;

import java.io.*;
import java.util.*;

/**Luokka pelin tarvitsemien tiedostojen, kuten käyttäjä-, highscore-, ja salalista-tiedostojen
 * kirjoittamiselle ja lukemiselle. Valitettavasti, koodi ei toimi, vaikka jossain vaiheessa
 * minulla oli toimiva koodi!? Seurauksena statistiikka ja kayttajien hallinta jäivät tekemättä.
 * 
 * @author Tommi
 */
public class TiedostonHallinta {
    
    private FileWriter tallennin;
    private File tiedosto;
    
    /**Luokan konstruktori, ottaa parametrinaan käsiteltävän tiedoston nimen. Oletuksena
     * tiedostojen on oltava projektin juuressa.
     * 
     * @param nimi
     * @throws Exception 
     */
    public TiedostonHallinta(/*String nimi*/ File tiedosto) {
        try{
            this.tiedosto = tiedosto;
            this.tallennin = new FileWriter(tiedosto);
        } catch (Exception e){
            System.out.println("Virhe: " + e.getMessage());
        }     
    }
    
    /**Metodi tiedostoon kirjoittamiselle. Ottaa parametrinään tiedoston lisättävän tekstin 
     * String-oliona ja sen tiedoston nimen, johon ollaan kirjoittamassa.
     * 
     * @param lisattava
     * @param tiedosto
     * @return 
     */
    public boolean kirjoitaTiedostoon(String lisattava/*, File tiedosto*/){
        String lista = lueTiedostosta();
        //if(!lista.contains(lisattava)){
            try{              
                //tallennin.write(lista);
                //tallennin.write(lisattava);
                
                tallennin.append(lisattava);
                tallennin.close();
                return true;
            } catch (Exception e ){
                System.out.println("Virhe: " + e.getMessage());
            }
       // }
        return false;
    }
    
    /**Metodi tiedostojen lukemiselle. Ottaa parametrinään tiedoston nimen. Korjattava 
     * yleismuotoisemmaksi, nyt perustuu käyttäjälistan luomiseen.
     * 
     * @param tiedosto
     * @return 
     */
    public String lueTiedostosta(){

        StringBuilder rakentaja = new StringBuilder();
        
            try{
                Scanner lukija = new Scanner(tiedosto);
                
                while(lukija.hasNextLine()){
                    String rivi = lukija.nextLine();
                    rakentaja.append(rivi);
                    rakentaja.append("\n");
                }
            }   catch(Exception e){
//                System.out.println("Ei tiedostoa" + e.getMessage());
//                return "Ei valintaa";
            }
            return rakentaja.toString();
     



//        String rivi ="";
//        File testi = new File("testi.txt");
//        Scanner apulainen;
//
//        try {
//            apulainen = new Scanner(tiedosto);
//            while (apulainen.hasNextLine()) {
//                rivi = rivi + apulainen.nextLine() + "\n"; 
//            }
//
//            apulainen.close();
//            return rivi;            
//        } catch (Exception e) {
//            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
//            return "";
//        }



    }
}
