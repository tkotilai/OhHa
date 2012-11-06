import org.junit.*;
import static org.junit.Assert.*;
import PeliLogiikka.Nappula;
public class NappulaTest {
    
    Nappula nappula;
    
    public NappulaTest() {
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
    public void nappulanTunnistusToimii(){
        nappula = new Nappula(1);
        assertEquals(1, nappula.kerroTunniste());
        nappula = new Nappula(2);
        assertEquals(2, nappula.kerroTunniste());
    }
    
    @Test
    public void nappulanTilanMuuttaminenToimii(){
        nappula = new Nappula(1);
        assertEquals(false, nappula.aukiVaiKiinni());
        nappula.avaaNappula();
        assertEquals(true, nappula.aukiVaiKiinni());
        nappula.piilotaNappula();
        assertEquals(false, nappula.aukiVaiKiinni());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
