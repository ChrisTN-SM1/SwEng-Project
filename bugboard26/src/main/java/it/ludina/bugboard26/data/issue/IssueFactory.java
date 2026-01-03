package it.ludina.bugboard26.data.issue;

import it.ludina.bugboard26.data.issue.enums.PriorityEnum;
import it.ludina.bugboard26.data.issue.enums.StatusEnum;

public class IssueFactory {
    private IssueFactory() {
    }

    public static Issue create(int id, String title, String description, String issueType, PriorityEnum priority,
            StatusEnum state) {
        Issue i = null;
        switch (issueType) {
        case "bug":
            i = new Bug(id, title, description, priority, state, "");
            break;
        case "documentation":
            i = new Documentation(id, title, description, priority, state, "");
            break;
        case "feature":
            i = new Feature(id, title, description, priority, state, "");
            break;
        case "question":
            i = new Question(id, title, description, priority, state, "");
            break;
        default:
            break;
        }

        return i;
    }
}
