package storage;

import Businesslogic.KonMedlem;
import Businesslogic.Medlem;
import Businesslogic.TræningMedlem;
import java.util.ArrayList;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

public interface StorageInterface {
    
    public void opretMedlem(Medlem medlem);
    
    public void fjernMedlem(int id);
    
    public ArrayList<Medlem> visMedlemmer();
    
    public void ændreMedlemsAktivitet(int id);
    
    public ArrayList<Medlem> getRestancer();
    
    public void opdaterKontigentsDato(int id);
    
    public Medlem getMedlemMedId(int id);
    
    public void opdaterKonkurrenceTider(KonMedlem konmedlem);
    
    public void opdaterTræningsTider(TræningMedlem m);

    public int højesteMedlemsId();
    
    public ArrayList<Integer> getIDs();
    
    public ArrayList<TræningMedlem> visTop5(String a, String dato);
    
    public ArrayList<KonMedlem> visStævne(String k); 

    public ArrayList<String> stævner();

    public Medlem getTræningMedlemMedId(int id);

}
