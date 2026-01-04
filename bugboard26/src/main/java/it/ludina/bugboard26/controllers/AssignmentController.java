package it.ludina.bugboard26.controllers;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import it.ludina.bugboard26.dao.AssignmentDAO;
import it.ludina.bugboard26.dao.postgresql.PGAssignmentDAO;
import it.ludina.bugboard26.data.Assignment;
import it.ludina.bugboard26.filters.RequireJWTAuthentication;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("assignment")
public class AssignmentController {
    private AssignmentDAO dao = new PGAssignmentDAO();

    @RequireJWTAuthentication
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response assignIssue(Assignment assignment) {
        try {
            dao.assign(assignment);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @RequireJWTAuthentication
    @Path("assignedto/{idIssue}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAssignedTo(@PathParam("idIssue") int idIssue) {

        try {
            return dao.getAssignedTo(idIssue);
        } catch (SQLException e) {
            return Collections.emptyList();
        }

    }

    @RequireJWTAuthentication
    @Path("notassignedto/{idIssue}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getNotAssignedTo(@PathParam("idIssue") int idIssue) {

        try {
            return dao.getNotAssignedTo(idIssue);
        } catch (SQLException e) {
            return Collections.emptyList();
        }

    }

}
