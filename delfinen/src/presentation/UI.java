package presentation;

import java.text.DateFormat;
import java.time.LocalDate;


public interface UI {

    public LocalDate vælgFødt();
    
    public String vælgNavn();

    public int tlfNo();
    
    public int fjernMedlem();
    
    public void printHovedmenu();
    
    public String scanInputMenu();
    
    public void notAnOption();

    public void printAdministrerMedlemmer();
    
    public void printAdministrerKontigenter();
            
    public void printAdministrerTræningOgKonkurrencer();
}
