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

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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
            return Collections.emptyList();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("bug")
    public Response addBug(IssueBug bug) {
        try {
            dao.add(bug);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("documentation")
    public Response addDocumentation(IssueDocumentation documentation) {
        try {
            dao.add(documentation);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("feature")
    public Response addFeature(IssueFeature feature) {
        try {
            dao.add(feature);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("question")
    public Response addQuestion(IssueQuestion question) {
        try {
            dao.add(question);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("archive")
    public Response setArchived(int id) {
        try {
            dao.setArchived(id);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("complete")
    public Response setCompleted(int id) {
        try {
            dao.setCompleted(id);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("assign")
    public Response assignIssue(@QueryParam("id") int id, @QueryParam("users") String[] users) {
        try {
            dao.assignIssue(id, users);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

}
