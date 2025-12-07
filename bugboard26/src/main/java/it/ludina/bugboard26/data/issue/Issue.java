package it.ludina.bugboard26.data.issue;


import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class Issue {

    @Getter private int idIssue;
    @Getter private String titolo;
    @Getter private String descrizione;
    @Getter private PrioritaEnum priorita;
    @Getter private StatoEnum stato;

    @Getter private String urlImmagine;


    public abstract String getIssueType();
}  