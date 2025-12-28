package it.ludina.bugboard26;

import java.sql.SQLException;

import it.ludina.bugboard26.dao.UtenteDAO;
import it.ludina.bugboard26.dao.postgresql.PGUtenteDAO;
import it.ludina.bugboard26.data.utente.UtenteAmministratore;
import it.ludina.bugboard26.data.utente.UtenteNormale;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("user")
public class UtenteController {

	UtenteDAO dao = new PGUtenteDAO();

	@Path("normal")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNormalUser(UtenteNormale user) {
		try {
            dao.add(user);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
			e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
	}

	@Path("admin")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAdminUser(UtenteAmministratore user) {
		try {
            dao.add(user);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
	}
}
