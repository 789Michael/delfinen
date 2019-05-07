package Businesslogic;

import java.time.LocalDate;


public class TræningMedlem extends Medlem {
    private int træningBryst;
    private LocalDate brystDato;
    private int træningBfly;
    private LocalDate bfDato;
    private int træningCrawl;
    private LocalDate crawlDato;
    private int træningRcrawl;
    private LocalDate rcDato;
  
    
    public TræningMedlem(int id, String navn, LocalDate alder, String tlfNo, int træningBryst, LocalDate brystDato, int træningBfly, LocalDate bfDato, int træningCrawl, LocalDate crawlDato, int træningRcrawl, LocalDate rcDato) {
        super(id, navn, alder, tlfNo, true);
        this.træningBryst = træningBryst;
        this.træningBfly = træningBfly;
        this.træningCrawl = træningCrawl;
        this.træningRcrawl = træningRcrawl;
        this.brystDato = brystDato;
        this.bfDato = bfDato;
        this.crawlDato = crawlDato;
        this.rcDato = rcDato;
        
    }

    public int getTræningBryst() {
        return træningBryst;
    }

    public void setTræningBryst(int træningBryst) {
        this.træningBryst = træningBryst;
    }

    public LocalDate getBrystDato() {
        return brystDato;
    }

    public void setBrystDato(LocalDate brystDato) {
        this.brystDato = brystDato;
    }

    public int getTræningBfly() {
        return træningBfly;
    }

    public void setTræningBfly(int træningBfly) {
        this.træningBfly = træningBfly;
    }

    public LocalDate getBfDato() {
        return bfDato;
    }

    public void setBfDato(LocalDate bfDato) {
        this.bfDato = bfDato;
    }

    public int getTræningCrawl() {
        return træningCrawl;
    }

    public void setTræningCrawl(int træningCrawl) {
        this.træningCrawl = træningCrawl;
    }

    public LocalDate getCrawlDato() {
        return crawlDato;
    }

    public void setCrawlDato(LocalDate crawlDato) {
        this.crawlDato = crawlDato;
    }

    public int getTræningRcrawl() {
        return træningRcrawl;
    }

    public void setTræningRcrawl(int træningRcrawl) {
        this.træningRcrawl = træningRcrawl;
    }

    public LocalDate getRcDato() {
        return rcDato;
    }

    public void setRcDato(LocalDate rcDato) {
        this.rcDato = rcDato;
    }

    @Override
    public String toString() {
        String s;
        return "Tr\u00e6ningMedlem{" + "tr\u00e6ningBryst=" + træningBryst + ", brystDato=" + brystDato + ", tr\u00e6ningBfly=" + træningBfly + ", bfDato=" + bfDato + ", tr\u00e6ningCrawl=" + træningCrawl + ", crawlDato=" + crawlDato + ", tr\u00e6ningRcrawl=" + træningRcrawl + ", rcDato=" + rcDato + '}';
    }
    
    
}
