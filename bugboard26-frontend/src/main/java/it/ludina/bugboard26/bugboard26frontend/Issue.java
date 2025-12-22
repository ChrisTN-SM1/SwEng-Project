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
    private String titolo;
    @JsonProperty("descrizione")
    private String descrizione;
    @JsonProperty("issueType")
    private String tipologia;
    @JsonProperty("priorita")
    private String priorita;
    @JsonProperty("stato")
    private String stato;
    @JsonProperty("urlImmagine")
    private String immagine;


    public Issue() {}


    public Issue(int id, String title, String description, String tipologia, String priorita, String stato, String immagine) {
        this.id = id;
        this.titolo = title;
        this.descrizione = description;
        this.tipologia = tipologia;
        this.priorita = priorita;
        this.stato = stato;
        this.immagine = immagine;
    }
}
