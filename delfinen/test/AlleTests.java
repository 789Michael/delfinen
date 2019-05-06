

import Businesslogic.Controller;
import Businesslogic.Medlem;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;
import storage.MockStorage;

public class AlleTests {
    
    MockStorage storage = new MockStorage();
    public AlleTests() {
        ArrayList<Medlem> medlemmer = new ArrayList();
    // FIX ME
   /*
        medlemmer.add(new Medlem(1, "Palle", null, "12345678"));
        medlemmer.add(new Medlem(2, "Peter", null, "12345678"));
        medlemmer.add(new Medlem(3, "Per", null, "12345678"));
        medlemmer.add(new Medlem(4, "Casper", null, "12345678"));
        medlemmer.add(new Medlem(5, "Allan", null, "12345678"));
        medlemmer.add(new Medlem(6, "Aske", null, "12345678"));
        medlemmer.add(new Medlem(7, "Malthe", null, "12345678"));
        medlemmer.add(new Medlem(8, "Christina", null, "12345678"));
        medlemmer.add(new Medlem(9, "Fie", null, "12345678"));*/
    }
    
    @Test
    public void testVisMedlemmer() {
        
        //assertTrue(storage.visMedlemmer().size()==9);
    }
    @Test
    public void testFjernMedlem(){
       // assertTrue(storage.visMedlemmer().size()==9);
        storage.fjernMedlem(9);
       // assertTrue(storage.visMedlemmer().size()==8);

    }
    @Test
    public void testOpretMedlem(){
        //assertTrue(storage.visMedlemmer().size()==9);
        //storage.opretMedlem(new Medlem(10,"Sara", null, "12332121"));
       // assertTrue(storage.visMedlemmer().size()==10);
    }
}
