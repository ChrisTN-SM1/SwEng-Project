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
import it.ludina.bugboard26.filters.RequireJWTAuthentication;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("issues")
public class IssueController {

    IssueDAO dao = new PGIssueDAO();

    @RequireJWTAuthentication
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getIssues() {

        try {
            return dao.getIssueList();
        } catch (SQLException e) {
            return Collections.emptyList();
        }

    }

    @RequireJWTAuthentication
    @Path("archive")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getArchive() {

        try {
            return dao.getBugArchive();
        } catch (SQLException e) {
            return Collections.emptyList();
        }

    }

    @RequireJWTAuthentication
    @Path("bug")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBug(IssueBug bug) {
        try {
            dao.add(bug);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @RequireJWTAuthentication
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

    @RequireJWTAuthentication
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

    @RequireJWTAuthentication
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

    @RequireJWTAuthentication
    @Path("setarchived")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setArchived(Issue issue) {
        try {
            dao.setArchived(issue);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @RequireJWTAuthentication
    @Path("setcompleted")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setCompleted(Issue issue) {
        try {
            dao.setCompleted(issue);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("{idIssue}/getImage")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getImage(@PathParam("idIssue") int idIssue) {
        try {
            return dao.getImage(idIssue);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

}
