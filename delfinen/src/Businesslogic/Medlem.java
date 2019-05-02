package Businesslogic;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;


public class Medlem {
    
    private int id;
    private String navn;
    private LocalDate alder;
    private String tlfNo;
    
    public Medlem (int id, String navn, LocalDate alder, String tlfNo) {
        this.id=id;
        this.navn=navn;
        this.alder=alder;
        this.tlfNo=tlfNo;
    }

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getAlder() {
        return alder;
    }

    public String getTlfNo() {
        return tlfNo;
    }

    @Override
    public String toString() {
        return "MEDLEM: " + "ID = " + id + "| Navn = " + navn + "| Alder = " + alder + "| Telefon = " + tlfNo + "|";
    }
    
    
}
