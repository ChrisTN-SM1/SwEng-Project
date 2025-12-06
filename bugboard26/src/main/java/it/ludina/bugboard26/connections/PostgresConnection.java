package it.ludina.bugboard26.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;

public class PostgresConnection {
    private static PostgresConnection _instance = null;

    private Dotenv env = Dotenv.load();
    
    private final String DB_USERNAME = env.get("DB_USERNAME");
    private final String DB_PASSWORD = env.get("DB_PASSWORD");
    private final String DB_IP = env.get("DB_IP");
    private final String DB_PORT = env.get("DB_PORT");
    private final String DB_NAME = env.get("DB_NAME");
    private String urlDatabase = "jdbc:postgresql://"+DB_IP+":"+DB_PORT+"/"+DB_NAME;
    
    @Getter private Connection _connection = null;


    private PostgresConnection() {
        try {
			_connection = DriverManager.getConnection(urlDatabase, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PostgresConnection getInstance() throws SQLException{
        if(_instance == null || _instance._connection.isClosed()){
            _instance = new PostgresConnection();
        }
        return _instance;
    }

}
