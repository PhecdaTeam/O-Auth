package pl.oucik.auth;

import org.bukkit.plugin.java.JavaPlugin;
import pl.oucik.auth.commands.ChangepassCommand;
import pl.oucik.auth.commands.LoginCommand;
import pl.oucik.auth.commands.RegisterCommand;
import pl.oucik.auth.config.Config;
import pl.oucik.auth.database.Database;
import pl.oucik.auth.listeners.*;
import pl.oucik.auth.managers.CaptchaManager;
import pl.oucik.auth.managers.UserManager;
import pl.oucik.auth.task.CaptchaTask;


public class OAuth extends JavaPlugin {

    //*------------------------------------------------------------------------------------------*//
    private Config config;
    private Database sql;
    private UserManager userManager;
    private CaptchaManager captchaManager;
    public CaptchaManager getCaptchaManager(){ return this.captchaManager; }
    public UserManager manager(){
        return this.userManager;
    }
    public Database getSql(){
        return this.sql;
    }
    public Config conf(){
        return this.config;
    }
    //*------------------------------------------------------------------------------------------*//

    @Override
    public void onEnable() {
        //*------------------------------------------------------------------------------------------*//
        this.saveDefaultConfig();
        (this.config = new Config(this)).load();
        //*------------------------------------------------------------------------------------------*//
        if ((this.sql = new Database(this)).connect()) {
            this.sql.update("CREATE TABLE IF NOT EXISTS OAuth (id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, name text NOT NULL, password text NOT NULL, lastIP text NOT NULL, registered int(1));");
        }
        //*------------------------------------------------------------------------------------------*//
        this.getCommand("register").setExecutor(new RegisterCommand(this));
        this.getCommand("login").setExecutor(new LoginCommand(this));
        this.getCommand("changepassword").setExecutor(new ChangepassCommand(this));
        //*------------------------------------------------------------------------------------------*//
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerCommandListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDropListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerInventoryOpenListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerBreakBlockListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDamageListener(this), this);
        //*------------------------------------------------------------------------------------------*//
        (this.userManager = new UserManager(this)).load();
        //*------------------------------------------------------------------------------------------*//
        this.captchaManager = new CaptchaManager();
        if(this.config.captcha) {
            new CaptchaTask(this).runTaskTimer(this, 40L, 40L);
        }
        //*------------------------------------------------------------------------------------------*//
    }

    @Override
    public void onDisable() {
        this.sql.disconnect();
    }

}
