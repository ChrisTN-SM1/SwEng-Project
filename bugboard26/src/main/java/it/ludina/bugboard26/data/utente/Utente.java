package it.ludina.bugboard26.data.utente;

import lombok.Getter;

public abstract class Utente {

    @Getter private String email;
    @Getter private String password;
}