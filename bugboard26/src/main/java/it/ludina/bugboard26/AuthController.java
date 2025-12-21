package it.ludina.bugboard26;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.ws.rs.Path;

@Path("auth")
public class AuthController {

    private AuthController(){}

    private static Dotenv env = Dotenv.load();

    private static final String ISSUER = "bugboard26-rest-api";
    private static final Algorithm algorithm = Algorithm.HMAC256(env.get("ENCRIPTION_KEY"));
    private static final JWTVerifier verifier = JWT.require(algorithm)
            .withIssuer(ISSUER)
            .build();
    

        public static String getUsernameClaim(String token) {
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getClaim("username").asString();
        } catch (JWTVerificationException _) {
            return null;
        }
    }
}
