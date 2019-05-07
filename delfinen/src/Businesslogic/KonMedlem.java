package Businesslogic;

import java.time.LocalDate;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

public class KonMedlem extends Medlem {
    private int sID;
    private String sNavn;
    private int bryst;
    private int bPlads;
    private int bfly;
    private int bfPlads;
    private int crawl;
    private int cPlads;
    private int rcrawl;
    private int rcPlads;
    
    public KonMedlem(int id, String navn, LocalDate alder, String tlfNo, int sID, String sNavn, int bryst, int bPlads, int bfly, int bfPlads, int crawl, int cPlads, int rcrawl, int rcPlads) {
        super(id, navn, alder, tlfNo, true);
        this.sID = sID;
        this.sNavn = sNavn;
        this.bryst = bryst;
        this.bfly = bfly;
        this.crawl = crawl;
        this.rcrawl = rcrawl;
        this.bPlads = bPlads;
        this.bfPlads = bfPlads;
        this.cPlads = cPlads;
        this.rcPlads = rcPlads;
    }
    
}
