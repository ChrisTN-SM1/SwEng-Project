package it.ludina.bugboard26.bugboard26frontend;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Issue {
    @JsonProperty("idIssue")
    private int id;
    @JsonProperty("titolo")
    private String title;
    @JsonProperty("descrizione")
    private String description;
    @JsonProperty("issueType")
    private String issueType;
    @JsonProperty("priorita")
    private String priority;
    @JsonProperty("stato")
    private String state;
    @JsonProperty("urlImmagine")
    private String image;


    public Issue() {}


    public Issue(int id, String title, String description, String issueType, String priority, String state, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.issueType = issueType;
        this.priority = priority;
        this.state = state;
        this.image = image;
    }
}
