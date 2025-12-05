package it.ludina.Issue;

import it.ludina.Enums.PrioritaEnum;
import it.ludina.Enums.StatoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class Issue {

    @Getter @Setter private int idIssue;
    @Getter @Setter private String titolo;
    @Getter @Setter private String descrizione;
    @Getter @Setter private PrioritaEnum priorita;
    @Getter @Setter private StatoEnum stato;

    @Getter @Setter private String urlImmagine;


    public abstract String get_issue_type();
}  