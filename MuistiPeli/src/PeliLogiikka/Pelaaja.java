package PeliLogiikka;
import java.io.File;

/**Luokka, joka sisältää yhteen pelaajaan liittyvät tiedot, kuten nimen, pisteet ja salasanan 
 * (salasana tallennetaan tekstitiedostoon).
 * 
 * @author Tommi
 */
public class Pelaaja implements Comparable<Pelaaja>{
    private String Nimi;
    private int pisteet;
    private File salasana;

  /** Luokan konstruktori, vaatii nimen parametrina. LIsää comparable
   * 
   * @param nimi 
   */
  public Pelaaja(String nimi){ 
      this.Nimi = nimi;
      this.pisteet = 0; /** Pelaajan pisteet alkavat nollasta*/
  }

  /** Metodi palauttaa pelaajan nimen.
   * 
   * @return 
   */
  public String getNimi(){
      return this.Nimi;
  }
  
//  public void setSalasana(String salasana){
//      this.salasana = salasana;
//  }
//  
//  public String getSalasana(){
//      return this.salasana;
//  }
  
  /**Metodi kasvattaa pelaajan pisteitä yhdellä.*/
  public void kasvataPisteita(){ 
      this.pisteet = pisteet + 1;
  }
  
  public void vahennaPisteita(){
      this.pisteet = pisteet -1;
  }

  /** Metodi palauttaa pelajaan pisteet.
   * 
   * @return 
   */
  public int getPisteet(){
      return this.pisteet;
  }
  
  /**Metodi kahden pelaajan pisteiden vertailulle, käytetään highscore-listan järjestämisessä.
   * Ottaa syötteenään toisen Pelaaja-olion. Palauttaa positiivisen luvun, mikäli pelaajan
   * pistemäärä on korkeampi kuin toisen, nolla mikäli ne ovat yhtäsuuria tai negatiivisen luvun
   * mikäli ne ovat pienemmät. <-Testi?
   * 
   * @param pelaaja
   * @return 
   */
  @Override
  public int compareTo(Pelaaja pelaaja){
     return getPisteet() - pelaaja.getPisteet(); 
  }
}
