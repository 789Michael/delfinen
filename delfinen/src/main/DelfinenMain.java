package main;

import Businesslogic.Controller;
import Businesslogic.Medlem;
import java.time.LocalDate;
import java.util.ArrayList;
import presentation.SystemUI;
import storage.DatabaseConnection;
import storage.MockStorage;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

public class DelfinenMain {

    
    public static void main(String[] args) {
        int i = 2;
        while(true){
            i = i*2;
            System.out.println(i);
        }
        /*LocalDate localDate = LocalDate.of(1919, 9, 23);
        Medlem medlem = new Medlem(01, "Måge Lister", localDate, "12345678");
        
        DatabaseConnection database = new DatabaseConnection();
        //database.opretMedlem(medlem);3
        
        //database.fjernMedlem(11);
        ArrayList<Medlem> testArray = new ArrayList();
        testArray = database.visMedlemmer();
        for (Medlem m : testArray) {
            System.out.println(m.toString());*/

        //Controller ctrl = new Controller(new SystemUI(), new DatabaseConnection());
        //ctrl.start();
        }
        
        
        
    }
