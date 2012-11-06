package PeliLogiikka;
import java.util.*;

public class Kentta {
  private ArrayList<Nappula> nappulat;
  private int koko;
  
  /**Luokan konstruktori, vaatii parametrina luotavan kentan koon.
   * 
   * @param koko 
   * Konstruktorin kutsuminen alustaa sen sisältämän ArrayListin tyyppiä "0"
   * olevilla nappuloilla.
   */
  public Kentta(int koko){
      this.nappulat = new ArrayList(koko);
      for(int i=0; i < koko; i ++){
          nappulat.add(new Nappula(0));
      }
      this.koko = koko;
  }
  
  /**Metodi palauttaa indeksilla i sijaitsevan nappulan, käyttö lähinnä testitarkoituksessa.
   * 
   * @param i
   * @return 
   */
  public Nappula palautaNappula(int i){
      return nappulat.get(i);
  }
  
  /**Metodi arpoo satunnaisluvun, jonka avulla nappuloita voidaan arpoa pelikentälle.
   * 
   * @return 
   */
  public int satunnainenPaikka(){
      Random randomizer = new Random();
      int nappulanPaikka = randomizer.nextInt(koko-1);
      return nappulanPaikka;
  }
  
 /**Metodi lisää parametrinä annetun nappulan satunnaiseen paikkaan kentällä.
  * 
  * @param nappula 
  */
  public void lisaaNappulaKentalle(Nappula nappula){
        boolean paikkaLoytynyt = false;
        int nappulanPaikka = satunnainenPaikka();
      
        while(paikkaLoytynyt == false){
            if(nappulat.get(nappulanPaikka).kerroTunniste() == 0){
                nappulat.add(nappulanPaikka, nappula);
                paikkaLoytynyt = true;
                //System.out.println("Loytyi");
            }
        nappulanPaikka = satunnainenPaikka();  
        //System.out.println("Ei vapaana");
        }   
  }
  
  /**Metodi palauttaa pelikentän koon
   * 
   * @return 
   */
  public int kentanKoko(){
      return koko;
  }
  
  /**Metodi testaa ovatko kaksi nappulaa kentällä olevaa nappulaa pareja vertaamalla niiden tunnisteita.
   * 
   * @param nappula1
   * @param nappula2
   * @return 
   */
  public boolean onPari(int nappula1, int nappula2){
      if(nappulat.get(nappula1).kerroTunniste() == nappulat.get(nappula2).kerroTunniste()){
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
      nappulat.get(nappula1).avaaNappula();
      nappulat.get(nappula2).avaaNappula();
  }
  /** Toistaiseksi hyödytön testausmielessä kasattu toString-metodi. Ignore!.
   * 
   * @return 
   */
  public String toString(){
      String sisalto = "";
      for (int i = 0; i < nappulat.size(); i++){
          sisalto = sisalto + nappulat.get(i);
      }
      return sisalto;
  }
}
