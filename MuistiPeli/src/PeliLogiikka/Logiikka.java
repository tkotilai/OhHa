package PeliLogiikka;

public class Logiikka {
  private Kentta kentta;
  private Pelaaja pelaaja; 
  
  /**Luokan konstruktori, luo pelikentan vaikeusasteen mukaan (jonka ottaa parametrinä,
   * liittaa pelaajat peliin, koodi kesken, korjataan myöhemmin oikeaa peliä vastaavaksi.
   * Luokkaan tai käyttöliittymän luokkaan pitää lisätä menetelmät syötteiden oikean muodon
   * tarkistamiseksi.
   * 
   * @param vaikeustaso
   * @param pelaaja 
   */
  public Logiikka (int vaikeustaso, Pelaaja pelaaja){
      this.pelaaja = pelaaja; 
      if (vaikeustaso == 1){
          this.kentta = new Kentta (4);
      } else {
          this.kentta = new Kentta (20);
      }
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
          kentta.naytaPari(ensimmainen, toinen);
          pelaaja.kasvataPisteita();
          System.out.println("Löysit parin");
          return true;
      } else {
          System.out.println("Ei pari.");
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
  
  /**Metodi pelikentän tulostamiseen tekstikäyttöliittymää varten. Voidaan kutsua sovelluslogiikan puolelta.
   * Palauttaa merkkiesityksen pelikentästä kutsumalla kentän metodia. Ei toimi toistaiseksi kunnolla.
   * 
   * @return 
   */
  public String piirraKentta(){
      return kentta.piirraKentta();
  }
  
  /**Metodi pelaajan pisteiden selvittämiseksi. Palauttaa ne int-tyyppisenä muuttujana.
   * 
   * @return 
   */
  public int kerroPisteet(){
      return pelaaja.getPisteet();
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
