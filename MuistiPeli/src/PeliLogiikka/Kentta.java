package PeliLogiikka;
import java.util.*;

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
      if(nappulat[nappula1].kerroTunniste() == nappulat[nappula2].kerroTunniste()){
          return true;
      } else {
          return false;
      }
  }
  
  /** Metodi muuttaa löydetyn parin näkyväksi.
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
  /**Kokeellista tekstikäyttöliittymää varten luotu metodi, jonka tehtävä on huolehtia tulosteen ulkoasusta.
   * Ei toimi oikein toistaiseksi.
   * 
   * @return 
   */
  public String piirraKentta(){
      String kentta = "";
      for (int i = 0; i < nappulat.length; i++){
          if(nappulat[i].aukiVaiKiinni()== false){
              kentta = kentta + " x ";
          } else {
              kentta = kentta + nappulat[i].toString();
          }
      }
 
      return kentta;
  }
}
