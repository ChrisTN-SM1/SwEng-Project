package it.ludina.bugboard26.data.issue;

import it.ludina.bugboard26.data.issue.enums.PriorityEnum;
import it.ludina.bugboard26.data.issue.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Issue {
    protected int idIssue;
    protected String title;
    protected String description;
    protected PriorityEnum priority;
    protected StatusEnum state;
    protected String image;

    public Issue() {
    }

    public Issue(int idIssue) {
        this.idIssue = idIssue;
    }

    // Costruttore per il caricamento delle issue dal database
    public Issue(int idIssue, String titolo, String descrizione, PriorityEnum priorita, StatusEnum stato,
            String immagine) {
        this.idIssue = idIssue;
        this.title = titolo;
        this.description = descrizione;
        this.priority = priorita;
        this.state = stato;
        this.image = immagine;
    }

    // Costruttore per la creazione di nuove issue
    public Issue(String titolo, String descrizione, PriorityEnum priorita, String urlImmagine) {
        this.title = titolo;
        this.description = descrizione;
        this.priority = priorita;
        this.image = urlImmagine;
    }

    public void setPriority(PriorityEnum priorita) {
        if (priorita == null)
            this.priority = PriorityEnum.NON_SPECIFICATA;
        else
            this.priority = priorita;
    }

    public String getIssueType() {
        return "";
    }
}