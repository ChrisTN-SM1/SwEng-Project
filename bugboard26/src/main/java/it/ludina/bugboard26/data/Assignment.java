package it.ludina.bugboard26.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Assignment {
    private int idIssue;
    private String[] emails;

    public Assignment() {
    }

    public Assignment(int idIssue, String[] emails) {
        this.idIssue = idIssue;
        this.emails = emails;
    }
}
