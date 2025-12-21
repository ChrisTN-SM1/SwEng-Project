package it.ludina.bugboard26.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;

public class PostgresConnection {
    private static PostgresConnection instance = null;

    private static Dotenv env = Dotenv.load();
    
    private static final String DB_USERNAME = env.get("DB_USERNAME");
    private static final String DB_PASSWORD = env.get("DB_PASSWORD");
    private static final String DB_IP = env.get("DB_IP");
    private static final String DB_PORT = env.get("DB_PORT");
    private static final String DB_NAME = env.get("DB_NAME");
    private String urlDatabase = "jdbc:postgresql://"+DB_IP+":"+DB_PORT+"/"+DB_NAME;
    
    @Getter private Connection connection = null;


    private PostgresConnection() throws SQLException {
        try {
			connection = DriverManager.getConnection(urlDatabase, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new  SQLException(e);
        }
    }

    public static PostgresConnection getInstance() throws SQLException{
        if(instance == null || instance.connection.isClosed()){
            instance = new PostgresConnection();
        }
        return instance;
    }

}
