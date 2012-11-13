import org.junit.*;
import static org.junit.Assert.*;
import PeliLogiikka.*;

public class LogiikkaTest {
    Logiikka peli = new Logiikka(2, new Pelaaja("Jope"));
    
    public LogiikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        Logiikka peli = new Logiikka(2, new Pelaaja("Jope")); 
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void pelinAlustaminenToimii(){
        String testattava = peli.toString();
        boolean toimii;
        peli.taytaKentta();
        if (testattava.contains("tyhja")){
            toimii = false;
        } else {
            toimii = true;
        }
        assertTrue(toimii = true);
    }
    
    /**En keksi sopivaa testimetodia parin etsintämetodille tällä hetkellä.
     * 
     */
    @Test
    public void etsiPariaToimii(){
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
