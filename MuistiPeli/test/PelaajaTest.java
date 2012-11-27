import org.junit.*;
import static org.junit.Assert.*;
import PeliLogiikka.Pelaaja;

public class PelaajaTest {
    
    Pelaaja pelaaja;
    Pelaaja pelaaja2;
    
    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getNimiToimii(){
        pelaaja = new Pelaaja("Tahvo");
        assertEquals("Tahvo", pelaaja.getNimi());
        pelaaja = new Pelaaja("Pertsa");
        assertEquals("Pertsa", pelaaja.getNimi());
    }
    
    @Test
    public void pisteetAluksiNolla(){
        pelaaja = new Pelaaja("Mape");
        assertEquals(0, pelaaja.getPisteet());
    }
    
    @Test
    public void pisteidenLisaysToimii(){
        pelaaja = new Pelaaja("Jope");
        pelaaja.kasvataPisteita();
        assertEquals(1, pelaaja.getPisteet());
        pelaaja.kasvataPisteita();
        assertEquals(2, pelaaja.getPisteet());
    }
    
    @Test
    public void compareToToimii(){
        pelaaja = new Pelaaja("Jope");
        pelaaja2 = new Pelaaja("Kalle"); 
        pelaaja.kasvataPisteita();
        assertTrue(pelaaja.compareTo(pelaaja2)>0);
        while(pelaaja2.getPisteet()<1000){
            pelaaja2.kasvataPisteita();
        }
        assertTrue(pelaaja.compareTo(pelaaja2)<0);
//        while(pelaaja.getPisteet()<999){
//            pelaaja.kasvataPisteita();
//        }
//        assertTrue(pelaaja.compareTo(pelaaja2)==0);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
