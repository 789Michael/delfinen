package presentation;

import java.text.DateFormat;
import java.time.LocalDate;


public interface UI {

    public LocalDate vælgFødt();
    
    public String vælgNavn();

    public String tlfNo();
    
    public void visHovedmenu();
    
    public String hovedmenuValg();
    
    public void notAnOption();
}
