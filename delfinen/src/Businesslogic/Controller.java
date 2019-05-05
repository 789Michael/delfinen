package Businesslogic;

import java.util.ArrayList;
import presentation.UI;
import storage.StorageInterface;


public class Controller {
    
    private StorageInterface storage;
    private UI ui;
    
    public Controller(UI ui, StorageInterface storage) {
        this.storage=storage;
        this.ui=ui;
    }
    public void start() {
        boolean quit = false;
        do{
            ui.printHovedmenu();
            String brugerinput = ui.scanInputMenu();
            switch(brugerinput) {
                case "1":
                    administrerMedlemmer();
                    break;
                case "2":
                    administrerKontingenter();
                    break;
                case "3":
                    visRestancer();
                    break;
                case "9":
                    quit = true;
                    break;
                default:
                    ui.notAnOption();
                
            }
            
        } while(!quit);
    }
    
    private void administrerMedlemmer() {
        boolean quit = false;
        do{
            ui.printAdministrerMedlemmer();
            String brugerinput = ui.scanInputMenu();
            switch(brugerinput) {
                case "1":
                    opretMedlem();
                    break;
                case "2":
                    fjernMedlem();
                    break;
                case "3":
                    visMedlemmer();
                    break;
                case "4":
                    ændreMedlemsAktivitet();
                    break;
                case "-1":
                    quit = true;
                    break;
            }
            
        } while(!quit);
    }
        
    public void opretMedlem() {
        
        Medlem medlem = new Medlem(-1, ui.vælgNavn(), ui.vælgFødt(), "" + ui.tlfNo());
        
        storage.opretMedlem(medlem);
    }
    
    private void fjernMedlem() {
        storage.fjernMedlem(ui.fjernMedlem());
    }
    
    private void visMedlemmer() {

    }

    private void ændreMedlemsAktivitet(){
        
    }

    private void administrerKontingenter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void visRestancer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void opdaterKontigent(){
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void administrerTræningOgKonkurrencer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}

