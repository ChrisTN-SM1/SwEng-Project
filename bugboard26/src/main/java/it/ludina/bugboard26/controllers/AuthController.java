package it.ludina.bugboard26.controllers;

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
import it.ludina.bugboard26.dao.AuthDAO;
import it.ludina.bugboard26.dao.postgresql.PGAuthDAO;
import it.ludina.bugboard26.data.user.GenericUser;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("authentication")
public class AuthController {

    private AuthDAO dao = new PGAuthDAO();

    private static Dotenv env = Dotenv.load();

    private static final String ISSUER = "bugboard26-rest-api";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(env.get("ENCRIPTION_KEY"));
    private static final JWTVerifier VERIFIER = JWT.require(ALGORITHM).withIssuer(ISSUER).build();

    public static String getUsernameClaim(String token) {
        try {
            DecodedJWT decodedJWT = VERIFIER.verify(token);
            return decodedJWT.getClaim("username").asString();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createJWT(String username, long tokenDuration) {

        return JWT.create().withIssuer(ISSUER).withClaim("username", username).withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + tokenDuration))
                .withJWTId(UUID.randomUUID().toString()).sign(ALGORITHM);

    }

    public static boolean validateToken(String token) {
        try {
            VERIFIER.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(GenericUser user) {
        try {
            String result = dao.login(user);
            if (result.equals("invalid"))
                return Response.status(Response.Status.NOT_FOUND).build();

            String token = createJWT(user.getEmail(), TimeUnit.HOURS.toMillis(8));
            String entity = "{" + "\"userType\":\"" + result + "\"," + "\"token\":\"" + token + "\"" + "}";
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

}
