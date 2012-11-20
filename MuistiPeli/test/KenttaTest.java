import org.junit.*;
import static org.junit.Assert.*;
import PeliLogiikka.*;

public class KenttaTest {
    
    Kentta kentta;
    
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
        kentta = new Kentta(20);
    }
    
    @After
    public void tearDown() {
    }
    
//    @Test
//    public void nappulanPalautusToimii(){
//        Nappula nappula1 = new Nappula(4);
//        Nappula nappula2 = new Nappula(8);
//    }
    /**Testi ei välttämättä mene läpi joka kerta, koska arvottu luku on joskus sama 
     * useamman kerran peräkkäin.
     * 
     */
    @Test
    public void satunnaislukujenGenerointiToimii(){
        int eka = kentta.satunnainenPaikka();
        int toka = kentta.satunnainenPaikka();
        assertNotSame(eka, kentta.satunnainenPaikka());
        assertNotSame(toka, kentta.satunnainenPaikka());
    }
    
    @Test
    public void nappulanLisaysToimii(){
        kentta.lisaaNappulaKentalle(new Nappula(1));
        kentta.lisaaNappulaKentalle(new Nappula(3));
        boolean ekaToimii = false;
        boolean tokaToimii = false;
        for (int i = 0; i < kentta.kentanKoko(); i++){
            try{
                if(kentta.palautaNappula(i).kerroTunniste() == 1){
                    ekaToimii = true;
                }
                if(kentta.palautaNappula(i).kerroTunniste() == 3){
                    tokaToimii = true;
                }
            } catch (Exception e){
                
            }    
        }
        assertTrue(ekaToimii = true);
        assertTrue(tokaToimii = true);
        
    }
    
    @Test
    public void nappuloidenAvaaminenToimii(){
        boolean toimii = false;
        Kentta testi = new Kentta(2);
        testi.lisaaNappulaKentalle(new Nappula(1));
        testi.lisaaNappulaKentalle(new Nappula(1));
        testi.naytaPari(0,1);

        assertTrue(testi.palautaNappula(0).aukiVaiKiinni()==true);
        assertTrue(testi.palautaNappula(1).aukiVaiKiinni()==true);
    }
    
    @Test
    public void onPariToimii(){
        Kentta testi = new Kentta(2);
        testi.lisaaNappulaKentalle(new Nappula(1));
        testi.lisaaNappulaKentalle(new Nappula(2));
        assertFalse(testi.onPari(0, 1));
        
        Kentta testi2 = new Kentta(2);
        testi2.lisaaNappulaKentalle(new Nappula(1));
        testi2.lisaaNappulaKentalle(new Nappula(1));
        assertTrue(testi2.onPari(0, 1));
    }
    
    @Test
    public void nappuloidenAvaaminenJaPiilottaminenToimii(){
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // @Test
    // public void hello() {}
}
