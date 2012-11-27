package PeliLogiikka;

import java.io.*;
import java.util.*;
/**Luokka pelin tarvitsemien tiedostojen, kuten käyttäjä-, highscore-, ja salalista-tiedostojen
 * kirjoittamiselle ja lukemiselle. Testit puuttuvat.
 * 
 * @author Tommi
 */
public class TiedostonHallinta {
    
    private FileWriter tallennin;
    private File tiedosto;
    
    /**Luokan konstruktori, ottaa parametrinään käsiteltävän tiedoston nimen. Oletuksena
     * tiedostojen on oltava projektin juuressa.
     * 
     * @param nimi
     * @throws Exception 
     */
    public TiedostonHallinta(String nimi) throws Exception{
        this.tiedosto = new File(nimi);
        this.tallennin = new FileWriter(this.tiedosto);
    }
    
    /**Metodi tiedostoon kirjoittamiselle. Ottaa parametrinään tiedoston lisättävän tekstin 
     * String-oliona ja sen tiedoston nimen, johon ollaan kirjoittamassa.
     * 
     * @param lisattava
     * @param tiedosto
     * @return 
     */
    public boolean kirjoitaTiedostoon(String lisattava, File tiedosto){
        String lista = lueTiedostosta(tiedosto);
        if(lista.contains(lisattava)==false){
            try{              
                tallennin.write(lista);
                tallennin.write(lisattava);
                tallennin.close();
                return true;
            } catch (Exception e ){
                System.out.println("Virhe: " + e.getMessage());
            }
        }
        return false;
    }
    
    /**Metodi tiedostojen lukemiselle. Ottaa parametrinään tiedoston nimen. Korjattava 
     * yleismuotoisemmaksi, nyt perustuu käyttäjälistan luomiseen.
     * 
     * @param tiedosto
     * @return 
     */
    public String lueTiedostosta(File tiedosto){
        String rivi ="";
        Scanner apulainen;

        try {
            apulainen = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return "";
        }

        while (apulainen.hasNextLine()) {
            rivi = rivi + apulainen.nextLine() + "\n"; 
        }

        apulainen.close();
        return rivi;
    }
}
