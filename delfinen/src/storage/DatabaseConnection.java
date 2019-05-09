package storage;

import Businesslogic.KonMedlem;
import Businesslogic.Medlem;
import Businesslogic.TræningMedlem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

public class DatabaseConnection implements StorageInterface {
    
    private Connection makeConnection() throws Exception {
        String user = "newuser";
        String password = "Aa12345678";
        String IP = "localhost";
        String PORT = "3306";
        String DATABASE = "delfin";
        String serverTimezone = "serverTimezone=UTC";
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?" + serverTimezone;
    
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void opretMedlem(Medlem medlem) {
        
        try {
           Connection connection = makeConnection();
           Statement statement = connection.createStatement();
           statement.executeUpdate("INSERT INTO medlem (mname, alder, tlfno, aktiv, kontigent) VALUES ('" + medlem.getNavn() + "','" + medlem.getFødselsdag().toString() + "','" + medlem.getTlfNo() + "'," + ((medlem.isAktivMedlem()) ? 1 : 0) + ",'" + medlem.getKontigentsDato()  + "');");
            
        }
        catch (Exception e){
            System.out.println("Fejl i opretMedlem: " + e.getMessage());
           
        }
    }

    @Override
    public void fjernMedlem(int id) {
        
        try {
           Connection connection = makeConnection();
           Statement statement = connection.createStatement();
           statement.executeUpdate("DELETE FROM medlem WHERE ID = " + id +";");
      
        }
        catch (Exception e) {
            System.out.println("Fejl i fjernMedlem: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Medlem> visMedlemmer() {
        try {
           Connection connection = makeConnection();
           Statement statement = connection.createStatement();
           ResultSet result = statement.executeQuery("SELECT * FROM medlem");
           
           ArrayList<Medlem> returnArray = new ArrayList();
           
           while (result.next()) {
              int id = result.getInt("ID");
              String navn = result.getString("MNAME");
              Date date = result.getDate("ALDER");
              String tlfNo = result.getString("TLFNO");
              Boolean aktiv = result.getBoolean("AKTIV");
              Date kontigent = result.getDate("KONTIGENT");
              returnArray.add(new Medlem(id, navn, date.toLocalDate(), tlfNo, aktiv, kontigent.toLocalDate()));
           }
           return returnArray;
           
        }
        catch (Exception e) {
            System.out.println("Fejl i visMedlemmer: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void ændreMedlemsAktivitet(int id) {
        try {
           Connection connection = makeConnection();
           Statement statement = connection.createStatement();
           statement.executeUpdate("UPDATE medlem SET AKTIV = " + ((getMedlemMedId(id).isAktivMedlem()) ? 0 : 1)  + " WHERE ID = " + id + ";");
      
        }
        catch (Exception e) {
            System.out.println("Fejl i ændreMedlemsAktivitet: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Medlem> getRestancer() {
        ArrayList<Medlem> alleMedlemmer = visMedlemmer();
              ArrayList<Medlem> returnArray = new ArrayList<Medlem>();
        for(Medlem m : alleMedlemmer){
            if(calculateDifference(m.getKontigentsDato(),LocalDate.now()) >= 1){
                returnArray.add(m);
            }
        }
        return returnArray;
    }
    
    private int calculateDifference(LocalDate kontigentsDato, LocalDate currentDate) {
        if ((kontigentsDato != null) && (currentDate != null)) {
            return Period.between(kontigentsDato, currentDate).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public void opdaterKontigentsDato(int id) {
        Medlem medlem = getMedlemMedId(id);
        try{
        Connection connection = makeConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE medlem SET kontigent = '" + medlem.getKontigentsDato().plusYears(1) + "' WHERE ID = " + id + ";");
        
        }catch(Exception e){
            System.out.println("fejl i opdater kontigent " + e.getMessage());
        }
    }

    @Override
    public Medlem getMedlemMedId(int id) {
       try {
           Connection connection = makeConnection();
           Statement statement = connection.createStatement();
           ResultSet result = statement.executeQuery("SELECT * FROM medlem WHERE ID = " + id + ";");
           
           result.next();
           return new Medlem(result.getInt("ID"), result.getString("MNAME"),result.getDate("ALDER").toLocalDate(), result.getString("TLFNO"), result.getBoolean("AKTIV"), result.getDate("KONTIGENT").toLocalDate() );
        }
        catch (Exception e) {
            System.out.println("Fejl i getMedlemMedID: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Medlem getTræningMedlemMedId(int id) {
       try {
           Connection connection = makeConnection();
           Statement statement = connection.createStatement();
           ResultSet result = statement.executeQuery("SELECT * FROM træningstider WHERE ID = " + id + ";");
           
           Medlem m = getMedlemMedId(id);
           System.out.println("test");
           result.next();
           System.out.println("test2");
           if(result == null){
               System.out.println("LORT");
           }
           int i = result.getInt("ID");
           System.out.println(i);
           int x = result.getInt("BRYST"); 
           System.out.println(x);
           LocalDate localdate = result.getDate("BRYSTDATO").toLocalDate();
           System.out.println(localdate);
           int z = result.getInt("BFLY"); 
           System.out.println(z);
           int y = result.getInt("CRAWL");
           System.out.println(y);
           int a = result.getInt("RCRAWL");
           System.out.println(a);
           TræningMedlem tm = new TræningMedlem(i, m.getNavn(), m.getFødselsdag(), m.getTlfNo(), x, localdate, z,y,a);
           //TræningMedlem tm = new TræningMedlem(result.getInt("ID"), m.getNavn(), m.getFødselsdag(), m.getTlfNo(), result.getInt("BRYST"),result.getDate("BRYSTDATO").toLocalDate(), result.getInt("BFLY"), result.getInt("CRAWL"), result.getInt("RCRAWL"));
           return tm;
       }
       
        catch (Exception e) {
            System.out.println("Fejl i getMedlemMedtrænningsID: " + e.getMessage());
            return null;
            
        }
    }

    @Override
    public ArrayList<TræningMedlem> visTop5(String a, String dato) {
        try {
        Connection connection = makeConnection();
        Statement statement = connection.createStatement();
         
        ResultSet result = statement.executeQuery("SELECT * FROM MEDLEM inner join træningstider on medlem.id=træningstider.id where " + dato + " is not null order by " + a + " limit 5;");
                      
        ArrayList<TræningMedlem> returnArray = new ArrayList();
           
        while (result.next()) {
            int id = result.getInt("ID");
            String navn = result.getString("MNAME");
            Date date = result.getDate("ALDER");
            String tlfNo = result.getString("TLFNO");
            int træningBryst = result.getInt("BRYST");
            Date brystDato = result.getDate("BRYSTDATO");
            int træningBfly = result.getInt("BFLY");
            Date bfDato = result.getDate("BFDATO");
            int træningCrawl = result.getInt("CRAWL");
            Date crawlDato = result.getDate("CRAWLDATO");
            int træningRcrawl = result.getInt("RCRAWL");
            Date rcDato = result.getDate("RCRAWLDATO");
            
            returnArray.add(new TræningMedlem(id, navn, date.toLocalDate(), tlfNo, træningBryst, brystDato.toLocalDate(), træningBfly, træningCrawl, træningRcrawl));
           }
           return returnArray;
           
        }
        catch (Exception e) {
            System.out.println("Fejl i visMedlemmer: " + e.getMessage());
            return null;
        }
    }
            @Override
            public void opdaterTræningsTider(TræningMedlem m){
            try {
            Connection connection = makeConnection();
            Statement statement = connection.createStatement();
            //statement.executeUpdate("INSERT INTO træningstider (ID, BRYST, BRYSTDATO, BFLY, CRAWL, RCRAWL) VALUES (" + træningmedlem.getId()+"," + træningmedlem.getTræningBryst()+ ",'" + træningmedlem.getBrystDato()+"'," træningmedlem.getTræningBfly()+ "," + træningmedlem.getTræningCrawl()+ træningmedlem.getTræningRcrawl()+",");
            //statement.executeUpdate("INSERT INTO træningstider (ID, BRYST, BRYSTDATO, BFLY, BFDATO, CRAWL, CRAWLDATO, RCRAWL, RCRAWLDATO) VALUES (" + m.getId()+ "," + m.getTræningBryst()+ ",'" + m.getBrystDato() + "'," + m.getTræningBfly()+ ",'"+ m.getBfDato()+ "',"+ m.getTræningCrawl()+ ",'"+ m.getCrawlDato()+"',"+m.getTræningRcrawl()+ ",'"+ m.getRcDato()+"');");
            statement.executeUpdate("UPDATE træningstider SET BRYST = "+ m.getTræningBryst() + ", BRYSTDATO = '" + m.getBrystDato() + "', BFLY = " + m.getTræningBfly() + ", CRAWL = " + m.getTræningCrawl() + ", RCRAWL = " + m.getTræningRcrawl() + " WHERE ID = " + m.getId() + ";" );
            }
                    catch (Exception e){
                        System.out.println("Fejl i Opdater Træningstider: " + e.getMessage());
                    }
                }

            @Override
            public void opdaterKonkurrenceTider(KonMedlem konmedlem){
            
            try { 
                Connection connection = makeConnection();
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO resultater (SID, ID, BRYST, BPLADS, BFLY, BFPLADS, CRAWL, CPLADS, RCRAWL, RCPLADS) VALUES (" + konmedlem.getsID()+"," + konmedlem.getId()+","+konmedlem.getBryst() + "," + konmedlem.getbPlads()+"," + konmedlem.getBfly()+ "," + konmedlem.getBfPlads()+ ","+ konmedlem.getCrawl()+ konmedlem.getcPlads()+ "," + konmedlem.getRcrawl()+ "," + konmedlem.getRcPlads());
            }
            catch (Exception e) {
                System.out.println("Fejl i opdater konkurrencetider: " + e.getMessage());
            }
            
        }
        
        @Override
        public int højesteMedlemsId() {
            
            try {
                Connection connection = makeConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT MAX(ID) FROM medlem;");
                result.next();
                return result.getInt(1);
            }
            catch(Exception e) {
                System.out.println("maxOrdreNummer - " + e.getMessage());
                return -1;
            }
                    
        }

    @Override
    public ArrayList<Integer> getIDs() {
        try {
           Connection connection = makeConnection();
           Statement statement = connection.createStatement();
           ResultSet result = statement.executeQuery("SELECT ID FROM medlem");
           
           ArrayList<Integer> returnArray = new ArrayList();
           
           while (result.next()) {
              returnArray.add(result.getInt("ID"));
           }
           return returnArray;
           
        }
        catch (Exception e) {
            System.out.println("Fejl i visMedlemmer: " + e.getMessage());
            return null;
        }
    }
}
