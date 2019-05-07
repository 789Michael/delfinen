package presentation;

import Businesslogic.Medlem;
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
        System.out.println("3. Administrer Træning Og Konkurrencer");
        System.out.println("9. Afslut");

    }
    
    @Override
    public void printAdministrerMedlemmer() {
        System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1. Opret medlem");
        System.out.println("2. Fjern medlem");
        System.out.println("3. Vis medlemmer");
        System.out.println("4. Ændre medlems aktivitet");
        System.out.println("-1. Gå tilbage");
    }
    
    @Override
    public void printAdministrerKontigenter() {
        System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1. Vis Restancer");
        System.out.println("2. Opdater medlems restance");
        System.out.println("-1. Gå tilbage");
    }
    
    @Override
    public void printAdministrerTræningOgKonkurrencer() {
        System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1. Opdater trænings tider");
        System.out.println("2. Indsæt Konkurrence tider");
        System.out.println("3. Vis 5 Svømmere");
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

    @Override
    public void visMedlemmer(ArrayList<Medlem> medlemmer) {
        for(Medlem m : medlemmer){
            System.out.println(m.toString());
        }
        System.out.println("____________________________");
        System.out.println("Skriv -1 for at returnere til menuen");
        boolean inputFormat = false;
            while(!inputFormat){
                String input = scan.nextLine();
                if(input.equals("-1")) {
                    inputFormat = true;
                }
                else{
                    System.out.println("Ugyldigt input, prøv igen:");
                }
                
            } 
        System.out.println("-----------------------------------------------");        
    }
    
    public boolean aktivMedlem(){
        System.out.println("Tast 1 for aktivt medlem, 2 for passivMedlem");
        int input = scan.nextInt();
        scan.nextLine();
        if(input == 1){
            return true;
        }else if(input == 2){
            return false;
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int ændreMedlemsAktivitet() {
        System.out.println("Skriv ID på medlem du vil ændre aktivitet for");
        int i = scan.nextInt();
        scan.nextLine();
        return i;
    }

    @Override
    public void visRestancer(ArrayList<Medlem> medlemmer) {
        for(Medlem m : medlemmer){
            System.out.println(m.toString());
        }
        System.out.println("____________________________");
        System.out.println("Skriv -1 for at returnere til menuen");
        boolean inputFormat = false;
            while(!inputFormat){
                String input = scan.nextLine();
                if(input.equals("-1")) {
                    inputFormat = true;
                }
                else{
                    System.out.println("Ugyldigt input, prøv igen:");
                }
                
            } 
        System.out.println("-----------------------------------------------");        
    }

    @Override
    public int opdaterKontigentsDato() {
        System.out.println("Skriv ID på medlem du vil opdatere kontigent på");
        int i = scan.nextInt();
        scan.nextLine();
        return i;    
    }

    @Override
    public void kontigentKvitering(int pris) {
        System.out.println("Prisen for kontigent fornyelse er: " + pris + "DKK. bekræft betaling med 1");
        scan.nextLine();
    }

    @Override
    public int hvilketMedlemÆndre() {
        
        System.out.println("Indtast ID på hvilket medlem vil du oprette træningstider for?");
        int i = scan.nextInt();
        scan.nextLine();
        return i;
    }
}
    
