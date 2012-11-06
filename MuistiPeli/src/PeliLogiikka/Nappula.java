package PeliLogiikka;

public class Nappula {
  private int tunniste;
  private boolean auki;
  
  /**Luokan konstruktori, vaatii kokonaislukun parametrina,
   *tunniste-muuttujan avulla suoritetaan parien etsintä,
   *boolean-arvolla ohjataan nappuloiden näkymistä
   *
   * @param tunniste
   */
  public Nappula(int tunniste){ 
      this.tunniste = tunniste; 
      this.auki = false;        
  }                     
  
  /** Metodi palauttaa nappulan tunnisteen.
   * 
   * @return 
   */
  public int kerroTunniste(){
      return this.tunniste;
  }
  
  /**Metodi muuttaa nappulan näkyväksi.
   * 
   */
  public void avaaNappula(){
      this.auki = true;
  }
  
  /**Metodi piilottaa nappulan näkyvistä.
   * 
   */
  public void piilotaNappula(){
      this.auki = false;
  }
  
  /**Metodi kertoo nappulan tilan.
   * 
   * @return 
   */
  public boolean aukiVaiKiinni(){
      return auki;
  }
}
