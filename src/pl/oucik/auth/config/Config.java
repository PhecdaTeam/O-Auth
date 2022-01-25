package pl.oucik.auth.config;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import pl.oucik.auth.OAuth;

public class Config {

    OAuth plugin;
    public Config(OAuth plugin){
        this.plugin = plugin;
    }

    public boolean captcha;
    public String registered;
    public String logged;
    public String changepass;
    public String passchange;
    public String already_registered;
    public String already_logged;
    public String not_same_password;
    public String host;
    public String user;
    public String pass;
    public String base;
    public String port;
    public String login;
    public String register;
    public String welcome_format;
    public String quit_format;
    public String captcha_message;
    public Location spawn;
    public Integer spawn_x;
    public Integer spawn_y;
    public Integer spawn_z;
    public String prefix;
    public String invalid_captcha;
    public String invalid_password;
    public String not_logged;
    public String changed_pass;
    public String welcome_message;


    public void load() {
        this.welcome_format = plugin.getConfig().get("welcome_format").toString();
        this.welcome_message = plugin.getConfig().get("welcome_message").toString();
        this.quit_format = plugin.getConfig().get("quit_format").toString();
        this.registered = plugin.getConfig().get("registered").toString();
        this.logged = plugin.getConfig().get("logged").toString();
        this.changepass = plugin.getConfig().get("changepass").toString();
        this.passchange = plugin.getConfig().get("passchange").toString();
        this.already_registered = plugin.getConfig().get("already_registered").toString();
        this.not_same_password = plugin.getConfig().get("not_same_password").toString();
        this.already_logged = plugin.getConfig().get("already_logged").toString();
        this.host = plugin.getConfig().get("mysql.host").toString();
        this.user = plugin.getConfig().get("mysql.user").toString();
        this.pass = plugin.getConfig().get("mysql.pass").toString();
        this.base = plugin.getConfig().get("mysql.base").toString();
        this.port = plugin.getConfig().get("mysql.port").toString();
        this.login = plugin.getConfig().get("login").toString();
        this.register = plugin.getConfig().get("register").toString();
        this.captcha = plugin.getConfig().getBoolean("security.captcha");
        this.captcha_message = plugin.getConfig().get("security.captcha_message").toString();
        this.spawn_x = plugin.getConfig().getInt("Location.X");
        this.spawn_y = plugin.getConfig().getInt("Location.Y");
        this.spawn_z = plugin.getConfig().getInt("Location.Z");
        this.spawn = new Location(Bukkit.getWorlds().get(0), spawn_x, spawn_y, spawn_z);
        this.prefix = plugin.getConfig().get("prefix").toString();
        this.invalid_captcha = plugin.getConfig().get("security.invalid_captcha").toString();
        this.invalid_password = plugin.getConfig().get("invalid_password").toString();
        this.not_logged = plugin.getConfig().get("not_logged").toString();
        this.changed_pass = plugin.getConfig().get("changed_pass").toString();
        System.out.println("Successfully loaded config! [1/5]");
    }


}
