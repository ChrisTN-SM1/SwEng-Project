package it.ludina.bugboard26.data.issue;

import com.fasterxml.jackson.annotation.JsonTypeName;

import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;

@JsonTypeName("bug")
public class IssueBug extends Issue {

    public IssueBug(int idIssue, String titolo, String descrizione, PrioritaEnum priorita, StatoEnum stato,
            String urlImmagine) {
        super(idIssue, titolo, descrizione, priorita, stato, urlImmagine);
    }

    @Override
    public String getIssueType() {
        return "bug";
    }


}