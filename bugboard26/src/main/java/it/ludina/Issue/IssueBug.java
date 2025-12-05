package it.ludina.Issue;

import it.ludina.Enums.PrioritaEnum;
import it.ludina.Enums.StatoEnum;

public class IssueBug extends Issue {

    public IssueBug(int idIssue, String titolo, String descrizione, PrioritaEnum priorita, StatoEnum stato,
            String urlImmagine) {
        super(idIssue, titolo, descrizione, priorita, stato, urlImmagine);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String get_issue_type() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get_issue_type'");
    }
}