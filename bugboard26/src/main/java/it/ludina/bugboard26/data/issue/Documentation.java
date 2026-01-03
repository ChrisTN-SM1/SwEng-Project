package it.ludina.bugboard26.data.issue;

import com.fasterxml.jackson.annotation.JsonTypeName;

import it.ludina.bugboard26.data.issue.enums.PriorityEnum;
import it.ludina.bugboard26.data.issue.enums.StatusEnum;

@JsonTypeName("documentation")
public class Documentation extends Issue {
    public Documentation() {
    }

    public Documentation(int idIssue, String titolo, String descrizione, PriorityEnum priorita, StatusEnum stato,
            String urlImmagine) {
        super(idIssue, titolo, descrizione, priorita, stato, urlImmagine);
    }

    public Documentation(String titolo, String descrizione, PriorityEnum priorita, String urlImmagine) {
        super(titolo, descrizione, priorita, urlImmagine);
    }

    @Override
    public String getIssueType() {
        return "documentation";
    }

}