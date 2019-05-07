package storage;

import Businesslogic.KonMedlem;
import Businesslogic.Medlem;
import Businesslogic.TræningMedlem;
import java.util.ArrayList;


public interface StorageInterface {
    
    public void opretMedlem(Medlem medlem);
    
    public void fjernMedlem(int id);
    
    public ArrayList<Medlem> visMedlemmer();
    
    
    public void ændreMedlemsAktivitet(int id);
    
    public ArrayList<Medlem> getRestancer();
    
    public void opdaterKontigentsDato(int id);
    
    public Medlem getMedlemMedId(int id);
    
    public ArrayList<TræningMedlem> visTop5();
    public void opdaterTræningsTider(TræningMedlem træningMedlem);
    
    
}
