package presentation;

import java.text.DateFormat;
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
    public String vælgFødt() {
        System.out.println("Indtast fødselsdato på nyt medlem:");
        String input = scan.nextLine();
        while (input.length() == 0) {
            System.out.println("Tomt input! Indtast fødselsdato på nyt medlem:");
            input = scan.nextLine();
        }
        return input;  
    }

    @Override
    public String tlfNo() {
        System.out.println("Indtast telefonnummer:");
        String input = scan.nextLine();
        while (input.length() == 0) {
            System.out.println("Tomt input! Indtast telefonnummer:");
            input = scan.nextLine();
        }
        return input;  
    }
    
}
