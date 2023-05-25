package org.example.db;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionProducer {

    @Produces
    private Connection createConnection() throws RuntimeException {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:derby:memory:idoldb;create=true","app", "app");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    private void closeConnection(@Disposes Connection connection) throws SQLException {
        connection.close();
    }
}
