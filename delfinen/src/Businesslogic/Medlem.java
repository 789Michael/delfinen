package Businesslogic;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

public class Medlem {
    
    private int id;
    protected String navn;
    private LocalDate alder;
    private String tlfNo;
    private boolean aktivMedlem;
    private LocalDate kontigentsDato;
    
    public Medlem (int id, String navn, LocalDate alder, String tlfNo, boolean aktivMedlem) {
        this.id = id;
        this.navn = navn;
        this.alder = alder;
        this.tlfNo = tlfNo;
        this.aktivMedlem = aktivMedlem;
        kontigentsDato = LocalDate.now();
    }
    
    public Medlem (int id, String navn, LocalDate alder, String tlfNo, Boolean aktivMedlem, LocalDate kontigentsDato) {
        this.id = id;
        this.navn = navn;
        this.alder = alder;
        this.tlfNo = tlfNo;
        this.aktivMedlem = aktivMedlem;
        this.kontigentsDato = kontigentsDato;
    }

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public int getAlder() {
        return calculateAge(alder, LocalDate.now());
    }
    
    public LocalDate getFødselsdag(){
        return alder;
    }

    public String getTlfNo() {
        return tlfNo;
    }

    public boolean isAktivMedlem() {
        return aktivMedlem;
    }

    public void setAktivMedlem(boolean aktivMedlem) {
        this.aktivMedlem = aktivMedlem;
    }

    public LocalDate getKontigentsDato() {
        return kontigentsDato;
    }

    public void setKontigentsDato(LocalDate kontigentsDato) {
        this.kontigentsDato = kontigentsDato;
    }
    
    @Override
    public String toString() {
        return String.format("|ID: %2d |Navn: %16s| Alder: %02d | Tlf.: %s| Aktiv: %s| Kontigent Dato: %s |", id, trimNavn() , calculateAge(alder, LocalDate.now()), tlfNo , aktivMedlem, kontigentsDato );
 }
    
    private String trimNavn() {
        if(navn.length()>30) {
        return navn.substring(0,27)+"...";
    }
    return navn;
    }

    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
    