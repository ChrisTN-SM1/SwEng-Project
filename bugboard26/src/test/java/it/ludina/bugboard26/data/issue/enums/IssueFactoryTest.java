package it.ludina.bugboard26.data.issue.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import it.ludina.bugboard26.data.issue.Bug;
import it.ludina.bugboard26.data.issue.Documentation;
import it.ludina.bugboard26.data.issue.Feature;
import it.ludina.bugboard26.data.issue.Issue;
import it.ludina.bugboard26.data.issue.IssueFactory;
import it.ludina.bugboard26.data.issue.Question;

public class IssueFactoryTest {
    int id;
    String title;
    String description;
    String issueType;
    PriorityEnum priority = PriorityEnum.ALTA;
    StatusEnum state = StatusEnum.ASSEGNATO;
    

    @Test
    void testBug(){
        id = 10;
        title = "titolo";
        description = null;
        issueType = "bug";
        Issue issue = IssueFactory.create(id, title, description, issueType, priority, state);
        assertEquals(issue.getClass(), Bug.class);
    }

    @Test
    void testDocumentation(){
        id = -10;
        title = "";
        description = "";
        issueType = "documentation";
        Issue issue = IssueFactory.create(id, title, description, issueType, priority, state);
        assertEquals(issue.getClass(), Documentation.class);
    }

    @Test
    void testFeature(){
        id = 0;
        title = null;
        description = null;
        issueType = "feature";
        Issue issue = IssueFactory.create(id, title, description, issueType, priority, state);
        assertEquals(issue.getClass(), Feature.class);
    }

    @Test
    void testQuestion(){
        id = -3;
        title = "titolosecondo";
        description = "description";
        issueType = "question";
        Issue issue = IssueFactory.create(id, title, description, issueType, priority, state);
        assertEquals(issue.getClass(), Question.class);
    }

    @Test
    void testNull(){
        id = 7;
        title = "titoloterzo";
        description = "description";
        issueType = null;
        Issue issue = IssueFactory.create(id, title, description, issueType, priority, state);
        assertNull(issue);
    }

    @Test
    void testRandomString(){
        id = 50;
        title = "titoloquarto";
        description = "";
        issueType = "random string";
        Issue issue = IssueFactory.create(id, title, description, issueType, priority, state);
        assertNull(issue);
    }

    @Test
    void testEmptyString(){
        id = -32;
        title = "titoloquinto";
        description = "longverylongdescription";
        issueType = "";
        Issue issue = IssueFactory.create(id, title, description, issueType, priority, state);
        assertNull(issue);
    }
}
