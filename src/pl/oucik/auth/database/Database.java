package pl.oucik.auth.database;

import pl.oucik.auth.OAuth;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Database {


    public final ExecutorService executor = Executors.newScheduledThreadPool(10);
    private Connection connection;
    private final OAuth plugin;

    public Database(OAuth plugin) {
        this.plugin = plugin;
    }

    public boolean connect() {
        try {
            this.plugin.getLogger().info("Connecting to mysql database...");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + plugin.conf().host + ":" + plugin.conf().port + "/" + plugin.conf().base + "?autoReconnect=true", plugin.conf().user, plugin.conf().pass);
            this.plugin.getLogger().info("Connected to database successfully.");
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            this.plugin.getLogger().warning("Unable to connect to database. Error: " + e.getMessage());
            return false;
        }
    }

    public void update(String update) {
        executor.submit(() -> {
            try {
                connection.createStatement().executeUpdate(update);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void query(String query, QueryCallback callback) {
        executor.submit(() -> {
            try (ResultSet rs = connection.createStatement().executeQuery(query)) {
                callback.receivedResultSet(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void disconnect() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

    }

    public interface QueryCallback {
        void receivedResultSet(ResultSet rs) throws SQLException;
    }

}
