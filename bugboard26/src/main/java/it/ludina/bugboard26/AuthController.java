package it.ludina.bugboard26;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import io.github.cdimascio.dotenv.Dotenv;
import it.ludina.bugboard26.dao.AuthenticationDAO;
import it.ludina.bugboard26.dao.postgresql.PGAuthenticationDAO;
import it.ludina.bugboard26.data.utente.Utente;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("authentication")
public class AuthController {

    AuthenticationDAO dao = new PGAuthenticationDAO();

    private static Dotenv env = Dotenv.load();

    private static final String ISSUER = "bugboard26-rest-api";
    private static final Algorithm algorithm = Algorithm.HMAC256(env.get("ENCRIPTION_KEY"));
    private static final JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();

    public static String getUsernameClaim(String token) {
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getClaim("username").asString();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createJWT(String username, long ttlMillis) {

        return JWT.create().withIssuer(ISSUER).withClaim("username", username).withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + ttlMillis)).withJWTId(UUID.randomUUID().toString())
                .sign(algorithm);

    }

    public static boolean validateToken(String token){
        try {
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Utente user){
        try {
            String result = dao.login(user);
            if(result.equals("invalid"))
                return Response.status(Response.Status.NOT_FOUND).build();

            String token = createJWT(user.getEmail(), TimeUnit.HOURS.toMillis(8));
            String entity = "{" +
                                "\"userType\":\"" + result + "\"," +
                                "\"token\":\"" + token + "\""+
                            "}";
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

}
