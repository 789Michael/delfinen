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
    
    
}
