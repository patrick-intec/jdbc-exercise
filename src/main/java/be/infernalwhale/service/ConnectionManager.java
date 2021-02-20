package be.infernalwhale.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager {
    Connection createConnection(String url, String user, String pwd) throws SQLException;
    Connection getConnection();
    void closeConnection() throws SQLException;
}
