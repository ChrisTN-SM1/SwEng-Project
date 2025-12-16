package it.ludina.bugboard26;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import it.ludina.bugboard26.dao.IssueDAO;
import it.ludina.bugboard26.dao.postgresql.PGIssueDAO;
import it.ludina.bugboard26.data.issue.Issue;
import it.ludina.bugboard26.data.issue.IssueBug;
import it.ludina.bugboard26.data.issue.IssueDocumentation;
import it.ludina.bugboard26.data.issue.IssueFeature;
import it.ludina.bugboard26.data.issue.IssueQuestion;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("issues")
public class IssueController {

    IssueDAO dao = new PGIssueDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getIssues() {

        try {
            return dao.getAllIssues();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    @Path("bug")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBug(IssueBug bug) {
        try {
            dao.add(bug);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("documentation")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDocumentation(IssueDocumentation documentation) {
        try {
            dao.add(documentation);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("feature")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFeature(IssueFeature feature) {
        try {
            dao.add(feature);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("question")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addQuestion(IssueQuestion question) {
        try {
            dao.add(question);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("archive")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setArchived(int id) {
        try {
            dao.setArchived(id);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("complete")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setCompleted(int id) {
        try {
            dao.setCompleted(id);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("assign")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response assignIssue(@QueryParam("id") int id, @QueryParam("users") String[] users) {
        try {
            dao.assignIssue(id, users);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

}
