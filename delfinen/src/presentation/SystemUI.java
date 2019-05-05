package presentation;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SystemUI implements UI {
    
    Scanner scan = new Scanner(System.in);

    @Override
    public void printHovedmenu() {
        System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1. Administrer medlemmer");
        System.out.println("2. Administrer kontingenter");
        System.out.println("3. Vis restancer");
        System.out.println("4. Indsæt resultater");
        System.out.println("5. Vis resultater");
        System.out.println("9. Afslut");

    }
    
    @Override
    public void printAdministrerMedlemmer() {
        System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1. Opret medlem");
        System.out.println("2. Fjern medlem");
        System.out.println("3. Vis medlemmer");
        System.out.println("-1. Gå tilbage");
    }
    
    @Override
    public void printAdministrerKontigenter() {
        System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1. Opret medlem");
        System.out.println("2. Fjern medlem");
        System.out.println("3. Vis medlemmer");
        System.out.println("-1. Gå tilbage");
    }
    
    @Override
    public void printAdministrerTræningOgKonkurrencer() {
        System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1. Opret medlem");
        System.out.println("2. Fjern medlem");
        System.out.println("3. Vis medlemmer");
        System.out.println("-1. Gå tilbage");
    }


    @Override
    public String scanInputMenu() {
        return scan.nextLine();
    }

    
    @Override
    public String vælgNavn() {
        System.out.println("Indtast navn på nyt medlem:");
        String input = scan.nextLine();
        while (input.length() == 0) {
            System.out.println("Tomt input! Indtast navn på nyt medlem:");
            input = scan.nextLine();
        }
        return input;  
    }
    

    @Override
    public LocalDate vælgFødt() {
        System.out.println("Indtast fødselsår med format [ÅÅÅÅ]:");
        int årInput = scan.nextInt();
        System.out.println("Indtast fødselsmåned med format [MM]:");
        int mInput = scan.nextInt();
        System.out.println("Indtast fødselsdato med format [DD]:");
        int dInput = scan.nextInt();
        LocalDate localDate = LocalDate.of(årInput, mInput, dInput);
         return localDate;
    }

    @Override
    public int tlfNo() {
        System.out.println("Indtast telefonnummer:");
        int input = scan.nextInt();
        scan.nextLine();
        return input;  
    }
    
    @Override
    public void notAnOption() {
        System.out.println("Ugyldigt input");
        System.out.println("-------------------------------------");
    }
    

    @Override
    public int fjernMedlem() {
        System.out.println("Skriv ID på medlem du vil fjerne");
        int i = scan.nextInt();
        scan.nextLine();
        return i;
    }
}
    
