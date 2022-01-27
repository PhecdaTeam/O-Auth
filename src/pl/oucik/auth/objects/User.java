package pl.oucik.auth.objects;

import org.bukkit.entity.Player;
import pl.oucik.auth.OAuth;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private final OAuth plugin;
    public User(OAuth plugin, String name) {
        this.plugin = plugin;
        this.name = name;
    }
    private boolean logged;
    private boolean registered;
    private String lastIP;
    private String password;
    private final String name;
    public User(OAuth plugin, Player player) {
        this.plugin = plugin;
        this.name = player.getName();
        this.password = null;
        this.lastIP = player.getAddress().getAddress().getHostAddress();
        this.logged = false;
        this.registered = false;
        this.insert();
    }
    public User(OAuth plugin, ResultSet rs) throws SQLException {
        this.plugin = plugin;
        this.name = rs.getString("name");
        this.password = rs.getString("password");
        this.lastIP = rs.getString("lastIP");
        this.registered = rs.getInt("registered") == 1;
    }
    private void insert(){
        plugin.getSql().update("INSERT INTO OAuth (id, name, password, lastIP, registered) VALUES (NULL, '" + this.name + "', '" + this.password + "', '" + this.lastIP + "', '" + (this.registered ? 1 : 0) +"')");
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public boolean islogged(){
        return logged;
    }
    public boolean isRegistered(){
        return registered;
    }
    public void setPassword(String password) {
        this.password = password;
        plugin.getSql().update("UPDATE OAuth SET password='" + password + "' WHERE name='" + this.getName() + "'");
    }

    public void setRegistered(boolean registered1){
        this.registered=registered1;
        plugin.getSql().update("UPDATE OAuth SET registered='" + (registered1 ? 1 : 0) + "' WHERE name='" + this.getName() +"'");
    }

    public void setLogged(boolean logged1){
        this.logged=logged1;
    }
}
