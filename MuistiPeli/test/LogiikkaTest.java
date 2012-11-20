import org.junit.*;
import static org.junit.Assert.*;
import PeliLogiikka.*;

public class LogiikkaTest {
    Logiikka peli;
    
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
        peli = new Logiikka(new Kentta(16)); 
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void pelinAlustaminenToimii(){
        boolean toimii;
        peli.taytaKentta();
        String testattava = peli.toString();
        if (testattava.contains("tyhja")){
            toimii = false;
        } else {
            toimii = true;
        }
        assertTrue(toimii);
    }
    
    @Test
    public void nappulanAvaaminenJaSulkeminenToimii(){
        peli.taytaKentta();
        String testattava = peli.piirraKentta();
        assertSame(testattava, peli.piirraKentta());
//        peli.naytaNappula(3);
//        peli.naytaNappula(6);
//        assertNotSame(testattava, peli.piirraKentta());
//        peli.piilotaNappulat(3, 6);
//        assertSame(testattava, peli.piirraKentta());
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
