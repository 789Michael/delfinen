package storage;

import Businesslogic.Medlem;
import java.time.LocalDate;
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
        medlemmer.add(new Medlem(10, "Sara", null, "12345678"));
        
    }

    @Override
    public void fjernMedlem(int id) {
       for (int i=0; i< medlemmer.size(); i++){
            if(medlemmer.get(i).getId() == id){
                medlemmer.remove(i);
    }
       }
    }
    @Override
    public ArrayList<Medlem> visMedlemmer() {
        return medlemmer;
    }

    @Override
    public ArrayList<Medlem> visRestancer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Medlem> visTop5() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
