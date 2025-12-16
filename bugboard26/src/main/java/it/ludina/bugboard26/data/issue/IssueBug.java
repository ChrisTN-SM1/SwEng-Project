package it.ludina.bugboard26.data.issue;

import com.fasterxml.jackson.annotation.JsonTypeName;

import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;

@JsonTypeName("bug")
public class IssueBug extends Issue {

    public IssueBug(){}

    public IssueBug(int idIssue, String titolo, String descrizione, PrioritaEnum priorita, StatoEnum stato,
            String urlImmagine) {
        super(idIssue, titolo, descrizione, priorita, stato, urlImmagine);
    }

    public IssueBug(String titolo, String descrizione, PrioritaEnum priorita, String urlImmagine) {
        super(titolo, descrizione, priorita, urlImmagine);
    }

    @Override
    public String getIssueType() {
        return "bug";
    }


}