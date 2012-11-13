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
    
    /**Testimetodi nappuloiden lisäykselle. Syystä tai toisesta ei mene enää läpi sen jälkeen,
     * kun korjasin nappulan lisäysmenetelmän toimivaksi. Testi valittaa NullPointerExceptionista 
     * rivillä 45.
     * 
     */
    @Test
    public void nappulanLisaysToimii(){
        kentta.lisaaNappulaKentalle(new Nappula(1));
        kentta.lisaaNappulaKentalle(new Nappula(3));
        boolean ekaToimii = false;
        boolean tokaToimii = false;
        for (int i = 0; i < kentta.kentanKoko(); i++){
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
    
    @Test
    public void nappuloidenAvaaminenToimii(){
        boolean toimii;
        Kentta testi = new Kentta(2);
        testi.lisaaNappulaKentalle(new Nappula(1));
        testi.lisaaNappulaKentalle(new Nappula(1));
        testi.naytaPari(0,1);
        if (testi.palautaNappula(0).aukiVaiKiinni()==true && testi.palautaNappula(1).aukiVaiKiinni()==true){
            toimii = true;
        }
        assertTrue(toimii = true);
    }
    
    @Test
    public void onPariToimii(){
        Kentta testi = new Kentta(2);
        testi.lisaaNappulaKentalle(new Nappula(1));
        testi.lisaaNappulaKentalle(new Nappula(2));
        assertEquals(false, testi.onPari(0, 1));
        
        Kentta testi2 = new Kentta(2);
        testi2.lisaaNappulaKentalle(new Nappula(1));
        testi2.lisaaNappulaKentalle(new Nappula(1));
        assertEquals(true, testi2.onPari(0, 1));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // @Test
    // public void hello() {}
}
