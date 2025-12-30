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

    @Path("setarchived")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setArchived(Issue issue) {
        try {
            dao.setArchived(issue.getIdIssue());
            return Response.status(Response.Status.OK).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("setcompleted")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response setCompleted(Issue issue) {
        try {
            dao.setCompleted(issue.getIdIssue());
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

    @Path("assignedto/{idIssue}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAssignedTo(@PathParam("idIssue")int idIssue) {

        try {
            return dao.getAssignedTo(idIssue);
        } catch (SQLException e) {
            return Collections.emptyList();
        }

    }

        @Path("notassignedto/{idIssue}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getNotAssignedTo(@PathParam("idIssue")int idIssue) {

        try {
            return dao.getNotAssignedTo(idIssue);
        } catch (SQLException e) {
            return Collections.emptyList();
        }

    }

}
