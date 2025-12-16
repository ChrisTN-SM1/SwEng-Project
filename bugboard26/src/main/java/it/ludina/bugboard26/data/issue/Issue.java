package it.ludina.bugboard26.data.issue;


import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class Issue {
    @Getter @Setter protected int idIssue;
    @Getter @Setter protected String titolo;
    @Getter @Setter protected String descrizione;
    @Getter protected PrioritaEnum priorita;
    @Getter @Setter protected StatoEnum stato;

    @Getter @Setter protected String urlImmagine;


    protected Issue(){}
    //Costruttore per il caricamento delle issue dal database
    protected Issue(int idIssue, String titolo, String descrizione, PrioritaEnum priorita, StatoEnum stato, String urlImmagine){
        this.idIssue = idIssue;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.priorita = priorita;
        this.stato = stato;
        this.urlImmagine = urlImmagine;
    }

    //Costruttore per la creazione di nuove issue
    protected Issue(String titolo, String descrizione, PrioritaEnum priorita, String urlImmagine){
        this.titolo = titolo;
        this.descrizione = descrizione;
        if(priorita == null) this.priorita = PrioritaEnum.NON_SPECIFICATA;
        else this.priorita = priorita;
        this.urlImmagine = urlImmagine;
    }

    public void setPriorita(PrioritaEnum priorita){
        if(priorita == null) this.priorita = PrioritaEnum.NON_SPECIFICATA;
        else this.priorita = priorita;
    }

    public abstract String getIssueType();
}  