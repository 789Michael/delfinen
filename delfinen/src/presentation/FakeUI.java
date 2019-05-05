package presentation;

import java.time.LocalDate;


public class FakeUI implements UI {

    @Override
    public String vælgNavn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDate vælgFødt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tlfNo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printHovedmenu() {
    System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1: Administrer medlemmer");
        System.out.println("2. Administrer kontingenter");
        System.out.println("3. Vis restancer");
        System.out.println("4. Indsæt resultater");
        System.out.println("5. Vis resultater");
    }

    @Override
    public String scanInputMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notAnOption() {
        System.out.println("Ugyldigt Input");
        System.out.println("-----------------------------------");
    }

    @Override
    public void printAdministrerMedlemmer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int fjernMedlem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
