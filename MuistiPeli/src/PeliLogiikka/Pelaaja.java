package PeliLogiikka;

public class Pelaaja {
    private String Nimi;
    private int pisteet;

  /** Luokan konstruktori, vaatii nimen parametrina.
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
  
  /**Metodi kasvattaa pelaajan pisteitä yhdellä.*/
  public void kasvataPisteita(){ 
      this.pisteet = pisteet + 1;
  }

  /** Metodi palauttaa pelajaan pisteet.
   * 
   * @return 
   */
  public int getPisteet(){
      return this.pisteet;
  }
}
