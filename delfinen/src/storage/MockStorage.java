package storage;

import Businesslogic.Medlem;
import Businesslogic.TræningMedlem;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;

/**
 *
 * @author wosch
 */
public class MockStorage implements StorageInterface {
    
    ArrayList<Medlem> medlemmer = new ArrayList();
    
    // FIX ME
    public MockStorage() {
        medlemmer.add(new Medlem(1, "Palle", LocalDate.of(2005, 3, 12), "12345678", true, LocalDate.of(2019, 3, 12)));
        medlemmer.add(new Medlem(2, "Peter", LocalDate.of(2001, 3, 12), "12345678", true, LocalDate.of(2019, 1, 1)));
        medlemmer.add(new Medlem(3, "Per", LocalDate.of(1998, 3, 12), "12345678", true, LocalDate.of(2019, 4, 12)));
        medlemmer.add(new Medlem(4, "Casper", LocalDate.of(1970, 3, 12), "12345678", true, LocalDate.of(2018, 2, 12)));
        medlemmer.add(new Medlem(5, "Allan", LocalDate.of(1950, 3, 12), "12345678", true, LocalDate.of(2018, 1, 12)));
        medlemmer.add(new Medlem(6, "Aske", LocalDate.of(1998, 3, 12), "12345678", true, LocalDate.of(2018, 12, 12)));
        medlemmer.add(new Medlem(7, "Malthe", LocalDate.of(2005, 3, 12), "12345678", false, LocalDate.of(2018, 4, 14)));
        medlemmer.add(new Medlem(8, "Christina", LocalDate.of(1919, 3, 12), "12345678", false, LocalDate.of(2018, 2, 4)));
        medlemmer.add(new Medlem(9, "Fie", LocalDate.of(1970, 3, 12), "12345678", false, LocalDate.of(2019, 3, 12)));
        medlemmer.add(new Medlem(10, "MORTY", LocalDate.of(2005, 3, 12), "12345678", true, LocalDate.of(2018, 4, 14)));
        medlemmer.add(new Medlem(11, "RICK", LocalDate.of(1970, 3, 12), "12345678", false, LocalDate.of(2018, 4, 14)));


    }

    @Override
    public void opretMedlem(Medlem medlem) {
        medlemmer.add(medlem);
        
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
    public void ændreMedlemsAktivitet(int id){
        for (int i=0; i< medlemmer.size(); i++){
            if(medlemmer.get(i).getId() == id){
                medlemmer.get(i).setAktivMedlem(!medlemmer.get(i).isAktivMedlem());
        }
       }
    }


    @Override
    public ArrayList<Medlem> getRestancer() {
        ArrayList<Medlem> returnArray = new ArrayList<Medlem>();
        for(Medlem m : medlemmer){
            if(calculateDifference(m.getKontigentsDato(),LocalDate.now()) >= 1){
                returnArray.add(m);
            }
        }
        return returnArray;
    }

    @Override
    public ArrayList<TræningMedlem> visTop5() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private int calculateDifference(LocalDate kontigentsDato, LocalDate currentDate) {
        if ((kontigentsDato != null) && (currentDate != null)) {
            return Period.between(kontigentsDato, currentDate).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public void opdaterKontigentsDato(int id) {
        for(Medlem m : medlemmer){
            if(id == m.getId()){
                m.setKontigentsDato(m.getKontigentsDato().plusYears(1));
            }
        }
    }

    @Override
    public Medlem getMedlemMedId(int id) {
        for(Medlem m : medlemmer){
            if(id == m.getId()){
                return m;
            }
        }
        return null;
    }
}
