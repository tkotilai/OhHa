package PeliLogiikka;

public class Logiikka {
  private Kentta kentta;
  private Pelaaja pelaaja; 
  
  /**Luokan konstruktori, luo pelikentan vaikeusasteen mukaan (jonka ottaa parametrinä,
   * liittaa pelaajat peliin, koodi kesken, korjataan myöhemmin oikeaa peliä vastaavaksi
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
   * 
   * @param ensimmainen
   * @param toinen
   * @return 
   */
  public boolean etsiParia(int ensimmainen, int toinen){
      if (kentta.onPari(ensimmainen, toinen)== true){
          kentta.naytaPari(ensimmainen, toinen);
          pelaaja.kasvataPisteita();
          return true;
      } else {
          return false;
      }
  }
  
  /**Metodi alustaa pelikentän vaikeusasteen perusteella, lisäämällä sinne eri tyyppisiä
   * nappuloita pareittain. Ei toimi kunnolla, pitää korjata.
   */
  public void taytaKentta(){
      for(int i = 0; i <= kentta.kentanKoko(); i = i+2){
          int tunniste = 1;
          kentta.lisaaNappulaKentalle(new Nappula(tunniste));
          kentta.lisaaNappulaKentalle(new Nappula(tunniste));
          tunniste ++;
      }    
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
