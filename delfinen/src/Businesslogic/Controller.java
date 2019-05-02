package Businesslogic;

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
            ui.visHovedmenu();
            String brugerinput = ui.hovedmenuValg();
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
                case "4":
                    indsætResultater();
                        break;
                                        
                    
                case "5":
                    visAlleResultater();
                    break;
                case "9":
                    skrivHistorik();
                    quit = true;
                    break;
                default:
                    ui.notAnOption();
                
            }
            
        } while(!quit);
    }
    
    public void opretMedlem() {
        
        Medlem medlem = new Medlem(storage.id(), ui.vælgNavn(), ui.vælgFødt(), ui.tlfNo());
        
        storage.opretMedlem(medlem);
    }

    // Please fix me! :-(
//    public localDate formaterFødt(String input){
//        
//        return localDate;
//    }

    private void administrerMedlemmer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void administrerKontingenter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void visRestancer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void indsætResultater() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void visAlleResultater() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void skrivHistorik() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

