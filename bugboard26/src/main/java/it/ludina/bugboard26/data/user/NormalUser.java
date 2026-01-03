package it.ludina.bugboard26.data.user;

public class NormalUser extends Utente {
    @Override
    public String getUserType() {
        return "normale";
    }
}