package it.ludina.bugboard26;

import it.ludina.bugboard26.data.issue.IssueBug;
import it.ludina.bugboard26.data.issue.IssueDocumentation;
import it.ludina.bugboard26.data.issue.IssueFeature;
import it.ludina.bugboard26.data.issue.IssueQuestion;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/issues")
public class IssueController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/bug")
    public Response addBug(IssueBug bug){
        // TODO Implement
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/documentation")
    public Response addDocumentation(IssueDocumentation documentation){
        // TODO Implement
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/feature")
    public Response addFeature(IssueFeature feature){
        // TODO Implement
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/question")
    public Response addQuestion(IssueQuestion question){
        // TODO Implement
        return null;
    }
}
