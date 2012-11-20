package PeliLogiikka;
import java.util.*;

public class Logiikka {
  private Kentta kentta;
  
  /**Luokan konstruktori, luo pelikentan vaikeusasteen mukaan (jonka ottaa parametrinä,
   * liittaa pelaajat peliin, koodi kesken, korjataan myöhemmin oikeaa peliä vastaavaksi.
   * Luokkaan tai käyttöliittymän luokkaan pitää lisätä menetelmät syötteiden oikean muodon
   * tarkistamiseksi.
   * 
   * @param vaikeustaso
   * @param pelaaja 
   */
  public Logiikka (Kentta kentta){ 
      this.kentta = kentta;
  }
  
  
  /**Metodi, jolla peli etsii pareja pelaajan syötteen perusteella. 
   * Syötteet tulevat käyttöliittymän puolelta parametrien arvoiksi.
   * Vaatinee korjausta.
   * 
   * @param ensimmainen
   * @param toinen
   * @return 
   */
  public boolean etsiParia(int ensimmainen, int toinen){
      
      if (kentta.onPari(ensimmainen, toinen)== true){
          System.out.println("Löysit parin");
          return true;
      } else {
          System.out.println("Ei pari.");
          return false;
      }
  }
  /**Metodi, jolla nappulat laitetaan piiloon vuoron lopuksi, mikäli paria ei ole löytynyt.
   * 
   * @param nappula1
   * @param nappula2 
   */
  public void piilotaNappulat(int nappula1, int nappula2){
          kentta.piilotaNappula(nappula1);
          kentta.piilotaNappula(nappula2);    
  }
  
  public boolean onkoJoLoydetty(int i){
      if(kentta.palautaNappula(i).aukiVaiKiinni()== true){
          return true;
      } else {
          return false;
      }
  }

  /**Metodi alustaa pelikentän vaikeusasteen perusteella, lisäämällä sinne eri tyyppisiä
   * nappuloita pareittain. Tunnisteet yksilöivät nappulat ja niiden numerointi kasvaa juoksevasti
   * aina kun uusi pari on lisätty kentälle/taulukkoon.
   */
  public void taytaKentta(){
      int tunniste = 1;
      
      for(int i = 0; i < kentta.kentanKoko(); i = i+2){
          kentta.lisaaNappulaKentalle(new Nappula(tunniste));
          kentta.lisaaNappulaKentalle(new Nappula(tunniste));
          tunniste ++;
      }    
  }
 
  /**Metodi avaa nappulan näkyviin vuoron ajaksi. Ottaa parametrina nappulan paikan ja palauttaa sen
   * 
   * @param paikka
   * @return 
   */
  public int naytaNappula(int paikka){
      kentta.naytaNappula(paikka);
      System.out.println(piirraKentta());
      return paikka;
  }
  
  /**Metodi palauttaa pelikentän koon.
   * 
   * @return 
   */
  public int pelikentanKoko(){
      return kentta.kentanKoko();
  }
  
  /**Metodi pelikentän tulostamiseen tekstikäyttöliittymää varten. Voidaan kutsua sovelluslogiikan puolelta.
   * Palauttaa merkkiesityksen pelikentästä kutsumalla kentän metodia.
   * 
   * @return 
   */
  public String piirraKentta(){
      return kentta.piirraKentta();
  }
  
  /**Toistaiseksi turha toString-metodi, testauksen vuoksi...
   * 
   * @return 
   */
  @Override
  public String toString(){
      return kentta.toString();
  }
}
