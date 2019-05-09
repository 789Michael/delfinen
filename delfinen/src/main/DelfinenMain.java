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
        Controller ctrl = new Controller(new SystemUI(), new DatabaseConnection());
        ctrl.start();
        }
        
        
        
    }
