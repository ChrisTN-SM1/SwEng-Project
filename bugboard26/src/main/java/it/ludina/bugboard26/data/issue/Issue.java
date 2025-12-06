package it.ludina.bugboard26.data.issue;


import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class Issue {

    @Getter private int _idIssue;
    @Getter private String _titolo;
    @Getter private String _descrizione;
    @Getter private PrioritaEnum _priorita;
    @Getter private StatoEnum _stato;

    @Getter private String _urlImmagine;


    public abstract String get_issue_type();
}  