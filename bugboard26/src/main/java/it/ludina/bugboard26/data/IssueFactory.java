package it.ludina.bugboard26.data;

import it.ludina.bugboard26.data.issue.Issue;
import it.ludina.bugboard26.data.issue.IssueBug;
import it.ludina.bugboard26.data.issue.IssueDocumentation;
import it.ludina.bugboard26.data.issue.IssueFeature;
import it.ludina.bugboard26.data.issue.IssueQuestion;
import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;

public class IssueFactory {
    private IssueFactory(){

    }
    public static Issue create(int id, String titolo, String tipologia, PrioritaEnum priorita, StatoEnum stato) {
        Issue i = null;
        switch (tipologia) {
            case "bug":
                i = new IssueBug(id, titolo, "", priorita, stato, "");
                break;
            case "documentation":
                i = new IssueDocumentation(id, titolo, "", priorita, stato, "");
                break;
            case "feature":
                i = new IssueFeature(id, titolo, "", priorita, stato, "");
                break;
            case "question":
                i = new IssueQuestion(id, titolo, "", priorita, stato, "");
                break;
            default:
                break;
        }

        return i;
    }
}
