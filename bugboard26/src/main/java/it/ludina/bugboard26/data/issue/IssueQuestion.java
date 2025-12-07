package it.ludina.bugboard26.data.issue;

import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;

public class IssueQuestion extends Issue{

    public IssueQuestion(int idIssue, String titolo, String descrizione, PrioritaEnum priorita, StatoEnum stato,
            String urlImmagine) {
        super(idIssue, titolo, descrizione, priorita, stato, urlImmagine);
    }

    @Override
    public String getIssueType() {
        return "question";
    }


}