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
    
    public void opretMedlem() {
        
        Medlem medlem = new Medlem(storage.id(), ui.vælgNavn(), ui.vælgFødt(), ui.tlfNo());
        
        storage.opretMedlem(medlem);
    }

    // Please fix me! :-(
//    public localDate formaterFødt(String input){
//        
//        return localDate;
//    }
}
