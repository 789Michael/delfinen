package storage;

import Businesslogic.Medlem;
import java.util.*;

/**
 *
 * @author wosch
 */
public class MockStorage implements StorageInterface {
    
    ArrayList<Medlem> medlemmer = new ArrayList();
    
    // FIX ME
    public MockStorage() {
        medlemmer.add(new Medlem(1, "Palle", null, "12345678"));
        medlemmer.add(new Medlem(2, "Peter", null, "12345678"));
        medlemmer.add(new Medlem(3, "Per", null, "12345678"));
        medlemmer.add(new Medlem(4, "Casper", null, "12345678"));
        medlemmer.add(new Medlem(5, "Allan", null, "12345678"));
        medlemmer.add(new Medlem(6, "Aske", null, "12345678"));
        medlemmer.add(new Medlem(7, "Malthe", null, "12345678"));
        medlemmer.add(new Medlem(8, "Christina", null, "12345678"));
        medlemmer.add(new Medlem(9, "Fie", null, "12345678"));
        
        
    }

    @Override
    public void opretMedlem(Medlem medlem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fjernMedlem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Medlem> visMedlemmer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Medlem> visRestancer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
