package Businesslogic;

import java.util.ArrayList;
import java.util.Scanner;
import presentation.UI;
import storage.StorageInterface;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

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
                    administrerTræningOgKonkurrencer();
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
        
        Medlem medlem = new Medlem(-1, ui.vælgNavn(), ui.vælgFødt(), "" + ui.tlfNo(), ui.aktivMedlem());
        
        storage.opretMedlem(medlem);
    }
    
    private void fjernMedlem() {
        ui.visMedlemmer(storage.visMedlemmer());
        storage.fjernMedlem(ui.fjernMedlem());
    }
    
    private void visMedlemmer() {
        ui.visMedlemmer(storage.visMedlemmer());
    }

    private void ændreMedlemsAktivitet(){
        ui.visMedlemmer(storage.visMedlemmer());
        storage.ændreMedlemsAktivitet(ui.ændreMedlemsAktivitet());
    }

    private void administrerKontingenter() {
        boolean quit = false;
        do{
            ui.printAdministrerKontigenter();
            String brugerinput = ui.scanInputMenu();
            switch(brugerinput) {
                case "1":
                    visRestancer();
                    break;
                case "2":
                    opdaterKontigent();
                    break;
                case "-1":
                    quit = true;
                    break;
            }
            
        } while(!quit);
    }

    private void visRestancer() {
        ui.visRestancer(storage.getRestancer());
    }
    
    private void opdaterKontigent(){
        ui.visMedlemmer(storage.visMedlemmer());
        int i = ui.opdaterKontigentsDato();
        ui.kontigentKvitering(udregnKontigent(i));
        storage.opdaterKontigentsDato(i);
    }
    
    private int udregnKontigent(int id){
        Medlem medlem = storage.getMedlemMedId(id);
        if(medlem.isAktivMedlem()){
            if(medlem.getAlder() < 18){
                return 1000;
            }else if(medlem.getAlder() <= 60){
                return 1600;
            }else{
                return 1200;
            }
        }else{
            return 500;
        }
    }

    private void administrerTræningOgKonkurrencer() {
        boolean quit = false;
        do{
            ui.printAdministrerKontigenter();
            String brugerinput = ui.scanInputMenu();
            switch(brugerinput) {
                case "1":
                    //indsætTræningstider();
                    break;
                case "2":
                    //indsætKonkurrencetider();
                    break;
                case "3":
                    visTop5();
                    break;
                case "-1":
                    quit = true;
                    break;
            }  
        } while(!quit);
  
        } 
     private void visTop5(){
         boolean quit = false;
            do{
            String brugerinput = ui.scanInputMenu();
            switch(brugerinput) {
                case "1":
                    storage.visTop5("BRYST", "BRYSTDATO");
                    break;
                case "2":
                    storage.visTop5("BFLY", "BFDATO");
                    break;
                case "3":
                    storage.visTop5("CRAWL",  "CRAWLDATO");
                    break;
                case "4":
                    storage.visTop5("RCRAWL", "RCRAWLDATO");
                    break;
                case "-1":
                    quit = true;
                    break;
            }  
        } while(!quit);
         
        } 
   
   
}

