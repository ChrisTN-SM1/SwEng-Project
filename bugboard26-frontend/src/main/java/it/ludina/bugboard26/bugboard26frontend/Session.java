package it.ludina.bugboard26.bugboard26frontend;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Session {
    private String token = null;
    private String userType = null;

    private static Session currentSession = null;


    private Session() {
    }


    public static Session getInstance() {
        if (currentSession == null) {
            currentSession = new Session();
        }
        return currentSession;
    }
}
