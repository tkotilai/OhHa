import org.junit.*;
import static org.junit.Assert.*;
import java.util.Scanner;
import PeliLogiikka.*;
import Kayttoliittyma.*;
import java.io.*;

public class TekstikayttoliittymaTest {
    Tekstikayttoliittyma kayttis;
    File testitiedosto;
//    Pelaaja pelaaja;
//    Logiikka peli;
    
    public TekstikayttoliittymaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        kayttis = new Tekstikayttoliittyma(new Scanner(System.in), new Logiikka(new Kentta(16)), new Pelaaja("Kalle"));
        testitiedosto = new File("testitiedosto.txt");
        try{
            testitiedosto.createNewFile();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
        testitiedosto.delete();
    }
    
    /**Testi ei toimi oikein koodin rakenteen vuoksi, pitänee muokata testiä tai koodia 
     * (vaikka itse koodi toimiikin).
     */
    @Test
    public void syoteHyvaksyttavaToimii(){    
        assertFalse(kayttis.syoteHyvaksyttava(-1));
        assertFalse(kayttis.syoteHyvaksyttava(-634));
        assertFalse(kayttis.syoteHyvaksyttava(30));
        assertFalse(kayttis.syoteHyvaksyttava(456));    
    }
    
    @Test
    public void onkoPeliLoppuToimii(){
        Kentta kentta = new Kentta(2);
        kentta.lisaaNappulaKentalle(new Nappula(1));
        kentta.lisaaNappulaKentalle(new Nappula(1));
        Tekstikayttoliittyma testi = new Tekstikayttoliittyma(new Scanner(System.in), new Logiikka(kentta), new Pelaaja("Kalle"));
        assertFalse(testi.onkoPeliLoppu());
        kentta.naytaPari(0, 1);
        assertTrue(testi.onkoPeliLoppu());     
    }
    
    @Test
    public void tiedostonKirjoittajaToimii(){
        
    }
    
    @Test
    public void tiedostonLukijaToimii(){
//        String koe1 = "jopo";        
        assertEquals("lukijan\ntestausta\nauto\nporo", kayttis.tiedostonLukija(new File("lukijatest.txt")));
//        kayttis.tiedostonKirjoittaja(koe1, testitiedosto);
//        assertEquals("jopo", kayttis.tiedostonLukija(testitiedosto));
//        koe1 = "mopo";
//        kayttis.tiedostonKirjoittaja(koe1, testitiedosto);
//        assertEquals("jopo\nmopo", kayttis.tiedostonLukija(testitiedosto));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
