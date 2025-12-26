package it.ludina.bugboard26.data.utente;

public class UtenteAmministratore extends Utente {

    @Override
    public String getUserType() {
        return "admin";
    }

}