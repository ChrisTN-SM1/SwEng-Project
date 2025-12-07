package it.ludina.bugboard26.dao;

import java.sql.SQLException;
import java.util.List;

import it.ludina.bugboard26.data.issue.Issue;

public interface IssueDAO {
    List<Issue> getAllIssues() throws SQLException;
}