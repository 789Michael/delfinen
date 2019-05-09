package presentation;

import Businesslogic.KonMedlem;
import Businesslogic.Medlem;
import Businesslogic.TræningMedlem;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

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
        flushConsole();
        System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1. Opdater trænings tider");
        System.out.println("2. Indsæt Konkurrence tider");
        System.out.println("3. Vis 5 Svømmere");
        System.out.println("4. Vis Stævne resultater");
        System.out.println("-1. Gå tilbage");
    }


    @Override
    public String scanInputMenu() {
        return scan.nextLine();
    }

    
    @Override
    public String vælgNavn() {
        flushConsole();
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
        flushConsole();
        LocalDate localDate = null;
        while(localDate == null){
          try{
            System.out.println("Indtast fødselsår med format [ÅÅÅÅ]:");
            int årInput = scan.nextInt();
            System.out.println("Indtast fødselsmåned med format [MM]:");
            int mInput = scan.nextInt();
            System.out.println("Indtast fødselsdato med format [DD]:");
            int dInput = scan.nextInt();
            localDate = LocalDate.of(årInput, mInput, dInput);
            if(localDate.getYear() > LocalDate.now().getYear()){
                System.out.println("LORT");
                localDate = null;
                throw new IllegalArgumentException();
            }
        }catch(Exception e){
            flushConsole();  
              System.out.println("Ikke gyldigt input! prøv igen");
        }
        }
        scan.nextLine();
         return localDate;
    }

    @Override
    public int tlfNo() {
        flushConsole();
        boolean quit = false;
        int input = 0;
        while (!quit){
            try{
               System.out.println("Indtast telefonnummer:");
               input = Integer.parseInt(scan.nextLine());
               if(String.valueOf(input).length() != 8) throw new IllegalArgumentException();
               quit = true; 
            }
        catch(Exception e){
            flushConsole();
            System.out.println("Ikke Gyldigt Input, Prøv igen:");
            }
        }
        return input;
    }
    
    @Override
    public void notAnOption() {
        System.out.println("Ugyldigt input");
        System.out.println("-------------------------------------");
    }
    

    @Override
    public int fjernMedlem(ArrayList<Integer> ids) {
        boolean quit = false;
        int i = 0;
        while(!quit){
            try{
                System.out.println("Skriv ID på medlem du vil fjerne eller  -1 for at returnere");
                i = Integer.parseInt(scan.nextLine());
                if(i == -1 || ids.contains(i)){
                    quit = true;
                }else{
                    throw new IllegalArgumentException();
                }
            }catch(Exception e){
                System.out.println("Forkert Input, Prøv igen.");
            }
        }            
        return i;
    }

    @Override
    public void visMedlemmer(ArrayList<Medlem> medlemmer, boolean bypassRS) {
        flushConsole();
        for(Medlem m : medlemmer){
            System.out.println(m.toString());
        }
        System.out.println("_________________________________");
        if(!bypassRS){
        System.out.println("Skriv -1 for at returnere til menuen");
        boolean inputFormat = false;
            while(!inputFormat){
                String input = scan.nextLine();
                if(input.equals("-1")) {
                    inputFormat = true;
                    flushConsole();

                }
                else{
                    System.out.println("Ugyldigt input, prøv igen:");
                }
                
            }
        }
    }
    
    public boolean aktivMedlem(){
        boolean quit = false;
        boolean returnStatement = false;
        flushConsole();
        while(!quit){
            try{
                
                System.out.println("Tast 1 for aktivt medlem, 2 for passivMedlem");
                int input = Integer.parseInt(scan.nextLine());
                if(input == 1){
                    quit = true;
                    returnStatement = true;
                }else if(input == 2){
                    quit = true;
                }else{
                    throw new IllegalArgumentException();
                }
            }catch(Exception e){
                flushConsole();
                System.out.println("Forkert input, prøv igen!");
            }    
            }
        return returnStatement;
    }

    @Override
    public int ændreMedlemsAktivitet(ArrayList<Integer> ids) {
        boolean quit = false;
        int i = 0;
        while(!quit){
            try{
                System.out.println("Skriv ID på medlem du vil ændre aktivitet for eller  -1 for at returnere");
                i = Integer.parseInt(scan.nextLine());
                if(i == -1 || ids.contains(i)){
                    quit = true;
                }else{
                    throw new IllegalArgumentException();
                }
            }catch(Exception e){
                System.out.println("Forkert Input, Prøv igen.");
            }
        }            
        return i;
       }

    @Override
    public void visRestancer(ArrayList<Medlem> medlemmer) {
        flushConsole();
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
            flushConsole();
    }

    @Override
    public int opdaterKontigentsDato(ArrayList<Integer> ids) {
        boolean quit = false;
        int i = 0;
        while(!quit){
            try{
                System.out.println("Skriv ID på medlem du vil ændre aktivitet for eller  -1 for at returnere");
                i = Integer.parseInt(scan.nextLine());
                if(i == -1 || ids.contains(i)){
                    quit = true;
                }else{
                    throw new IllegalArgumentException();
                }
            }catch(Exception e){
                System.out.println("Forkert Input, Prøv igen.");
            }
        }            
        return i;
       }   

    @Override
    public int kontigentKvitering(int pris, Medlem m) {
        flushConsole();
        System.out.println("Du er ved at opdatere kontigentsdato for:");
        System.out.println(m.toString());
        System.out.println("Næste kontigents betaling er d." + m.getKontigentsDato().plusYears(1));
        System.out.println("Prisen for kontigent fornyelse er: " + pris + "DKK. bekræft betaling med 1");
        int i = 0;
        try{
            i = Integer.parseInt(scan.nextLine());
        }catch(Exception e){
            i = -1;
        }
        flushConsole();
        return i;
    }
    
    @Override
    public void visTop5Disciplin(ArrayList<TræningMedlem> tm, int i){
        flushConsole();
        for(TræningMedlem k : tm){
            System.out.println(k.toString(i));
        }
        System.out.println("____________________________");
        System.out.println("Skriv -1 for at returnere til menuen");
        boolean inputFormat = false;
            while(!inputFormat){
                String input = scan.nextLine();
                if(input.equals("-1")) {
                    inputFormat = true;
                    flushConsole();
                }
                else{
                    System.out.println("Ugyldigt input, prøv igen:");
                }
    }        
}

    public void flushConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    @Override
    public void printString(String s) {
        System.out.println(s);
    }


    public int hvilketMedlemÆndre(ArrayList<Integer> ids) {
        
        boolean quit = false;
        int i = 0;
        while(!quit){
            try{
                System.out.println("Skriv ID på medlem du vil opdatere tider for eller tast  -1 for at returnere");
                i = Integer.parseInt(scan.nextLine());
                if(i == -1 || ids.contains(i)){
                    quit = true;
                }else{
                    throw new IllegalArgumentException();
                }
            }catch(Exception e){
                System.out.println("Forkert Input, Prøv igen.");
            }
        }            
        return i;
        
 
    }

    @Override
    public void visTop5Disciplin() {
        System.out.println("1. for Brystsvømning");
        System.out.println("2. for Butterfly");
        System.out.println("3. for Crawl");
        System.out.println("4. for Rygcrawl");
        System.out.println("_________________________________");
        System.out.println("Skriv -1 for at returnere til menuen");
    }

    @Override
    public void visStævneResultater() {
        System.out.println("1. for Brystsvømning");
        System.out.println("2. for Butterfly");
        System.out.println("3. for Crawl");
        System.out.println("4. for Rygcrawl");
        System.out.println("_________________________________");
        System.out.println("Skriv -1 for at returnere til menuen");
    }

    @Override
    public void printStævneResultater(ArrayList<KonMedlem> kon) {
        flushConsole();
        for(KonMedlem k : kon){
            System.out.println(k.toString());
        }
        System.out.println("_________________________________");
        System.out.println("Skriv -1 for at returnere til menuen");
        boolean inputFormat = false;
            while(!inputFormat){
                String input = scan.nextLine();
                if(input.equals("-1")) {
                    inputFormat = true;
                    flushConsole();

                }
                else{
                    System.out.println("Ugyldigt input, prøv igen:");
                }
                
            }
        }
     public String printStævne(ArrayList<String> s) {
         flushConsole();
        for(String k : s){
            System.out.println(k);
        }
        System.out.println("_________________________________");
        System.out.println("Skriv -1 for at returnere til menuen");
        boolean inputFormat = false;
            String returnString = null;
            while(!inputFormat){
                try {
                    
                int input = Integer.parseInt(scan.nextLine());
                if(input==-1) {
                    inputFormat = true;
                    flushConsole();

                } else if (input > 0 || input <= s.size()) {
                  returnString = s.get(input-1);
                  inputFormat=true;
                }
                
                else {
                    throw new IllegalArgumentException();
                }
                
            } catch(Exception e) {
                    System.out.println("Ugyldigt input, prøv igen: ");
            }
     }  return returnString;
}     
    public int vælgBrystTid() {
    boolean quit = false;
        int input = 0;
        while (!quit){
            try{
               System.out.println("Indtast Bryst tid i sekunder:");
               input = Integer.parseInt(scan.nextLine());
               if(String.valueOf(input).length() > 8) throw new IllegalArgumentException();
               quit = true; 
            }
        catch(Exception e){
            flushConsole();
            System.out.println("Ikke Gyldigt Input, Prøv igen:");
            }
        }
        return input;
    }

    @Override
    public LocalDate vælgTræningDato() {
    LocalDate localDate = null;
        while(localDate == null){
          try{
            System.out.println("Indtast år for tidstagning med format [ÅÅÅÅ]:");
            int årInput = scan.nextInt();
            System.out.println("Indtast måned for tidstagning med format [MM]:");
            int mInput = scan.nextInt();
            System.out.println("Indtast dato for tidstagning med format [DD]:");
            int dInput = scan.nextInt();
            localDate = LocalDate.of(årInput, mInput, dInput);
            if(localDate.getYear() > LocalDate.now().getYear()){
                System.out.println("LORT");
                localDate = null;
                throw new IllegalArgumentException();
            }
        }catch(Exception e){
            flushConsole();  
              System.out.println("Ikke gyldigt input! prøv igen");
        }
        }
        scan.nextLine();
         return localDate;}

    @Override
    public int vælgBFtid() {
    boolean quit = false;
        int input = 0;
        while (!quit){
            try{
               System.out.println("Indtast Butterfly tid i sekunder:");
               input = Integer.parseInt(scan.nextLine());
               if(String.valueOf(input).length() > 8) throw new IllegalArgumentException();
               quit = true; 
            }
        catch(Exception e){
            flushConsole();
            System.out.println("Ikke Gyldigt Input, Prøv igen:");
            }
        }
        return input;}

    
    

    @Override
    public int vælgCrawlTid() {
    boolean quit = false;
        int input = 0;
        while (!quit){
            try{
               System.out.println("Indtast Crawl tid i sekunder:");
               input = Integer.parseInt(scan.nextLine());
               if(String.valueOf(input).length() > 8) throw new IllegalArgumentException();
               quit = true; 
            }
        catch(Exception e){
            flushConsole();
            System.out.println("Ikke Gyldigt Input, Prøv igen:");
            }
        }
        return input;}

    

    @Override
    public int vælgRCTid() {
    boolean quit = false;
        int input = 0;
        while (!quit){
            try{
               System.out.println("Indtast Rygcrawltid i sekunder:");
               input = Integer.parseInt(scan.nextLine());
               if(String.valueOf(input).length() > 8) throw new IllegalArgumentException();
               quit = true; 
            }
        catch(Exception e){
            flushConsole();
            System.out.println("Ikke Gyldigt Input, Prøv igen:");
            }
        }
        return input;}

    
    
}
    
