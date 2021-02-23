package be.infernalwhale.service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The ConnectionManager will manage (initiate, close and provide) the database connection.
 *
 * The url, user(name) and password (pwd) will be provided from the view layer. The implementation for this interface
 * should be able to instantiate, hold a reference off and eventually close the connection.
 */
public interface ConnectionManager {
    Connection createConnection(String url, String user, String pwd) throws SQLException;
    Connection getConnection();
    void closeConnection() throws SQLException;
}
