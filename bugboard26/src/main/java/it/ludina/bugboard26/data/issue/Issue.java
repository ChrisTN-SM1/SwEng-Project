package it.ludina.bugboard26.data.issue;


import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;
import lombok.Getter;


public abstract class Issue {

    protected Issue(int idIssue, String titolo, String descrizione, PrioritaEnum priorita, StatoEnum stato, String urlImmagine){
        this.idIssue = idIssue;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.priorita = priorita;
        this.stato = stato;
        this.urlImmagine = urlImmagine;
    }

    @Getter private int idIssue;
    @Getter private String titolo;
    @Getter private String descrizione;
    @Getter private PrioritaEnum priorita;
    @Getter private StatoEnum stato;

    @Getter private String urlImmagine;

    public abstract String getIssueType();
}  