package it.ludina.bugboard26.data.utente;

public class UtenteAmministratore extends Utente {

    public UtenteAmministratore(){}

    public UtenteAmministratore(String email, String password){
        super(email, password);
    }

    @Override
    public String getUserType() {
        return "admin";
    }

}