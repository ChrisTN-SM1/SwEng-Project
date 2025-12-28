package it.ludina.bugboard26.data.issue;


import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class Issue {
    @Getter @Setter protected int idIssue;
    @Getter @Setter protected String title;
    @Getter @Setter protected String description;
    @Getter protected PrioritaEnum priority;
    @Getter @Setter protected StatoEnum state;

    @Getter @Setter protected String image;


    protected Issue(){}
    //Costruttore per il caricamento delle issue dal database
    protected Issue(int idIssue, String titolo, String descrizione, PrioritaEnum priorita, StatoEnum stato, String urlImmagine){
        this.idIssue = idIssue;
        this.title = titolo;
        this.description = descrizione;
        this.priority = priorita;
        this.state = stato;
        this.image = urlImmagine;
    }

    //Costruttore per la creazione di nuove issue
    protected Issue(String titolo, String descrizione, PrioritaEnum priorita, String urlImmagine){
        this.title = titolo;
        this.description = descrizione;
        this.priority = priorita;
        this.image = urlImmagine;
    }

    public void setPriority(PrioritaEnum priorita){
        if(priorita == null) this.priority = PrioritaEnum.NON_SPECIFICATA;
        else this.priority = priorita;
    }

    public abstract String getIssueType();
}  