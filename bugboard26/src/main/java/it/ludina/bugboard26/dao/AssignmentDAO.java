package it.ludina.bugboard26.dao;

import java.sql.SQLException;
import java.util.List;

import it.ludina.bugboard26.data.Assignment;

public interface AssignmentDAO {
    public void assign(Assignment assignment)throws SQLException;
    public List<String> getAssignedTo(int idIssue) throws SQLException;
    public List<String> getNotAssignedTo(int idIssue) throws SQLException;
}
