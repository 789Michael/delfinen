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

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getsNavn() {
        return sNavn;
    }

    public void setsNavn(String sNavn) {
        this.sNavn = sNavn;
    }

    public int getBryst() {
        return bryst;
    }

    public void setBryst(int bryst) {
        this.bryst = bryst;
    }

    public int getbPlads() {
        return bPlads;
    }

    public void setbPlads(int bPlads) {
        this.bPlads = bPlads;
    }

    public int getBfly() {
        return bfly;
    }

    public void setBfly(int bfly) {
        this.bfly = bfly;
    }

    public int getBfPlads() {
        return bfPlads;
    }

    public void setBfPlads(int bfPlads) {
        this.bfPlads = bfPlads;
    }

    public int getCrawl() {
        return crawl;
    }

    public void setCrawl(int crawl) {
        this.crawl = crawl;
    }

    public int getcPlads() {
        return cPlads;
    }

    public void setcPlads(int cPlads) {
        this.cPlads = cPlads;
    }

    public int getRcrawl() {
        return rcrawl;
    }

    public void setRcrawl(int rcrawl) {
        this.rcrawl = rcrawl;
    }

    public int getRcPlads() {
        return rcPlads;
    }

    public void setRcPlads(int rcPlads) {
        this.rcPlads = rcPlads;
    }
    
}
