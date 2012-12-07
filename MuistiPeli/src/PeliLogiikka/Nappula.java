package PeliLogiikka;


/**Nappula-luokka sisältää pelinappuloiden kannalta olennaiset tiedot ja metodit, kuten 
 * tunnisteet ja metodit nappulan tilan muuttamiseen.
 * 
 * @author Tommi
 */
public class Nappula {
  private int tunniste;
  private boolean auki;
  private boolean loydetty;
  
  /**Luokan konstruktori, vaatii kokonaislukun parametrina,
   *tunniste-muuttujan avulla suoritetaan parien etsintä,
   *boolean-arvolla ohjataan nappuloiden näkymistä
   *
   * @param tunniste
   */
  public Nappula(int tunniste){ 
      this.tunniste = tunniste; 
      this.auki = false;        
      this.loydetty = false;
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
  
  /**Metodin kutsuminen määrittää nappulan löytyneeksi.
   * 
   */
  public void loydetty(){
      this.loydetty = true;
  }
  
  /**Metodi kertoo onko nappula jo löydetty. Palauttaa arvon true, mikäli
   * on ja false mikäli ei.
   * 
   * @return 
   */
  public boolean onkoLoydetty(){
      return loydetty;
  }
  
  /**Metodi palauttaa nappulan tunnistearvon String-muotoisena.
   * 
   * @return 
   */
    @Override
  public String toString(){
      return "" + this.tunniste;
  }
}
