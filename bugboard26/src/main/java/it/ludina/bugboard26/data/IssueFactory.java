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
    public static Issue create(int id, String title, String description, String issueType, PrioritaEnum priority, StatoEnum state) {
        Issue i = null;
        switch (issueType) {
            case "bug":
                i = new IssueBug(id, title, description, priority, state, "");
                break;
            case "documentation":
                i = new IssueDocumentation(id, title, description, priority, state, "");
                break;
            case "feature":
                i = new IssueFeature(id, title, description, priority, state, "");
                break;
            case "question":
                i = new IssueQuestion(id, title, description, priority, state, "");
                break;
            default:
                break;
        }

        return i;
    }
}
