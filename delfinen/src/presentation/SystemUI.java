package presentation;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SystemUI implements UI {
    
    Scanner scan = new Scanner(System.in);

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
    public String tlfNo() {
        System.out.println("Indtast telefonnummer:");
        String input = scan.nextLine();
        while (input.length() == 0 && input.length() > 8) {
            System.out.println("Forkert input! Indtast telefonnummer på max 8 cifre:");
            input = scan.nextLine();
        }
        return input;  
    }
}
    
