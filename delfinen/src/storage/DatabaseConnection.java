package storage;

import Businesslogic.Medlem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
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
           statement.executeUpdate("INSERT INTO medlem (mname, alder, tlfno) VALUES ('" + medlem.getNavn() + "','" + medlem.getFødselsdag().toString() + "','" + medlem.getTlfNo() + "');");
            
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
              //returnArray.add(new Medlem(id, navn, date.toLocalDate(), tlfNo));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Medlem> getRestancer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void opdaterKontigentsDato(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medlem getMedlemMedId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
