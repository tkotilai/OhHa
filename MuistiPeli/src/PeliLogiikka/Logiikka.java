package PeliLogiikka;
import java.util.*;

/**Luokka sisältää pelin pelaamiseen tarvittavat operaatiot, joita käyttöliittymä kutsuu.
 * 
 * @author Tommi
 */
public class Logiikka {
  private Kentta kentta;
  private Pelaaja pelaaja;
  private int vuoro;
  private String vaikeusaste;
  
  /**Luokan konstruktori, luo pelikentan vaikeusasteen mukaan (jonka ottaa parametrinä,
   * liittaa pelaajat peliin, koodi kesken, korjataan myöhemmin oikeaa peliä vastaavaksi.
   * Luokkaan tai käyttöliittymän luokkaan pitää lisätä menetelmät syötteiden oikean muodon
   * tarkistamiseksi.
   * 
   * @param vaikeustaso
   * @param pelaaja 
   */
  public Logiikka (String vaikeusaste, Pelaaja pelaaja){
      this.vaikeusaste = vaikeusaste;
      if(vaikeusaste.equalsIgnoreCase("helppo")){          
          this.kentta = new Kentta(16);
      }
      if(vaikeusaste.equalsIgnoreCase("vaikea")){
          this.kentta = new Kentta(32);
      }
      this.pelaaja = pelaaja;
      this.vuoro = 1;
  }
  /**Metodi palauttaa pelin vaikeusasteen.
   * 
   * @return 
   */
  public String getVaikeus(){
      return this.vaikeusaste;
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
          return true;
      } else {
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
  
  /**Metodi tarkastaa onko syötteenä annetulla paikalla oleva nappula löydetty.
   * Mikäli on, metodi palauttaa true.
   * 
   * @param i
   * @return 
   */
  public boolean onkoJoLoydetty(int i){
      if(kentta.palautaNappula(i).onkoLoydetty()== true){
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
  
  public void avaaNappula(int paikka){
      kentta.naytaNappula(paikka);
  }
  
  public boolean onkoAuki(int paikka){
      if(kentta.palautaNappula(paikka).aukiVaiKiinni()==true){
          return true;
      } else {
          return false;
      }
  }
  
  public void asetaLoydetyiksi(int paikka1, int paikka2){
      kentta.loydaNappula(paikka1);
      kentta.loydaNappula(paikka2);
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
  /**Metodi testaa onko peli loppu, eli ovatko kaikki nappulat jo löydettyjä.
   * Palauttaa true, mikäli näin on, mutten palauttaa false.
   * 
   * @return 
   */
  public boolean onkoPeliLoppu(){ 
      boolean onkoLoppu = false;     
      int nappuloidenLaskuri = 0;
        
      for (int i = 0; i < pelikentanKoko(); i++){
        if (onkoJoLoydetty(i)==true){
            nappuloidenLaskuri++;
        }
      }
        
      if (nappuloidenLaskuri == pelikentanKoko()){
        onkoLoppu = true;
      }        
      return onkoLoppu;
  }
  /**Metodi kasvattaa pelaajan pisteitä, mikäli hän löytää parin. Parin paikat
   * pelikentällä otetaan syötteenä. Lisättyjen pisteiden määrä riippu pelin 
   * vaikeusasteesta. Metodi palauttaa pelaajan sen hetkiset pisteet.
   * 
   * @param i
   * @param j
   * @return 
   */
  public int kasvataPisteita(int i, int j){
      int t = 0;
      if(etsiParia(i,j)==true && vaikeusaste.equalsIgnoreCase("helppo")){
          while(t<20){
              pelaaja.kasvataPisteita();
              t++;
          }
      }
      if(etsiParia(i,j)==true && vaikeusaste.equalsIgnoreCase("vaikea")){
          while(t<10){
              pelaaja.kasvataPisteita();
              t++;
          }
      }
      return pelaaja.getPisteet();
  }
  
  /**Metodi palauttaa pelaajan nimen, käytetään tulosteiden tekemisessä.
   * 
   * @return 
   */
  public String pelaajanNimi(){
      return pelaaja.getNimi();
  }
  
  /**Metodi palauttaa pelaajan pisteet.
   * 
   * @return 
   */
  public int annaPisteet(){
      return pelaaja.getPisteet();
  }
  
  /**Metodi palauttaa sen nappulan tunnisteen, joka sijaitsee parametrina 
   * annetulla koordinaatilla.
   * 
   * @param paikka
   * @return 
   */
  public String nappulanTunniste(int paikka){
      return kentta.palautaNappula(paikka).toString();
  }
  
  /**Metodi suorittaa joka pelivuoroon liittyviä toimenpiteitä. Se kasvattaa 
   * vuoroa yhdellä ja vähentää pelaajan pisteistä yhden joka vuorolla.
   * 
   */
  public void pelaaVuoro(){
      vuoro++;
      if(pelaaja.getPisteet()>0){
          pelaaja.vahennaPisteita();
      }
  }
  
  /**Metodi palauttaa nykyisen vuoron numeron.
   * 
   * @return 
   */
  public int getVuoro(){
      return this.vuoro;
  }
  /**Tekstikäyttöliittymän tulostamiseen tarkoitettu toString()-metodi. 
   * Palauttaa pelikentän tilaa edustavan merkkijonon.
   * 
   * @return 
   */
  @Override
  public String toString(){
      return kentta.toString();
  }
}
