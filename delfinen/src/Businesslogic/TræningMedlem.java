package Businesslogic;

import java.time.LocalDate;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */

public class TræningMedlem extends Medlem {
    private int træningBryst;
    private LocalDate brystDato;
    private int træningBfly;
    private LocalDate bfDato;
    private int træningCrawl;
    private LocalDate crawlDato;
    private int træningRcrawl;
    private LocalDate rcDato;
  
    
    public TræningMedlem(int id, String navn, LocalDate alder, String tlfNo, boolean aktivMedlem, int træningBryst, LocalDate brystDato, int træningBfly, LocalDate bfDato, int træningCrawl, LocalDate crawlDato, int træningRcrawl, LocalDate rcDato) {
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

        return "Bedste tider (Træning)|| " + "Bryst: " + træningBryst + " - " + brystDato + "| Butterfly:" + træningBfly + " - " + 
                bfDato + "| Crawl" + træningCrawl + " - " + crawlDato + "Rygcrawl" + træningRcrawl + " - " + rcDato + "|";
    }
    
    public String toString(int i) {
    StringBuilder sb = new StringBuilder();
    sb.append("Bedste tider (Træning)|| ");
    switch (i){
        case 1:
            sb.append(navn + "Bryst: " + træningBryst + " - " + brystDato);
            break;
        case 2:
            sb.append(navn + "Butterfly: " + træningBfly + " - " + bfDato);
            break;
        case 3: 
            sb.append(navn + "Crawl: " + træningCrawl + " - " + crawlDato);
            break;
        case 4: 
            sb.append(navn + "Rygcrawl: " + træningRcrawl + " - " + rcDato);
            break;
    }
    return sb.toString();
    }
    
    
}
