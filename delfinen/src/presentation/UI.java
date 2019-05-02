package presentation;

import java.text.DateFormat;
import java.time.LocalDate;


public interface UI {

    public LocalDate vælgFødt();
    
    public String vælgNavn();

    public int tlfNo();
    
    public int fjernMedlem();
    
    public void visHovedmenu();
    
    public String hovedmenuValg();
    
    public void notAnOption();

    public void visAdministrerMedlemmer();
}
