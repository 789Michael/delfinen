package main;

import Businesslogic.Controller;
import Businesslogic.Medlem;
import java.time.LocalDate;
import java.util.ArrayList;
import storage.DatabaseConnection;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */
public class DelfinenMain {

    
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(1919, 9, 23);
        Medlem medlem = new Medlem(01, "Måge Lister", localDate, "12345678");
        
        DatabaseConnection database = new DatabaseConnection();
        //database.opretMedlem(medlem);
        
        //database.fjernMedlem(11);
        ArrayList<Medlem> testArray = new ArrayList();
        testArray = database.visMedlemmer();
        for (Medlem m : testArray) {
            System.out.println(m.toString());
        }
        
        
        
    }
    
}
