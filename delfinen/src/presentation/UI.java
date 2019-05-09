package presentation;

import Businesslogic.KonMedlem;
import Businesslogic.Medlem;
import Businesslogic.TræningMedlem;
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
    
    public int fjernMedlem(ArrayList<Integer> ids);
    
    public void visMedlemmer(ArrayList<Medlem> medlemmer, boolean bypassRS);
    
    public void printHovedmenu();
    
    public String scanInputMenu();
    
    public void notAnOption();

    public void printAdministrerMedlemmer();
    
    public void printAdministrerKontigenter();
            
    public void printAdministrerTræningOgKonkurrencer();
   
    public boolean aktivMedlem();
    
    public int ændreMedlemsAktivitet(ArrayList<Integer> ids);
    
    public void visRestancer(ArrayList<Medlem> medlemmer);
    
    public int opdaterKontigentsDato(ArrayList<Integer> ids);
    
    public int kontigentKvitering(int pris, Medlem m);
    
    public void printString(String s);
    
    public void flushConsole();
    
    public void visTop5Disciplin(ArrayList<TræningMedlem> tm, int i);

    public void visTop5Disciplin();
    
    public void visStævneResultater();

    public void printStævneResultater(ArrayList<KonMedlem> kon);
    
    public String printStævne(ArrayList<String> s);
}
