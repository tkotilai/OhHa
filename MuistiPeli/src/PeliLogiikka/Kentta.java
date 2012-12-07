package PeliLogiikka;
import java.util.*;

/**Luokka kenttä toimii pelinappuloiden "varastona", josta niiden tilaan pääsee käsiksi. 
 * Pelilaudan abstraktio.
 * 
 * @author Tommi
 */
public class Kentta {
  private Nappula nappulat[];
  private int koko;
  
  /**Luokan konstruktori, vaatii parametrina luotavan kentan koon. Nappulat tallennetaan taulukkoon,
   * jonka koko on pelikentän koko.
   * 
   * @param koko 
   */
  public Kentta(int koko){
      this.nappulat = new Nappula[koko];
      this.koko = koko;
  }
  
  /**Metodi palauttaa indeksilla i sijaitsevan nappulan, käyttö lähinnä testitarkoituksessa.
   * 
   * @param i
   * @return 
   */
  public Nappula palautaNappula(int i){
      return nappulat[i];
  }
  
  /**Metodi arpoo satunnaisluvun, jonka avulla nappuloita voidaan arpoa pelikentälle.
   * 
   * @return 
   */
  public int satunnainenPaikka(){
      Random randomizer = new Random();
      int nappulanPaikka = randomizer.nextInt(koko);
      return nappulanPaikka;
  }
  
 /**Metodi lisää parametrinä annetun nappulan satunnaiseen paikkaan kentällä. Metodi muokattu
  * toimivaksi.
  * 
  * @param nappula 
  */
  public void lisaaNappulaKentalle(Nappula nappula){
        boolean paikkaLoytynyt = false;
        int nappulanPaikka = satunnainenPaikka();
              
        while(paikkaLoytynyt == false){
            if (onkoTaysi() == true){
                paikkaLoytynyt = true;
            }   
            if(nappulat[nappulanPaikka] == null){
                nappulat[nappulanPaikka] = nappula;
                paikkaLoytynyt = true;
            }
            nappulanPaikka = satunnainenPaikka();
        }   
  }
  
  /**Metodi palauttaa pelikentän koon
   * 
   * @return 
   */
  public int kentanKoko(){
      return nappulat.length;
  }
  
  /**Metodi testaa ovatko kaksi nappulaa kentällä olevaa nappulaa pareja vertaamalla niiden tunnisteita.
   * Laitetaan syötteiden sopivuuden tarkastaminen sovelluslogiikan tehtäväksi?
   * 
   * @param nappula1
   * @param nappula2
   * @return 
   */
  public boolean onPari(int nappula1, int nappula2){
      if(nappulat[nappula1].kerroTunniste() == nappulat[nappula2].kerroTunniste()
              && nappula1 != nappula2){
          return true;
      } else {
          return false;
      }
  }
  
  /**Metodilla avataan yksi nappula näkyväksi. Käytetään kääntämään nappula näkyviin
   * pelivuoron aikana.
   * 
   * @param paikka 
   */
  public void naytaNappula(int paikka){ //<-testit!
      nappulat[paikka].avaaNappula();
  }
  
  /**Metodilla käännetään nappula piiloon, käytetään piilottamaan nappula etsintäyrityksen
   * jälkeen.
   * 
   * @param paikka 
   */
  public void piilotaNappula(int paikka){//<-testit!
      nappulat[paikka].piilotaNappula();
  }
  
  /**Metodi asettaa syötteen mukaisella paikalla olevan nappulan löydetyksi.
   * 
   * @param paikka 
   */
  public void loydaNappula(int paikka){
      nappulat[paikka].loydetty();
  }
  
  /** Metodi muuttaa löydetyn parin näkyväksi. Toimii tekstikäyttöliittymässä.
   * 
   * @param nappula1
   * @param nappula2 
   */
  public void naytaPari(int nappula1, int nappula2){
      nappulat[nappula1].avaaNappula();
      nappulat[nappula2].avaaNappula();
  }
  
  /**Metodilla voidaan tarkistaa onko kenttä täysi, eli onko jokaisessa taulukon paikassa nappula.
   * Käytetään kentän alustamisessa peliä varten.
   * 
   * @return 
   */
  private boolean onkoTaysi(){
      int tyhjienLaskuri = 0;
      for (int i = 0; i < nappulat.length; i++){
          if (nappulat[i] == null){
              tyhjienLaskuri++;
          }
      }
      if (tyhjienLaskuri == 0){
          return true;
      } else {
          return false;
      }
  }
  
  /** Toistaiseksi hyödytön testausmielessä kasattu toString-metodi. Ignore!.
   * 
   * @return 
   */
    @Override
  public String toString(){
      String sisalto = "";
      for (int i = 0; i < nappulat.length; i++){
          if (nappulat[i] == null){
              sisalto = sisalto + "tyhja, ";
          } else {
            sisalto = sisalto + nappulat[i].toString() + ", ";
          }  
      }
      return sisalto;
  }
  
  /**Tekstikäyttöliittymää varten luotu metodi, jonka tehtävä on huolehtia tulosteen ulkoasusta.
   * 
   * @return 
   */
  public String piirraKentta(){
      String kentta = "";
      for (int i = 0; i < nappulat.length; i++){
          if (i == (nappulat.length/2)){
              kentta = kentta + "\n";
          }
          kentta = kentta + piirraPaikka(i) + " ";
      }
      kentta = kentta + "\n";
      return kentta;
  }
  
  /**Apumetodi kentän piirtämiseen tekstisovelluksessa. Täyttää kentän ruudut.
   * 
   * @param i
   * @return 
   */
  private String piirraPaikka(int i){
      if (nappulat[i].aukiVaiKiinni() == false){
          return "x";
      } else {
          return nappulat[i].toString();
      }
  }
}
