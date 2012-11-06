import org.junit.*;
import static org.junit.Assert.*;
import PeliLogiikka.*;

public class KenttaTest {
    
    Kentta kentta = new Kentta(30);
    
    public KenttaTest() {
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
    public void satunnaislukujenGenerointiToimii(){
        int eka = kentta.satunnainenPaikka();
        assertNotSame(eka, kentta.satunnainenPaikka());
    }
    
    @Test
    public void alustusToimii(){
        for (int i = 0; i < kentta.kentanKoko()-1;i++){
            assertEquals(0,kentta.palautaNappula(i).kerroTunniste());
        }
    }
    
    @Test
    public void nappulanLisaysToimii(){
        kentta.lisaaNappulaKentalle(new Nappula(1));
        kentta.lisaaNappulaKentalle(new Nappula(3));
        boolean ekaToimii = false;
        boolean tokaToimii = false;
        for (int i = 0; i < kentta.kentanKoko()-1; i++){
            if(kentta.palautaNappula(i).kerroTunniste() == 1){
                ekaToimii = true;
            }
            if(kentta.palautaNappula(i).kerroTunniste() == 3){
                tokaToimii = true;
            }
        }
        assertTrue(ekaToimii = true);
        assertTrue(tokaToimii = true);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // @Test
    // public void hello() {}
}
