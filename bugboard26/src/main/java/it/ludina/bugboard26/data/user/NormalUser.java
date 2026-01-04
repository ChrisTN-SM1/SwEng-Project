package it.ludina.bugboard26.data.user;

public class NormalUser extends GenericUser {
    @Override
    public String getUserType() {
        return "normale";
    }
}