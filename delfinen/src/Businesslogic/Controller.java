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
                    ui.flushConsole();
                    administrerMedlemmer();
                    break;
                case "2":
                    ui.flushConsole();
                    administrerKontingenter();
                    break;
                case "3":
                    administrerTræningOgKonkurrencer();
                    break;
                case "9":
                    quit = true;
                    break;
                default:
                    ui.flushConsole();
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
                    ui.flushConsole();
                    quit = true;
                    break;
            }
            
        } while(!quit);
    }
        
    public void opretMedlem() {
        
        Medlem medlem = new Medlem(-1, ui.vælgNavn(), ui.vælgFødt(), "" + ui.tlfNo(), ui.aktivMedlem());
        
        storage.opretMedlem(medlem);
        
        ui.flushConsole();
        
        ui.printString("Medlem oprettet: " + storage.getMedlemMedId(storage.højesteMedlemsId()).toString());
    }
    
    private void fjernMedlem() {
        ui.visMedlemmer(storage.visMedlemmer(),true);
        int i = ui.fjernMedlem(storage.getIDs());
        ui.flushConsole();
        if(i != -1){
        Medlem medlem = storage.getMedlemMedId(i);
        storage.fjernMedlem(medlem.getId());
        ui.printString("Medlem Fjernet: " + medlem.toString());
        }
    }
    
    private void visMedlemmer() {
        ui.visMedlemmer(storage.visMedlemmer(), false);
        ui.flushConsole();
    }

    private void ændreMedlemsAktivitet(){
        ui.visMedlemmer(storage.visMedlemmer(),true);
        int id = ui.ændreMedlemsAktivitet(storage.getIDs());
        ui.flushConsole();
        if(id != -1){
            storage.ændreMedlemsAktivitet(id);
            ui.printString("Medlems Aktivitet ændret for: " + storage.getMedlemMedId(id).toString());
        }
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
                    ui.flushConsole();
                    quit = true;
                    break;
            }
            
        } while(!quit);
    }

    private void visRestancer() {
        ui.visRestancer(storage.getRestancer());
    }
    
    private void opdaterKontigent(){
        ui.visMedlemmer(storage.visMedlemmer(),true);
        int i = ui.opdaterKontigentsDato(storage.getIDs());
        ui.flushConsole();
        if(i != -1){
            Medlem m = storage.getMedlemMedId(i);
            if(ui.kontigentKvitering(udregnKontigent(m), m) == 1){
                storage.opdaterKontigentsDato(m.getId());
                ui.printString("Medlems Kontigent ændret for: " + storage.getMedlemMedId(m.getId()).toString());
            }
            
        }
    }
    
    private int udregnKontigent(Medlem medlem){
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
            ui.printAdministrerTræningOgKonkurrencer();
            String brugerinput = ui.scanInputMenu();
            switch(brugerinput) {
                case "1":
                    opdaterTræningsTider();
                    break;
                case "2":
                    opdaterKonkurrenceTider();
                    break;
                case "3":
                    visTop5();
                    break;
                case "4":
                    stævneResultat();
                    break;
                case "9":
                    quit = true;
                    break;
                case "-1":
                    quit = true;
                    break;
                default:
                    ui.notAnOption();
    }
            
        }
        while (!quit);
        
  
        } 
     private void visTop5(){
         ui.flushConsole();
         ui.visTop5Disciplin();
         boolean quit = false;
            do{
            String brugerinput2 = ui.scanInputMenu();
            switch(brugerinput2) {
                case "1":
                    ui.visTop5Disciplin(storage.visTop5("BRYST", "BRYSTDATO"), 1);
                    break;
                case "2":
                     ui.visTop5Disciplin(storage.visTop5("BFLY", "BFDATO"), 2);
                    break;
                case "3":
                     ui.visTop5Disciplin(storage.visTop5("CRAWL",  "CRAWLDATO"), 3);
                    break;
                case "4":
                     ui.visTop5Disciplin(storage.visTop5("RCRAWL", "RCRAWLDATO"), 4);
                    break;
                case "-1":
                    quit = true;
                    break;
            
            }  
        } while(!quit);
         
        } 

   
        

    private void opdaterTræningsTider() {
            ui.visMedlemmer(storage.visMedlemmer(),true);
        int id = ui.hvilketMedlemÆndre(storage.getIDs());
        Medlem medlem = storage.getMedlemMedId(id);
        ui.flushConsole();
        if(id != -1){
            TræningMedlem træningmedlem = new TræningMedlem((id), medlem.getNavn(), medlem.getFødselsdag(), medlem.getTlfNo(), ui.vælgBrystTid(), ui.vælgTræningDato(), ui.vælgBFtid(), ui.vælgCrawlTid(), ui.vælgRCTid());
            storage.opdaterTræningsTider(træningmedlem);
            ui.printString("Træningstider opdateret for medlem: " + storage.getTræningMedlemMedId(id).toString());
    }
    }
        
    private void opdaterKonkurrenceTider() {
        
    }

    private void stævneResultat() {

        String i = ui.printStævne(storage.stævner());
        if (i != null){
            ui.printStævneResultater(storage.visStævne(i));
        } 
    }
}


