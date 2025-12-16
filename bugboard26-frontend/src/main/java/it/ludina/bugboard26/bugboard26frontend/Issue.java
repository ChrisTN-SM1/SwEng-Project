package it.ludina.bugboard26.bugboard26frontend;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Issue {
    private int id;
    private String titolo;
    private String descrizione;
    private String tipologia;
    private String priorita;
    private String stato;
    private String immagine;


    public Issue() {
    }

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
