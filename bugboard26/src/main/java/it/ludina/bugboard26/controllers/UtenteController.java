package it.ludina.bugboard26.controllers;

import java.sql.SQLException;

import it.ludina.bugboard26.dao.UserDAO;
import it.ludina.bugboard26.dao.postgresql.PGUserDAO;
import it.ludina.bugboard26.data.user.Admin;
import it.ludina.bugboard26.data.user.NormalUser;
import it.ludina.bugboard26.filters.RequireJWTAuthentication;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("user")
public class UtenteController {

	private UserDAO dao = new PGUserDAO();

	@RequireJWTAuthentication
	@Path("normal")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNormalUser(NormalUser user) {
		try {
			dao.add(user);
			return Response.status(Response.Status.CREATED).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@RequireJWTAuthentication
	@Path("admin")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAdminUser(Admin user) {
		try {
			dao.add(user);
			return Response.status(Response.Status.CREATED).build();
		} catch (SQLException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
}
