package storage;

import Businesslogic.Medlem;
import java.util.ArrayList;


public interface StorageInterface {
    
    public void opretMedlem(Medlem medlem);

    public int id();
    
    public void fjernMedlem(int id);
    
    public ArrayList<Medlem> visMedlemmer();
    
    public ArrayList<Medlem> visRestancer();
    
}
