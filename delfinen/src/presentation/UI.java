package presentation;

import Businesslogic.Medlem;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

public interface UI {

    public LocalDate vælgFødt();
    
    public String vælgNavn();

    public int tlfNo();
    
    public int fjernMedlem();
    
    public void visMedlemmer(ArrayList<Medlem> medlemmer);
    
    public void printHovedmenu();
    
    public String scanInputMenu();
    
    public void notAnOption();

    public void printAdministrerMedlemmer();
    
    public void printAdministrerKontigenter();
            
    public void printAdministrerTræningOgKonkurrencer();
   
    public boolean aktivMedlem();
    
    public int ændreMedlemsAktivitet();
    
    public void visRestancer(ArrayList<Medlem> medlemmer);
    
    public int opdaterKontigentsDato();
    
    public void kontigentKvitering(int pris);

}
