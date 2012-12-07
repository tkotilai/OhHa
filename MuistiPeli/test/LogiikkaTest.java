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
        peli = new Logiikka("vaikea", new Pelaaja ("tahvo")); 
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
        for (int i = 0; i <peli.pelikentanKoko(); i++){
            assertFalse(peli.onkoAuki(i));
        }
        peli.naytaNappula(3);
        peli.naytaNappula(6);
        assertTrue(peli.onkoAuki(3));
        assertTrue(peli.onkoAuki(6));
        peli.piilotaNappulat(3, 6);
        for (int i = 0; i <peli.pelikentanKoko(); i++){
            assertFalse(peli.onkoAuki(i));
        }
    }
    

    @Test
    public void etsiPariaToimii(){
        peli.taytaKentta();
        for(int i = 0; i < peli.pelikentanKoko(); i++){
            for(int j = 0; j < peli.pelikentanKoko(); j++){
                if(i !=j){
                    if (peli.nappulanTunniste(i).equalsIgnoreCase(peli.nappulanTunniste(j))){ 
                        assertTrue(peli.etsiParia(i, j));
                    } else {
                        assertFalse(peli.etsiParia(i, j));
                    }
                }
            }
        }
    }
    
    @Test
    public void onkoPeliLoppuToimii(){
        peli.taytaKentta();
        assertFalse(peli.onkoPeliLoppu());
        peli.asetaLoydetyiksi(0, 1);
        assertFalse(peli.onkoPeliLoppu());
        for(int i = 0; i < peli.pelikentanKoko()-1; i++){
            peli.asetaLoydetyiksi(i, i+1);
        }
        assertTrue(peli.onkoPeliLoppu());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
