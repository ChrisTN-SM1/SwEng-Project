package it.ludina.bugboard26.data.issue;

import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;

public class IssueDocumentation extends Issue {

    public IssueDocumentation(int _idIssue, String _titolo, String _descrizione, PrioritaEnum _priorita,
            StatoEnum _stato, String _urlImmagine) {
        super(_idIssue, _titolo, _descrizione, _priorita, _stato, _urlImmagine);
    }

    @Override
    public String get_issue_type() {
        return "documentation";
    }


}