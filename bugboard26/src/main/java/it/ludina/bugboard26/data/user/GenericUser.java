package it.ludina.bugboard26.data.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericUser {

    private String email;
    private String password;

    public GenericUser() {
    }

    public GenericUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getUserType() {
        return "";
    }
}