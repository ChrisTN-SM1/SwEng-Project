package it.ludina.bugboard26.data.utente;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Utente {
    
    @Getter @Setter private String email;
    @Getter @Setter private String password;

    public Utente(){}

    public Utente(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getUserType() {
        return "";
    }
}