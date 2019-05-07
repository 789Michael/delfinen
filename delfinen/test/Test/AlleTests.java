package Test;



import Businesslogic.Controller;
import Businesslogic.Medlem;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;
import storage.MockStorage;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

public class AlleTests {
    
    MockStorage storage = new MockStorage();
//    public AlleTests() {
//        ArrayList<Medlem> medlemmer = new ArrayList();
    
//    // Egentlig unødvændigt at lave et nyt array da der allerede er et array vi bruger i MockStorage
//   
//        medlemmer.add(new Medlem(1, "Palle", null, "12345678", true, null));
//        medlemmer.add(new Medlem(2, "Peter", null, "12345678", false, null));
//        medlemmer.add(new Medlem(3, "Per", null, "12345678", false, null));
//        medlemmer.add(new Medlem(4, "Casper", null, "12345678", true, null));
//        medlemmer.add(new Medlem(5, "Allan", null, "12345678", true, null));
//        medlemmer.add(new Medlem(6, "Aske", null, "12345678", true, null));
//        medlemmer.add(new Medlem(7, "Malthe", null, "12345678", false, null));
//        medlemmer.add(new Medlem(8, "Christina", null, "12345678", true, null));
//        medlemmer.add(new Medlem(9, "Fie", null, "12345678", true, null));
//    }
    
    @Test
    public void testVisMedlemmer() {
        
        assertTrue(storage.visMedlemmer().size()==11);
    }
    @Test
    public void testFjernMedlem(){
        assertTrue(storage.visMedlemmer().size()==11);
        storage.fjernMedlem(11);
        assertTrue(storage.visMedlemmer().size()==10);

    }
    @Test
    public void testOpretMedlem(){
        assertTrue(storage.visMedlemmer().size()==11);
        storage.opretMedlem(new Medlem(10,"Sara", null, "12332121", true, null));
        assertTrue(storage.visMedlemmer().size()==12);
    }
}
