package storage;

import Businesslogic.Medlem;
import java.util.*;

/**
 *
 * @author wosch
 */
public class MockStorage implements StorageInterface {
    
    ArrayList<Medlem> medlemmer = new ArrayList();
    
    public MockStorage() {
        medlemmer.add(new Medlem(1, "Palle", "19", "12345678"));
        medlemmer.add(new Medlem(2, "Peter", "24", "12345678"));
        medlemmer.add(new Medlem(3, "Per", "26", "12345678"));
        medlemmer.add(new Medlem(4, "Casper", "21", "12345678"));
        medlemmer.add(new Medlem(5, "Allan", "22", "12345678"));
        medlemmer.add(new Medlem(6, "Aske", "19", "12345678"));
        medlemmer.add(new Medlem(7, "Malthe", "18", "12345678"));
        medlemmer.add(new Medlem(8, "Christina", "15", "12345678"));
        medlemmer.add(new Medlem(9, "Fie", "16", "12345678"));
        
        
    }

    @Override
    public void opretMedlem(Medlem medlem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
