package it.ludina.bugboard26.dao;

import java.sql.SQLException;
import java.util.List;

import it.ludina.bugboard26.data.issue.Issue;

public interface IssueDAO {
    List<Issue> getAllIssues() throws SQLException;

    void add(Issue issue) throws SQLException;

    void setArchived(int id) throws SQLException;

    void setCompleted(int id) throws SQLException;

    void assignIssue(int id, String[] users) throws SQLException;
}