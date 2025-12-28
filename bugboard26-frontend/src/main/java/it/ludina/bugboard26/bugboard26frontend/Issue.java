package it.ludina.bugboard26.bugboard26frontend;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Issue {
    private int idIssue;
    private String title;
    private String description;
    private String issueType;
    private String priority;
    private String state;
    private String image;


    public Issue() {}


    public Issue(int id, String title, String description, String issueType, String priority, String state, String image) {
        this.idIssue = id;
        this.title = title;
        this.description = description;
        this.issueType = issueType;
        this.priority = priority;
        this.state = state;
        this.image = image;
    }
}
