package it.ludina.bugboard26.data.user;

public class Admin extends Utente {
    public Admin() {
    }

    public Admin(String email, String password) {
        super(email, password);
    }

    @Override
    public String getUserType() {
        return "admin";
    }
}